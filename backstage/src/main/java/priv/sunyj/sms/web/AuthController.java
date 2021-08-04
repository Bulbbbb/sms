package priv.sunyj.sms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.sunyj.sms.bean.AuthPower;
import priv.sunyj.sms.bean.Msg;
import priv.sunyj.sms.service.impl.AuthServiceImpl;

import java.util.List;

@CrossOrigin
@Controller
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @ResponseBody
    @RequestMapping(value = "/getAuth",method = RequestMethod.GET)
    public Msg getAuth(){
        List<AuthPower> auth = authService.getAuth();
        return Msg.success().add("auth",auth);
    }

}
