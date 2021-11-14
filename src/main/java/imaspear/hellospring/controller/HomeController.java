package imaspear.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Imaspear on 2021-10-25
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
