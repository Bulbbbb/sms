package priv.sunyj.sms.service.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.sunyj.sms.bean.Student;
import priv.sunyj.sms.bean.StudentExample;
import priv.sunyj.sms.dao.StudentMapper;
import priv.sunyj.sms.service.StuService;
import priv.sunyj.sms.util.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Student> getStus() {
        List<Student> students = studentMapper.selectByExample(null);
        return students;
    }

    @Override
    public List<Student> login(String uNum, String uPwd) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSNumEqualTo(uNum);
        criteria.andSPwdEqualTo(uPwd);
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students;
    }



    /**
     * 通过班级查询学生
     *
     * @param cla
     * @return
     */
    @Override
    public List<Student> getStusForCla(String cla) {
        String deCla = null;
        try {
            deCla = URLDecoder.decode(cla, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSClaEqualTo(deCla);
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students;
    }


    /**
     * 通过编号查询学生
     *
     * @param num
     * @return
     */
    @Override
    public List<Student> getAStu(String num) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSNumEqualTo(num);
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students;
    }


    @Override
    public int stuCreate(String name, String num, String year, String ins, String maj, String cla) {
        List<Student> aStu = this.getAStu(num);
        if (!aStu.isEmpty()) {
            return 0;
        }
        String deName = null;
        String deIns = null;
        String deMaj = null;
        String deCla = null;

        try {
            deName = URLDecoder.decode(name, "UTF-8");
            deIns = URLDecoder.decode(ins, "UTF-8");
            deMaj = URLDecoder.decode(maj, "UTF-8");
            deCla = URLDecoder.decode(cla, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Student student = new Student();
        student.setsName(deName);
        student.setsNum(num);
        student.setsIn(year);
        student.setsIns(deIns);
        student.setsMaj(deMaj);
        student.setsCla(deCla);
        student.setsAuth("3");
        int insert = studentMapper.insert(student);
        return insert;
    }

    /**
     * 批量插入学生
     * @param students
     */
    @Transactional
    public int addStu(ArrayList<Student> students) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int count=0;
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setsAuth("3");
            String num=students.get(i).getsNum();
            students.get(i).setsPwd(num.substring(num.length()-5));
            students.get(i).setsIn(Data.getYear());
            students.get(i).setsState("枣庄学院在读");
            int row = mapper.insertSelective(students.get(i));
            count+=row;
        }
        sqlSession.flushStatements();
        return count;
    }

    /**
     * 创建单个学生
     * @param student
     * @return
     */
    @Override
    public int addAStu(Student student) {
        student.setsAuth("3");
        String num=student.getsNum();
        student.setsPwd(num.substring(num.length()-5));
        student.setsIn(Data.getYear());
        student.setsState("枣庄学院在读");
        int i = studentMapper.insertSelective(student);
        return i;
    }

}
