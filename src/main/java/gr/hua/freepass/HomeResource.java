package gr.hua.freepass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeResource {

    @RequestMapping("/")
    public String home() {
        return ("register.html");
    }

    @RequestMapping("/citizen")
    public String citizen() {
        return ("<h1>Welcome User</h1>");
    }

    @RequestMapping("/oaed")
    public String oaed() {
        return ("oaed_page.html");
    }

    @RequestMapping("/oasa")
    public String oasa() {
        return ("oaed_page.html");
    }
}

