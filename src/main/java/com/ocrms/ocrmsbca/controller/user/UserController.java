package com.ocrms.ocrmsbca.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/landing")
    public String landingPage(){
        return "user/userHome";
    }

}
