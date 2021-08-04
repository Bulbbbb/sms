package priv.sunyj.sms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.sunyj.sms.bean.Msg;
import priv.sunyj.sms.bean.XuanKe;
import priv.sunyj.sms.service.XuanKeService;
import priv.sunyj.sms.service.impl.XuanKeServiceImpl;

import java.util.List;

@Controller
@CrossOrigin
public class XuankeController {

    @Autowired
    private XuanKeServiceImpl xuanKeService;

    @ResponseBody
    @RequestMapping(value = "/addXuanke", method = RequestMethod.POST)
    public Msg addXuanke(@RequestBody XuanKe xuanKe) {
        int i = xuanKeService.addXuanke(xuanKe);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/getXuanke/{sNum}/{cNum}", method = RequestMethod.GET)
    public Msg getXuanke(@PathVariable("sNum") String sNum, @PathVariable("cNum") String cNum) {
        List<XuanKe> xuanke = xuanKeService.getXuanke(sNum, cNum);
        return Msg.success().add("xuanKe", xuanke);
    }
}
