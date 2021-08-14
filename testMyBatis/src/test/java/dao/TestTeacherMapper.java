package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.Teacher;
import pojo.User;
import util.MyBatisUtil;

import java.util.List;

public class TestTeacherMapper {
    private static Logger logger = Logger.getLogger(TestTeacherMapper.class);
    @Test
    public void selectTeacher(){
        SqlSession session = MyBatisUtil.getSession();

        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.selectTeacherStudent(1);
        System.out.println(teacher.toString());

        // Teacher{id=1, name='田老师',
        //  students=[
        //  Student{id=1, name='小明', teacher=null},
        //  Student{id=2, name='小红', teacher=null},
        //  Student{id=3, name='小张', teacher=null},
        //  Student{id=4, name='小李', teacher=null},
        //  Student{id=5, name='小王', teacher=null}
        //  ]
        //  }

        logger.info("查询用户");
        session.close();
    }
}
