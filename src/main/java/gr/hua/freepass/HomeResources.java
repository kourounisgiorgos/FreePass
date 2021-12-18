package gr.hua.freepass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResources {

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/citizen")
    public String citizen(){
        return ("<h1>Welcome FUCK YOU</h1>");
    }

    @GetMapping("/oaed")
    public String oaed(){
        return ("<h1>AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA</h1>");
    }

    @GetMapping("/oasa")
    public String oasa(){
        return ("<h1>AAAAbA</h1>");
    }
}
