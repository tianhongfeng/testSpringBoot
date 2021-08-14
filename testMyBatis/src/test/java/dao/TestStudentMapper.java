package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.Student;
import pojo.Teacher;
import util.MyBatisUtil;

import java.util.List;

public class TestStudentMapper {
    private static Logger logger = Logger.getLogger(TestStudentMapper.class);
    @Test
    public void selectTeacher(){
        SqlSession session = MyBatisUtil.getSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> users = mapper.selectStudentTeacher();

        for (Student Student: users){
            System.out.println(Student.toString());
        }

        logger.info("查询用户");
        session.close();
    }
}
