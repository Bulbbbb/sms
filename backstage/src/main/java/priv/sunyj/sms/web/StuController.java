package priv.sunyj.sms.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.sunyj.sms.bean.Msg;
import priv.sunyj.sms.bean.Student;
import priv.sunyj.sms.service.impl.StuServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class StuController {

    @Autowired
    private StuServiceImpl stuService;

    /**
     * 分页获取学生列表
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/getStus/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getStus(@PathVariable("page") int page) {
        PageHelper.startPage(page, 5);
        List<Student> stus = stuService.getStus();
        PageInfo pageInfo = new PageInfo(stus, 5);
        return Msg.success().add("stus", pageInfo);
    }

    /**
     * 通过班级获取学生列表
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/getStusForCla/{cla}/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getStusForCla(@PathVariable("page") int page, @PathVariable("cla") String cla) {
        PageHelper.startPage(page, 5);
        List<Student> stus = stuService.getStusForCla(cla);
        PageInfo pageInfo = new PageInfo(stus, 5);
        return Msg.success().add("stus", pageInfo);
    }

    /**
     * 创建学生
     *
     * @param name
     * @param num
     * @param year
     * @param ins
     * @param maj
     * @param cla
     * @return
     */
    @RequestMapping(value = "/stuCreate/{name}/{num}/{year}/{ins}/{maj}/{cla}", method = RequestMethod.GET)
    @ResponseBody
    public Msg stuCreate(@PathVariable("name") String name,
                         @PathVariable("num") String num,
                         @PathVariable("year") String year,
                         @PathVariable("ins") String ins,
                         @PathVariable("maj") String maj,
                         @PathVariable("cla") String cla) {
        int i = stuService.stuCreate(name, num, year, ins, maj, cla);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 批量插入学生信息
     *
     * @param students
     * @return
     */
    @RequestMapping(value = "/studentBat", method = RequestMethod.POST)
    @ResponseBody
    public Msg studentBat(@RequestBody ArrayList<Student> students) {
        int i = stuService.addStu(students);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success().add("row", i);
    }

    /**
     * 创建单个学生
     * @param student
     * @return
     */
    @RequestMapping(value = "/addAStu", method = RequestMethod.POST)
    @ResponseBody
    public Msg addAStu(@RequestBody Student student){
        int i = stuService.addAStu(student);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success().add("row", i);
    }
}
