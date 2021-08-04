package priv.sunyj.sms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.sunyj.sms.bean.*;
import priv.sunyj.sms.bean.Class;
import priv.sunyj.sms.service.impl.InsServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller
public class InsController {

    @Autowired
    private InsServiceImpl insService;


    /**
     * 创建专业
     *
     * @param name
     * @param num
     * @param major
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/majCreate/{name}/{num}/{major}", method = RequestMethod.GET)
    public Msg majCreate(@PathVariable("name") String name, @PathVariable("num") String num, @PathVariable("major") String major) {
        int i = insService.majCreate(name, num, major);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 创建学院
     *
     * @param name
     * @param num
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insCreat/{name}/{num}", method = RequestMethod.GET)
    public Msg insCreat(@PathVariable("name") String name, @PathVariable("num") String num) {
        int i = insService.insCreate(name, num);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 查询所有学院
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getIns", method = RequestMethod.GET)
    public Msg getIns() {
        List<Institution> ins = insService.getIns();
        if (ins.isEmpty()) {
            return Msg.fail();
        }
        return Msg.success().add("ins", ins);
    }

    /**
     * 查询所有班级
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getcla", method = RequestMethod.GET)
    public Msg getcla() {
        List<Class> cla = insService.getcla();
        if (cla.isEmpty()) {
            return Msg.fail();
        }
        return Msg.success().add("cla", cla);
    }

    /**
     * 通过学院查询专业
     *
     * @param ins
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMaj/{ins}", method = RequestMethod.GET)
    public Msg getMaj(@PathVariable("ins") String ins) {
        List<Major> majs = insService.getMajs(ins);
        return Msg.success().add("majs", majs);
    }

    /**
     * 创建班级
     *
     * @param name
     * @param num
     * @param ins
     * @param major
     * @return
     */
    @RequestMapping(value = "/claCreate/{cName}/{cNum}/{cIns}/{cMajor}", method = RequestMethod.GET)
    @ResponseBody
    public Msg claCreate(@PathVariable("cName") String name, @PathVariable("cNum") String num,
                         @PathVariable("cIns") String ins, @PathVariable("cMajor") String major) {
        int i = insService.claCreate(name, num, ins, major);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 通过专业查询班级
     *
     * @param major
     * @return
     */
    @RequestMapping(value = "/getClass/{major}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getClass(@PathVariable("major") String major) {
        List<Class> cla = insService.getclass(major);
        return Msg.success().add("cla", cla);
    }

    /**
     * 通过班级查询课程
     *
     * @param ins
     * @return
     */
    @RequestMapping(value = "/getCour/{cla}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getCour(@PathVariable("cla") String ins) {
        List<MajCour> cour = insService.getCour(ins);
        return Msg.success().add("cour",cour);
    }

    /**
     * 通过机构查询课程
     * @param ins
     * @return
     */
    @RequestMapping(value = "/getACour/{ins}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getACour(@PathVariable("ins") String ins) {
        List<Course> cour = insService.getACour(ins);
        return Msg.success().add("cour",cour);
    }



    /**
     * 查询所有课程
     *
     * @return
     */
    @RequestMapping(value = "/getcours", method = RequestMethod.GET)
    @ResponseBody
    public Msg getcours() {
        List<Course> cours = insService.getcours();
        return Msg.success().add("cours", cours);
    }
    /**
     * 查询可选课程
     *
     * @return
     */
    @RequestMapping(value = "/getSelectCour", method = RequestMethod.GET)
    @ResponseBody
    public Msg getSelectCour() {
        List<Course> cours = insService.getSelectCour();
        return Msg.success().add("cours", cours);
    }
    /**
     * 查询所有专业
     *
     * @return
     */
    @RequestMapping(value = "/getMaj", method = RequestMethod.GET)
    @ResponseBody
    public Msg getMaj() {
        List<Major> maj = insService.getMaj();
        return Msg.success().add("maj", maj);
    }

    /**
     * 批量插入课程信息
     *
     * @param courses
     * @return
     */
    @RequestMapping(value = "/courseBat", method = RequestMethod.POST)
    @ResponseBody
    public Msg courseBat(@RequestBody ArrayList<Course> courses) {
        int i = insService.addCour(courses);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success().add("row", i);
    }

    @RequestMapping(value = "/addCourAt", method = RequestMethod.POST)
    @ResponseBody
    public Msg addCourAt(@RequestBody MajCour majCour) {
        int i = insService.addCourAt(majCour);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/getCourAt", method = RequestMethod.GET)
    @ResponseBody
    public Msg getCourAt(){
        List<MajCour> courAt = insService.getCourAt();
        return Msg.success().add("courAt",courAt);
    }


}
