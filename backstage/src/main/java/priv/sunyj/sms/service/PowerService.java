package priv.sunyj.sms.service;

import priv.sunyj.sms.bean.AuthPower;

import java.util.List;

public interface PowerService {

    List<AuthPower> getPowers(String auth);
}
