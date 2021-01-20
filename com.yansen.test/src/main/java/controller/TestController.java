package controller;

import beans.AutoWired;
import service.TestService;
import web.mvc.Controller;
import web.mvc.RequestMapping;
import web.mvc.RequestParam;

@Controller
public class TestController {
    @AutoWired
    private TestService testService;
    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name){
        System.out.println(name);
        return testService.sayHello();
    }
}
