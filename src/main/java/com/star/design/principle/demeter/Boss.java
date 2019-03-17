package com.star.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lcx
 * @Date: 2018/11/26 15:51
 * @Description:
 */

public class Boss {

    public void commandCheckNum(TeamLeader teamLeader) {
        teamLeader.checkNumOfCourse();
    }

}
