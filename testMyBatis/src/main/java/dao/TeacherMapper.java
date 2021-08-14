package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> selectTeacher();

    Teacher selectTeacherStudent(@Param("tid") int id);
}
