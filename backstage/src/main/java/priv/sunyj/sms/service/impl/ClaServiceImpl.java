package priv.sunyj.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sunyj.sms.bean.Class;
import priv.sunyj.sms.bean.ClassExample;
import priv.sunyj.sms.bean.Course;
import priv.sunyj.sms.bean.CourseExample;
import priv.sunyj.sms.dao.ClassMapper;
import priv.sunyj.sms.dao.CourseMapper;
import priv.sunyj.sms.service.ClaService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Service
public class ClaServiceImpl implements ClaService {
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 创建课程
     * @param course
     * @return
     */
    @Override
    public int courCreate(Course course) {
        List<Course> cour = this.getCour(course.getcName(), course.getcIns());
        if (!cour.isEmpty()) {
            return 0;
        }
        int insert = courseMapper.insert(course);
        return insert;
    }

    /**
     * 通过课程名和所属学院查询是否又课程
     *
     * @param name
     * @param cla
     * @return
     */
    @Override
    public List<Course> getCour(String name, String cla) {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCNameEqualTo(name);
        criteria.andCInsEqualTo(cla);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        return courses;
    }

}
