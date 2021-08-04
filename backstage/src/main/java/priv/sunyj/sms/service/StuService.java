package priv.sunyj.sms.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.sunyj.sms.bean.Msg;
import priv.sunyj.sms.bean.Student;
import priv.sunyj.sms.bean.StudentExample;
import priv.sunyj.sms.dao.StudentMapper;

import java.util.List;

public interface StuService {
    List<Student> getStus();

    public List<Student> getAStu(String num);

    public int stuCreate(String name, String num, String year, String ins, String maj, String cla);

    public List<Student> getStusForCla(String cla);

    public List<Student> login(String uNum, String uPwd);

    public int addAStu(Student student) ;

}
