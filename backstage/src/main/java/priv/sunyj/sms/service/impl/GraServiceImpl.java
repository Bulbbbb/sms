package priv.sunyj.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sunyj.sms.bean.StuCour;
import priv.sunyj.sms.bean.StuCourExample;
import priv.sunyj.sms.dao.StuCourMapper;
import priv.sunyj.sms.service.GraService;
import priv.sunyj.sms.util.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Service
public class GraServiceImpl implements GraService {

    @Autowired
    private StuCourMapper stuCourMapper;

    @Override
    public int graCreat(String stu, String cour, String year, String school, String cla, String gra) {
        String deStu = null;
        String deCour = null;
        String deSch = null;
        String deCla = null;
        try {
            deStu = URLDecoder.decode(stu, "UTF-8");
            deCour = URLDecoder.decode(cour, "UTF-8");
            deSch = URLDecoder.decode(school, "UTF-8");
            deCla = URLDecoder.decode(cla, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StuCour stuCour = new StuCour();
        stuCour.setStuName(deStu);
        stuCour.setCourName(deCour);
        stuCour.setYear(year);
        stuCour.setSchool(deSch);
        stuCour.setCla(deCla);
        stuCour.setGrade(gra);
        int insert = stuCourMapper.insert(stuCour);
        return insert;
    }

    /**
     * 查询成绩
     *
     * @return
     */
    @Override
    public List<StuCour> getGra() {
//        String year = Data.getYear();
//        StuCourExample stuCourExample = new StuCourExample();
//        StuCourExample.Criteria criteria = stuCourExample.createCriteria();
//        criteria.andYearEqualTo(year);
        List<StuCour> stuCours = stuCourMapper.selectByExample(null);
        return stuCours;
    }

    /**
     * 查询个人成绩
     * @param year 学年
     * @param school 学期
     * @return 成绩集合
     * @Auth
     */
    @Override
    public List<StuCour> getAGra(String name ,String year,String school) {
        String deNam = null;
        try {
            deNam = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StuCourExample stuCourExample = new StuCourExample();
        StuCourExample.Criteria criteria = stuCourExample.createCriteria();
        criteria.andYearEqualTo(year);
        criteria.andSchoolEqualTo(school);
        criteria.andStuNameEqualTo(deNam);
        List<StuCour> stuCours = stuCourMapper.selectByExample(stuCourExample);
        return stuCours;
    }
}
