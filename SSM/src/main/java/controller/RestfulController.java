package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestfulController {

    // 这是原来的：http://local.../add?a=1&b=2
    @RequestMapping("/add")
    public String test1(int a,int b,Model model){
        int res = a+b;
        model.addAttribute("msg","add..."+res);
        return "page2";
    }
    // 这是restful风格的：http://local.../add/a/b
    @RequestMapping("/add2/{a}/{b}")    //把变量绑定到url里
    //@RequestMapping(path="/add2/{a}/{b}",method=RequestMethod.GET)，组合简写GetMapping("")。所以同不同method，可以复用url，就是一个url ->用不同method ->实现不同操作
    public String test2(@PathVariable int a,@PathVariable int b, Model model){
        int res = a+b;
        model.addAttribute("msg","add..."+res);
        return "page2";
    }
}
