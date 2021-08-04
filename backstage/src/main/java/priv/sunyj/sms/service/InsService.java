package priv.sunyj.sms.service;

import priv.sunyj.sms.bean.*;
import priv.sunyj.sms.bean.Class;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public interface InsService {
    public int insCreate(String name, String num);

    public List<Institution> getIns();

    public int majCreate(String name, String num, String ins);

    public List<Major> getAMaj(String num);

    public List<Major> getMajs(String ins);

    public List<Class> getAcla(String num);

    public int claCreate(String name, String num, String ins, String major);

    public List<Class> getclass(String maj);

    public List<MajCour> getCour(String maj);


        public List<Course> getcours();

    public List<Major> getMaj();

    public List<Class> getcla();

    public int addCourAt(MajCour majCour);

    public List<MajCour> getCourAt();

    public List<Course> getACour(String ins) ;

    public List<Course> getSelectCour() ;


    }
