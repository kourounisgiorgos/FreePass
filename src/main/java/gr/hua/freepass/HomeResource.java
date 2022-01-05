package gr.hua.freepass;

import gr.hua.freepass.models.Application;
import gr.hua.freepass.models.Citizen;
import gr.hua.freepass.models.MyUserDetails;
import gr.hua.freepass.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeResource {

    @Autowired
    CitizenRepository citizenRepo;

    @Autowired
    ApplicationRepository appRepo;

    @RequestMapping("/")
    public String home() {
        return ("register");
    }

    @GetMapping("/citizen")
    public String citizen(@AuthenticationPrincipal MyUserDetails user , Model model) {

        Citizen citizen = citizenRepo.findByUserName(user.getUsername());
        model.addAttribute("citizen",citizen);
        return ("citizen_page");
    }

    @RequestMapping("/admin")
    public String admin(){
        return("admin_page");
    }

    @RequestMapping("/oaed")
    public String oaed(Model model) {
        List<Application> allApplications = appRepo.findAll();
        model.addAttribute("applications",allApplications);
        return ("oaed_page");
    }

    @RequestMapping("/oasa")
    public String oasa() {
        return ("oaed_page.html");
    }
}

