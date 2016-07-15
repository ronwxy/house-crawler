package com.ray.crawler.house.domain;

/**
 * Created by ray4w on 2016/7/15.
 */
public class HouseInfo extends BaseDomain {

    private static final long serialVersionUID = -5761467766914797991L;
    private Integer houseNo;
    private Integer floorNo;
    private String houseUse;
    private String houseType;
    private String decorate;
    private Double buildingArea;
    private Double houseArea;
    private Double shareArea;
    private Double publishPrice;
    private Double totalPrice;
    private String saleState;

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public String getHouseUse() {
        return houseUse;
    }

    public void setHouseUse(String houseUse) {
        this.houseUse = houseUse;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getDecorate() {
        return decorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate;
    }

    public Double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Double houseArea) {
        this.houseArea = houseArea;
    }

    public Double getShareArea() {
        return shareArea;
    }

    public void setShareArea(Double shareArea) {
        this.shareArea = shareArea;
    }

    public Double getPublishPrice() {
        return publishPrice;
    }

    public void setPublishPrice(Double publishPrice) {
        this.publishPrice = publishPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSaleState() {
        return saleState;
    }

    public void setSaleState(String saleState) {
        this.saleState = saleState;
    }
}
