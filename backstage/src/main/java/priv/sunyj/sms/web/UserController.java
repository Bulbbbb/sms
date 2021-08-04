package priv.sunyj.sms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.sunyj.sms.bean.Msg;
import priv.sunyj.sms.bean.Student;
import priv.sunyj.sms.bean.User;
import priv.sunyj.sms.service.impl.StuServiceImpl;
import priv.sunyj.sms.service.impl.UserServiceImpl;
import priv.sunyj.sms.util.JWTUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private StuServiceImpl stuService;

    /**
     * 登录
     * @param httpServletRequest
     * @param uNum
     * @param uPwd
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login/{uNum}/{uPwd}/{role}", method = RequestMethod.GET)
    public Msg login(HttpServletRequest httpServletRequest,
                     @PathVariable("uNum") String uNum,
                     @PathVariable("uPwd") String uPwd,
                     @PathVariable("role") String role) {
        if (role.equals("1") || role.equals("2")) {
            List<User> users = userService.login(uNum, uPwd);
            if (users.isEmpty()) {
                return Msg.fail();
            }
            String token = JWTUtil.createToken(uNum);
            return Msg.success().add("user", users.get(0)).add("token", token);
        } else {
            List<Student> users = stuService.login(uNum, uPwd);
            if (users.isEmpty()) {
                return Msg.fail();
            }
            String token = JWTUtil.createToken(uNum);
            return Msg.success().add("user", users.get(0)).add("token", token);
        }

    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Msg getUser() {
        List<User> user = userService.getUser();
        return Msg.success().add("user", user);
    }

    /**
     * 批量插入教师信息
     * @param users
     * @return
     */
    @RequestMapping(value = "/teacherBat", method = RequestMethod.POST)
    @ResponseBody
    public Msg teacherBat(@RequestBody ArrayList<User> users) {
        int i = userService.addUser(users);
        if (i == 0) {
            return Msg.fail();
        }
        return Msg.success().add("row", i);
    }

    /**
     * 创建教师
     * @param user
     * @return
     */
    @RequestMapping(value = "/teaCreate", method = RequestMethod.POST)
    @ResponseBody
    public Msg teaCreate(@RequestBody User user){
        int i = userService.teaCreate(user);
        if (i==0){
            return Msg.fail();
        }
        return Msg.success();
    }
}
