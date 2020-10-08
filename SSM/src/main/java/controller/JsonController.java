package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //然后controller的所有方法不会走视图解析器，会直接返回字符串
    //大网站做前后端分离用的@RestController、@ResponseBody
    //小网站不用
public class JsonController {

    @RequestMapping("/json1")
    @ResponseBody   //然后不会走视图解析器，会直接返回字符串
    public String json1(){


        return "json1";
    }
}
