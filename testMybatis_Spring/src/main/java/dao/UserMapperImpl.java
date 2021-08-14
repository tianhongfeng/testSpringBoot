package dao;

import org.mybatis.spring.SqlSessionTemplate;
import pojo.User;

import java.util.List;
import java.util.Map;

public class UserMapperImpl implements UserMapper{

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
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
