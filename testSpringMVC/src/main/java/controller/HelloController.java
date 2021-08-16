package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/HelloController")
public class HelloController {


    //真实访问地址 : 项目名/HelloController/hello
    @RequestMapping("/hello")
    public String sayHello(Model model){
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC");
        //web-inf/jsp/hello.jsp
        return "hello";
    }

    // 可以自定义请求类型 RequestMethod.GET
    // 也可以通过 @PatchMapping() 来指定
    @RequestMapping(value = "/restful/{a}/{b}", method = RequestMethod.GET)
    public String testRestful(@PathVariable int a, @PathVariable String b, Model model){

        model.addAttribute("msg","=" + a + b);

        // "redirect:/index.jsp"; 重定向
        return "redirect:/HelloController/hello";
    }


}
