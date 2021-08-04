package priv.sunyj.sms.service.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.sunyj.sms.bean.*;
import priv.sunyj.sms.bean.Class;
import priv.sunyj.sms.dao.*;
import priv.sunyj.sms.service.InsService;
import priv.sunyj.sms.util.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

//2017 12 20 02 30 年份+学院+专业+班级
@Service
public class InsServiceImpl implements InsService {
    @Autowired
    InstitutionMapper institutionMapper;
    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private MajCourMapper majCourMapper;

    /**
     * 创建学院
     *
     * @param name
     * @param num
     * @return
     */
    @Override
    public int insCreate(String name, String num) {
        Institution institution = new Institution();
        String decName = null;

        try {
            decName = URLDecoder.decode(name, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        institution.setiName(decName);
        institution.setiNum(num);
        int insert = institutionMapper.insert(institution);
        return insert;
    }

    /**
     * 创建专业
     *
     * @param name
     * @param num
     * @return
     */
    @Override
    public int majCreate(String name, String num, String ins) {

        List<Major> aMaj = getAMaj(num);
        if (!aMaj.isEmpty()) {
            return 0;
        }
        String decName = null;
        String decIns = null;

        try {
            decName = URLDecoder.decode(name, "UTF-8");
            decIns = URLDecoder.decode(ins, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Major major = new Major();
        major.setmName(decName);
        major.setmNum(num);
        major.setmIns(decIns);
        int insert = majorMapper.insert(major);
        return insert;
    }

    /**
     * 查询所有学院
     *
     * @return
     */
    @Override
    public List<Institution> getIns() {
        List<Institution> institutions = institutionMapper.selectByExample(null);
        return institutions;
    }

    /**
     * 查询所有专业
     *
     * @return
     */
    @Override
    public List<Major> getMaj() {

        List<Major> majors = majorMapper.selectByExample(null);
        return majors;
    }

    /**
     * 通过编号查询专业
     *
     * @return
     */
    @Override
    public List<Major> getAMaj(String num) {
        MajorExample majorExample = new MajorExample();
        MajorExample.Criteria criteria = majorExample.createCriteria();
        criteria.andMNumEqualTo(num);
        List<Major> majors = majorMapper.selectByExample(majorExample);
        return majors;
    }

    /**
     * 通过专业查询班级
     *
     * @param ins
     * @return
     */
    @Override
    public List<Major> getMajs(String ins) {
        String decMaj = null;
        try {
            decMaj = URLDecoder.decode(ins, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        MajorExample majorExample = new MajorExample();
        MajorExample.Criteria criteria = majorExample.createCriteria();
        criteria.andMInsEqualTo(decMaj);
        List<Major> majors = majorMapper.selectByExample(majorExample);
        return majors;
    }


    /**
     * 查询班级
     *
     * @param num
     * @return
     */
    @Override
    public List<Class> getAcla(String num) {
        ClassExample classExample = new ClassExample();
        ClassExample.Criteria criteria = classExample.createCriteria();
        criteria.andCNumEqualTo(num);
        List<Class> classes = classMapper.selectByExample(classExample);
        return classes;
    }

    /**
     * 查询所有班级
     *
     * @return
     */
    @Override
    public List<Class> getcla() {
        List<Class> classes = classMapper.selectByExample(null);
        return classes;
    }

    @Override
    public int addCourAt(MajCour majCour) {
        if (majCour.getYear().equals("")){
            return 0;
        }
        int insert = majCourMapper.insert(majCour);
        return insert;
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
    @Override
    public int claCreate(String name, String num, String ins, String major) {
        String decName = null;
        String decNum = null;
        String decIns = null;
        String decMaj = null;

        try {
            decName = URLDecoder.decode(name, "UTF-8");
            decNum = URLDecoder.decode(num, "UTF-8");
            decIns = URLDecoder.decode(ins, "UTF-8");
            decMaj = URLDecoder.decode(major, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<Class> acla = getAcla(num);
        if (!acla.isEmpty()) {
            return 0;
        }
        Class aClass = new Class();
        aClass.setcName(decName);
        aClass.setcNum(decNum);
        aClass.setcIns(decIns);
        aClass.setcMajor(decMaj);
        int insert = classMapper.insert(aClass);
        return insert;
    }

    /**
     * 通过专业查询班级
     *
     * @param maj
     * @return
     */
    @Override
    public List<Class> getclass(String maj) {
        String decMaj = null;
        try {
            decMaj = URLDecoder.decode(maj, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ClassExample classExample = new ClassExample();
        ClassExample.Criteria criteria = classExample.createCriteria();
        criteria.andCMajorEqualTo(decMaj);
        List<Class> classes = classMapper.selectByExample(classExample);
        return classes;
    }


    /**
     * 查询所有课程
     *
     * @return
     */
    public List<Course> getcours() {
        List<Course> classes = courseMapper.selectByExample(null);
        return classes;
    }

    /**
     * 查询可选课程
     * @return
     */
    public List<Course> getSelectCour() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andIsSelEqualTo("是");
        List<Course> classes = courseMapper.selectByExample(courseExample);
        return classes;
    }


    /**
     * 通过专业查询课程
     *
     * @param maj
     * @return
     */
    @Override
    public List<MajCour> getCour(String maj) {

        String decMaj = null;

        try {
            decMaj = URLDecoder.decode(maj, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        MajCourExample majCourExample = new MajCourExample();
        MajCourExample.Criteria criteria = majCourExample.createCriteria();
        criteria.andMajNameEqualTo(decMaj);
        List<MajCour> majCours = majCourMapper.selectByExample(majCourExample);
//
//        CourseExample courseExample = new CourseExample();
//        CourseExample.Criteria criteria = courseExample.createCriteria();
//        criteria.andCInsEqualTo(decMaj);
//        List<Course> courses = courseMapper.selectByExample(courseExample);
        return majCours;
    }


    /**
     * 通过机构查询课程
     *
     * @param ins
     * @return
     */
    @Override
    public List<Course> getACour(String ins) {

        String decIns = null;

        try {
            decIns = URLDecoder.decode(ins, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCInsEqualTo(decIns);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        return courses;
    }
    /**
     * 批量插入学生
     * @param courses
     */
    @Transactional
    public int addCour(ArrayList<Course> courses) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        int count=0;
        for (int i = 0; i < courses.size(); i++) {
            int row = mapper.insertSelective(courses.get(i));
            count+=row;
        }
        sqlSession.flushStatements();
        return count;
    }



    @Override
    public List<MajCour> getCourAt(){
        List<MajCour> majCours = majCourMapper.selectByExample(null);
        return majCours;
    }
}
