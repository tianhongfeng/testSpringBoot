package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.User;
import util.MyBatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserMapper {

    private static Logger logger = Logger.getLogger(TestUserMapper.class);

    @Test
    public void selectUser() {
        /**
         * 1.先查二级缓存
         * 2.在查一级缓存
         * 3.然后再去查数据库
         */


        SqlSession session = MyBatisUtil.getSession();
        SqlSession session2 = MyBatisUtil.getSession();
        //方法一:
//        List<User> users = session.selectList("userMapper.selectUser");
        //方法二:
        // 查询两次相同的东西 第二次会从一级缓存中取结果
        // 一级缓存是默认开启的，只在一个 SqlSession内有效
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        List<User> users = mapper.selectUser();

        for (User user: users){
            System.out.println(user.toString());
        }

        // 只有在第一个session关闭时，才会把数据转到二级缓存中
        session.close();

        List<User> user2 = mapper2.selectUser();

        for (User user: user2){
            System.out.println(user.toString());
        }

        logger.info("查询用户");

        session2.close();
    }

    @Test
    public void selectUserById() {
        SqlSession session = MyBatisUtil.getSession();
        //方法一:
//        List<User> users = session.selectList("userMapper.selectUser");
        //方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);

        System.out.println(user.toString());

        session.close();
    }

    @Test
    public void addUser() {
        SqlSession session = MyBatisUtil.getSession();
        //方法一:
//        List<User> users = session.selectList("userMapper.selectUser");
        //方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(new User(4, "小花", "123456"));

        // 增删改 需要提交事务
        session.commit();

        session.close();
    }

    @Test
    public void selecrUserLimit() {
        SqlSession session = MyBatisUtil.getSession();
        //方法一:
//        List<User> users = session.selectList("userMapper.selectUser");
        //方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startindex", 2);
        map.put("pagesize", 2);
        List<User> users = mapper.selecrUserLimit(map);

        for (User user: users){
            System.out.println(user.toString());
        }

        session.close();
    }

}
