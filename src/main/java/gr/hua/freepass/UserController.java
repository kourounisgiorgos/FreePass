package gr.hua.freepass;

import gr.hua.freepass.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(path="/saveUser",consumes = {"application/json"})
    public void saveUserData(@RequestBody User[] user){

        boolean userExists = userRepo.findByUserName(user[0].getUserName()).isPresent();

        if(!userExists){
            userRepo.save(user[0]);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your have already registered");
        }
    }
}

