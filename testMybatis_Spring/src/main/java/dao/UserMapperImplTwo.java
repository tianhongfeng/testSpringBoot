package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;

import java.util.List;
import java.util.Map;

public class UserMapperImplTwo extends SqlSessionDaoSupport implements UserMapper{


    @Override
    public List<User> selectUser() {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        return mapper.selectUser();
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User selectUserById(int i) {
        return null;
    }

    @Override
    public List<User> selecrUserLimit(Map<String, Integer> map) {
        return null;
    }
}
