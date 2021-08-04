package priv.sunyj.sms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.sunyj.sms.bean.AuthPower;
import priv.sunyj.sms.bean.Msg;
import priv.sunyj.sms.service.impl.PowerServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class PowerController {

    @Autowired
    private PowerServiceImpl powerService;

    @RequestMapping(value = "/getPowers/{auth}",method = RequestMethod.GET)
    @ResponseBody
    public  Msg getPowers(@PathVariable("auth") String auth){
        List<AuthPower> powers = powerService.getPowers(auth);
        if (!powers.isEmpty()){
            return Msg.success().add("power",powers);
        }
        return Msg.fail();
    }

}
