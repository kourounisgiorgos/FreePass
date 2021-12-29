package gr.hua.freepass;

import gr.hua.freepass.models.Citizen;
import gr.hua.freepass.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CitizenController {
    @Autowired
    CitizenRepository citizenRepo;

    @Autowired
    UserRepository userRepo;

    @PostMapping(path="/saveCitizen",consumes = {"application/json"})
    public void saveCitizenData(@RequestBody Citizen[] citizen){
        Optional<User> user = userRepo.findByUserName(citizen[0].getUserName());

        citizen[0].setUser(user.get());
        citizenRepo.save(citizen[0]);
    }
}
