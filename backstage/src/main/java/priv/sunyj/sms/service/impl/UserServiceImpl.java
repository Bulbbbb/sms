package priv.sunyj.sms.service.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.sunyj.sms.bean.Student;
import priv.sunyj.sms.bean.UserExample;
import priv.sunyj.sms.bean.User;
import priv.sunyj.sms.dao.StudentMapper;
import priv.sunyj.sms.dao.UserMapper;
import priv.sunyj.sms.service.UserService;
import priv.sunyj.sms.util.Data;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    /**
     * 登录
     * @param uNum
     * @param uPwd
     * @return
     */
    @Override
    public List<User> login(String uNum, String uPwd) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUNumEqualTo(uNum);
        criteria.andUPwdEqualTo(uPwd);
        List<User> Users = userMapper.selectByExample(userExample);
        return Users;
    }

    /**
     * 获取所有老师
     * @return
     */
    @Override
    public List<User> getUser() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }
    /**
     * 批量插入教师
     * @param
     */
    @Transactional
    public int addUser(ArrayList<User> users) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count=0;
        for (int i = 0; i < users.size(); i++) {
            users.get(i).settAuth("2");
            String num=users.get(i).getuNum();
            users.get(i).setuPwd(num);
            users.get(i).setuIn(Data.getYear());
            int row = mapper.insertSelective(users.get(i));
            count+=row;
        }
        sqlSession.flushStatements();
        return count;
    }

    /**
     * 创建教师
     * @param user
     * @return
     */
    @Override
    public int teaCreate(User user){
        user.setuPwd(user.getuNum());
        user.settAuth("2");
        user.setuIn(Data.getYear());
        int insert = userMapper.insert(user);
        return insert;
    }
}
