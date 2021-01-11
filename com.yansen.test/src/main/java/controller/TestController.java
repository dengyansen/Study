package controller;

import web.mvc.Controller;
import web.mvc.RequestMapping;
import web.mvc.RequestParam;

@Controller
public class TestController {
    @RequestMapping("/hello")
    public Integer hello(@RequestParam("name") String name){
        System.out.println(name);

    }
}
