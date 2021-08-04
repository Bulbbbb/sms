package priv.sunyj.sms.service;

import priv.sunyj.sms.bean.Student;
import priv.sunyj.sms.bean.User;

import java.util.List;

public interface UserService {
    List<User> login(String uNum, String uPwd);

    public List<User> getUser();

    public int teaCreate(User user);


    }
