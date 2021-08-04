package priv.sunyj.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sunyj.sms.bean.XuanKe;
import priv.sunyj.sms.bean.XuanKeExample;
import priv.sunyj.sms.dao.XuanKeMapper;
import priv.sunyj.sms.service.XuanKeService;

import java.util.List;

@Service
public class XuanKeServiceImpl implements XuanKeService {

    @Autowired
    private XuanKeMapper xuanKeMapper;

    @Override
    public int addXuanke(XuanKe xuanKe){
        int insert = xuanKeMapper.insert(xuanKe);
        return insert;
    }
    @Override
    public List<XuanKe> getXuanke(String sNum, String cNum){
        XuanKeExample xuanKeExample = new XuanKeExample();
        XuanKeExample.Criteria criteria = xuanKeExample.createCriteria();
        criteria.andSNumEqualTo(sNum);
        criteria.andCNumEqualTo(cNum);
        List<XuanKe> xuanKes = xuanKeMapper.selectByExample(xuanKeExample);
        return xuanKes;

    }
}
