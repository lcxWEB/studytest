package com.star.jdbc;

/**
 * Created by lcx on 2018/10/16.
 */
public class CoinAssets {

    private Integer coinAssetsId;
    private String passportName;
    private Integer coinAmount;
    private Integer agentBusType;

    public Integer getCoinAssetsId() {
        return coinAssetsId;
    }

    public void setCoinAssetsId(Integer coinAssetsId) {
        this.coinAssetsId = coinAssetsId;
    }

    public String getPassportName() {
        return passportName;
    }

    public void setPassportName(String passportName) {
        this.passportName = passportName;
    }

    public Integer getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(Integer coinAmount) {
        this.coinAmount = coinAmount;
    }

    public Integer getAgentBusType() {
        return agentBusType;
    }

    public void setAgentBusType(Integer agentBusType) {
        this.agentBusType = agentBusType;
    }

    @Override
    public String toString() {
        return "CoinAssets{" +
                "coinAssetsId=" + coinAssetsId +
                ", passportName='" + passportName + '\'' +
                ", coinAmount=" + coinAmount +
                ", agentBusType=" + agentBusType +
                '}';
    }

}
