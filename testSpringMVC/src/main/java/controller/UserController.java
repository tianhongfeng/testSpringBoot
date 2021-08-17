package controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import util.JsonUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 如果使用了 @RestController 就不用在方法上加 @ResponseBody 注解了
@RestController
public class UserController {

    @RequestMapping("/j1")
//    @ResponseBody//他就不会走视图解析器，会直接返回一个 字符串
    public String json1() throws JsonProcessingException {

//        //jackson,ObjectMapper
//        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User(1, "秦疆一号", 12);
        //System.out.println(user);

//        String str = mapper.writeValueAsString(user);
        return JsonUtils.getJson(user);
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        //创建一个jackson的对象映射器，用来解析数据
//        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user1 = new User(1, "秦疆1号", 12);
        User user2 = new User(2, "秦疆2号", 12);
        User user3 = new User(3, "秦疆3号", 12);
        User user4 = new User(4, "秦疆4号", 12);
        User user5 = new User(5, "秦疆5号", 12);
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        //将我们的对象解析成为json格式
//        String str = mapper.writeValueAsString(list);
        return JsonUtils.getJson(list);
    }


    @RequestMapping("/j3")
    public String json4() throws JsonProcessingException {

//        ObjectMapper mapper = new ObjectMapper();
//
//        //不使用时间戳的方式
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        //自定义日期格式对象
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //指定日期格式
//        mapper.setDateFormat(sdf);

        Date date = new Date();
//        String str = mapper.writeValueAsString(date);

        return JsonUtils.getJson(date, "yyyy-MM-dd HH:mm:ss");
    }
}
