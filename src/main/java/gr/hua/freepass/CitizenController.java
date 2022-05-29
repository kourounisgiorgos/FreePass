package gr.hua.freepass;

import gr.hua.freepass.models.Citizen;
import gr.hua.freepass.models.EmailController;
import gr.hua.freepass.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Optional;

@RestController
public class CitizenController {
    @Autowired
    CitizenRepository citizenRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    ApplicationRepository appRepo;

    @PostMapping(path="/saveCitizen",consumes = {"application/json"})
    public void saveCitizenData(@RequestBody Citizen[] citizen){
        Optional<User> user = userRepo.findByUserName(citizen[0].getUserName());

        citizen[0].setUser(user.get());
        citizenRepo.save(citizen[0]);
    }

    @PutMapping(value="/oaed/updateCitizen/{user_name}")
    public void updateCitizen(@RequestBody String status, @PathVariable String user_name) throws MessagingException {
        Citizen updateCitizen =citizenRepo.findByUserName(user_name);
        updateCitizen.setStatus(status);
        citizenRepo.save(updateCitizen);
        appRepo.delete(appRepo.findByUserName(user_name));
        EmailController.sendEmail(updateCitizen.getEmail(), "Application update", "Your application status has been updated. Please log in :)");
    }

    @PutMapping(value="/oasa/enableCitizenPass/{user_name}")
    public void enableCitizenPass(@RequestBody String durationAndCode, @PathVariable String user_name) throws MessagingException {
        String[] parts = durationAndCode.split("-");

        Citizen updateCitizen =citizenRepo.findByUserName(user_name);
        updateCitizen.setDuration(parts[1]);
        updateCitizen.setPassCode(parts[0]);
        citizenRepo.save(updateCitizen);
        EmailController.sendEmail(updateCitizen.getEmail(), "Password enabled", "Your free pass has been enabled.!!1111");

    }
}
