package priv.sunyj.sms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.sunyj.sms.bean.Course;
import priv.sunyj.sms.bean.Msg;
import priv.sunyj.sms.service.impl.ClaServiceImpl;

@Controller
@CrossOrigin
public class ClaController {
    @Autowired
    private ClaServiceImpl claService;

    @ResponseBody
    @RequestMapping(value = "/courCreate", method = RequestMethod.POST)
    public Msg courCreate(@RequestBody Course course) {
        int i = claService.courCreate(course);
        if (1 == 0) {
            return Msg.fail();
        }
        return Msg.success();
    }
}
