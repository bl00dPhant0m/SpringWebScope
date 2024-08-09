package org.spring.springwebscope.Controller;

import org.spring.springwebscope.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping(value = "/log-into")
    public String getViewAutnificationOrMenu(Model model) {
        if (loginProcessor.isAutinification()){
            model.addAttribute("message", "You are already logged in");
            return "result";
        }else{
            return "autification";
        }
    }

    @PostMapping(value = "/log-into")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        loginProcessor.setLogin(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.Login();

        if (loggedIn || loginProcessor.isAutinification()){
            model.addAttribute("message", "Вы успешно зарегистрировались");
            loginProcessor.setAutinification(true);

        }else {
            model.addAttribute("message", "логин или пароль не верны");
        }
        return "result";


    }
}
