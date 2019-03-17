package com.star.springboot.entity;

/**
 * Created by lcx on 2018/10/8.
 */
public class UUAgent {

    private Integer agentId;
    private String passportName;
    private String parentPassportName;
    private Byte agentLevel;
    private String path;
    private Integer agentBusType;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getPassportName() {
        return passportName;
    }

    public void setPassportName(String passportName) {
        this.passportName = passportName;
    }

    public String getParentPassportName() {
        return parentPassportName;
    }

    public void setParentPassportName(String parentPassportName) {
        this.parentPassportName = parentPassportName;
    }

    public Byte getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(Byte agentLevel) {
        this.agentLevel = agentLevel;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getAgentBusType() {
        return agentBusType;
    }

    public void setAgentBusType(Integer agentBusType) {
        this.agentBusType = agentBusType;
    }
}
