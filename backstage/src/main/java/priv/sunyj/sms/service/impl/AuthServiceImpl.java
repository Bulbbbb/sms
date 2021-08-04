package priv.sunyj.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.sunyj.sms.bean.AuthPower;
import priv.sunyj.sms.dao.AuthPowerMapper;
import priv.sunyj.sms.service.AuthService;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthPowerMapper authPowerMapper;

    /**
     * 查询权限列表
     * @return
     */
    @Override
    public List<AuthPower> getAuth() {
        List<AuthPower> authPowers = authPowerMapper.selectByExample(null);
        return authPowers;
    }
}
