package com.star.springboot;

import com.star.spring.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lcx on 2018/9/15.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello(){
//        Person person = new Person();
//        person.setAge(100);
//        person.setName("AA");
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
