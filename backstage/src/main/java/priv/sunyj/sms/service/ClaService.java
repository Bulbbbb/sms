package priv.sunyj.sms.service;

import priv.sunyj.sms.bean.Course;

import java.util.List;

public interface ClaService {
    public List<Course> getCour(String name, String cla);
    public int courCreate(Course course) ;
}
