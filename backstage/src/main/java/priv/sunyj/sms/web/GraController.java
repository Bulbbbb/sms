package priv.sunyj.sms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.sunyj.sms.bean.Msg;
import priv.sunyj.sms.bean.StuCour;
import priv.sunyj.sms.service.impl.GraServiceImpl;

import java.util.Calendar;
import java.util.List;

@Controller
@CrossOrigin
public class GraController {

    @Autowired
    private GraServiceImpl graService;

    @ResponseBody
    @RequestMapping(value = "graCreat/{stu}/{cour}/{school}/{cla}/{gra}/{year}", method = RequestMethod.GET)
    public Msg graCreat(@PathVariable("stu") String stu,
                        @PathVariable("cour") String cour,
                        @PathVariable("school") String school,
                        @PathVariable("cla") String cla,
                        @PathVariable("gra") String gra,
                        @PathVariable("year") String year) {
        Calendar calendar = Calendar.getInstance();
        int i = graService.graCreat(stu, cour, year, school, cla, gra);
        if (i != 1) {
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 查询所有人的成绩
     * @return
     */
    @RequestMapping(value = "/getGra", method = RequestMethod.GET)
    @ResponseBody
    public List<StuCour> getGra() {
        List<StuCour> gra = graService.getGra();
        return gra;
    }

    /**
     * 查询个人成绩
     * @param year
     * @param school
     * @return
     */
    @RequestMapping(value = "/getAGra/{name}/{year}/{school}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getAGra(@PathVariable("name") String name,
                                 @PathVariable("year") String year,
                                 @PathVariable("school")String school) {
        List<StuCour> gra = graService.getAGra(name,year, school);
        return Msg.success().add("gra",gra);
    }

}