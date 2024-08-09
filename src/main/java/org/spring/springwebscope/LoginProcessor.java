package org.spring.springwebscope;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
public class LoginProcessor{
    private boolean isAutinification = false;
    private String login;
    private String password;

    public boolean Login(){
        String login = this.login;
        String password = this.password;

        if(login.equals("admin") && password.equals("123456")){
            return true;
        }else {
            return false;
        }
    }
}
