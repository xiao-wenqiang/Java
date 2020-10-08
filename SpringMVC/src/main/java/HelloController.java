import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//@RequestMapping("/HELLO")   //会作为下面方法映射的父地址（不用啦）
//@RestController   //返回值不会被视图解析器处理
@Controller    //做注册交由spring管理，对它所有有String返回值的方法会走视图解析器
public class HelloController {

    @RequestMapping("/hello")   //映射url到controller的方法（映射到controller的作它父地址）
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","hello...");
        return "page1";//会被视图解析器处理，会走自定义的/WEB-INF/jsp/
    }
    @RequestMapping("/hello2")
    public String hello2(String msg,Model model) {
        model.addAttribute("msg", msg);
        return "page1";
    }
}

/*
用户请求 ->映射到controller方法 ->做业务、返回数据/返回视图名字 ->返回完整视图
 */