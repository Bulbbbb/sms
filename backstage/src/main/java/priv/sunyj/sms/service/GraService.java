package priv.sunyj.sms.service;

import priv.sunyj.sms.bean.StuCour;

import java.util.List;

public interface GraService {

    public int graCreat(String stu, String cour, String year, String school, String cla, String gra);

    public List<StuCour> getGra();
    public List<StuCour> getAGra(String name ,String year,String school);



    }
