package dao;

import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

//    @Select(" select * from mybatis.user")
    List<User> selectUser();

    int addUser(User user);

    User selectUserById(int i);

    List<User> selecrUserLimit(Map<String, Integer> map);

}
