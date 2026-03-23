package codigo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    public PublicController() {
    }

    @GetMapping("/home")
    public String home(){return "Public Home";}

}
