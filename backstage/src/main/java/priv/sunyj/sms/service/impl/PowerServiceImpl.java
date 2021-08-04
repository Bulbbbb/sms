package priv.sunyj.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sunyj.sms.bean.*;
import priv.sunyj.sms.dao.AuthPowerMapper;
import priv.sunyj.sms.service.PowerService;

import java.util.*;

@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private AuthPowerMapper authPowerMapper;

    /**
     * 根据权限查询功能
     *
     * @param auth
     * @return
     */
    @Override
    public List<AuthPower> getPowers(String auth) {
        AuthPowerExample authPowerExample = new AuthPowerExample();
        AuthPowerExample.Criteria criteria = authPowerExample.createCriteria();
        criteria.andAuthNumEqualTo(auth);
        List<AuthPower> authPowers = authPowerMapper.selectByExample(authPowerExample);
        return authPowers;
    }
}
