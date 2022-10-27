package org.gus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam (value = "name", required = false) String name,
                            @RequestParam (value = "surname", required = false) String surname,
                            Model model){
        //System.out.println("Hello, " + name +" " + surname);
        model.addAttribute("message","Hello, " + name +" " + surname );
    return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
   public String calculator(@RequestParam(value = "a") int a,
                            @RequestParam(value = "b") int b,
                            @RequestParam("action") String action,
                            Model model){
        if (action.equals("addition"))
            model.addAttribute("message", a+b);
        if (action.equals("multiplication"))
            model.addAttribute("message", a*b);
        if (action.equals("subtraction"))
            model.addAttribute("message", a-b);
        if (action.equals("division"))
            model.addAttribute("message", a/b);

        return "first/calculator";
   }
}
