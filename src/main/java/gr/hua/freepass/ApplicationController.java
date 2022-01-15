package gr.hua.freepass;

import gr.hua.freepass.models.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class ApplicationController {
    @Autowired
    ApplicationRepository appRepo;

    @PostMapping(path="/citizen/saveApplication",consumes = {"application/json"})
    public void saveApplicationData(@RequestBody Application[] app){

        Application application = appRepo.findByUserName(app[0].getUserName());

        if(application == null){
            appRepo.save(app[0]);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your have already submitted your application");
        }
    }
}
