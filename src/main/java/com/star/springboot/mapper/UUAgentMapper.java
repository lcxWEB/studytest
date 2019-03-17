package com.star.springboot.mapper;

import com.star.springboot.entity.UUAgent;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lcx on 2018/10/8.
 */

@Repository
public interface UUAgentMapper {

    List<UUAgent> listUUAgent(String parentPassportName);

    List<UUAgent> listAllUUAgent(RowBounds rowBounds);


}
