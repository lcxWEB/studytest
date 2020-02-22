package com.star.springboot.controller;

import com.star.springboot.entity.UUAgent;
import com.star.springboot.service.UUAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lcx on 2018/10/8.
 */

@RestController
public class UUAgentController {

    @Autowired
    private UUAgentService uuAgentService;

    @RequestMapping(value = "/getUUAgentList/{passportname}", method = RequestMethod.GET)
    public Object getUUAgentList(@PathVariable("passportname") String parentPassportName){

        List<UUAgent> agentList = uuAgentService.getUUAgentList(parentPassportName);

        return agentList;

    }

    @RequestMapping(value = "/getUUAgentList2", method = RequestMethod.GET)
//    @GetMapping(value = "/getUU")
//    @PostMapping(value = "/postUU")
    public Object getUUAgentList2(@RequestParam(value = "passportname", required = false, defaultValue = "lcxtest1111") String parentPassportName){

        List<UUAgent> agentList = uuAgentService.getUUAgentList(parentPassportName);

        return agentList;

    }

}
