package pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 通过@component注解 注入bean  等价于 <bean id="hello" class="pojo.Hello"/>
@Component
public class Hello {


    private String str = "spring";

    public String getStr() {
        return str;
    }

    // 相当于 <property name="str" value="hello spring"/>
    @Value("hello spring")
    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
