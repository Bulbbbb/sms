package priv.sunyj.sms.service;

import priv.sunyj.sms.bean.XuanKe;

import java.util.List;

public interface XuanKeService {
    public int addXuanke(XuanKe xuanKe);

    public List<XuanKe> getXuanke(String sNum, String cNum);

}
