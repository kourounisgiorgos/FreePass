package gr.hua.freepass;

import gr.hua.freepass.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepo;

    @PostMapping(path="/saveUser",consumes = {"application/json"})
    public void saveUserData(@RequestBody User[] user){
        userRepo.save(user[0]);
    }
}
