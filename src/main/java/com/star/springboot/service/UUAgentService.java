package com.star.springboot.service;

import com.star.springboot.entity.UUAgent;
import com.star.springboot.mapper.UUAgentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lcx on 2018/10/8.
 */

@Service
public class UUAgentService {

    @Autowired
    private UUAgentMapper uuAgentMapper;

    public List<UUAgent> getUUAgentList(String parentPassportName){
        return uuAgentMapper.listUUAgent(parentPassportName);
    }


}
