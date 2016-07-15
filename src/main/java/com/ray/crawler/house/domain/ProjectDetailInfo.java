package com.ray.crawler.house.domain;

import java.util.Date;

/**
 * Created by ray4w on 2016/7/15.
 */
public class ProjectDetailInfo extends BaseDomain {

    private static final long serialVersionUID = -9221213283825045950L;
    private String projectName;
    private String area;
    private String approveNo;
    private String company;
    private Integer buildingNum;
    private String projectAddress;
    private Double min_price; //销售起价
    private String sellAddress;
    private String sellPhone;
    private Integer houseNum;
    private String bus;
    private Double totalArea;
    private String designCompany;
    private Double totalBuildingArea;
    private String sellProxy;
    private Double sizeRate;
    private String propertyCompany;
    private Double greenRate;
    private String buildingCompany;
    private Double propertyPrice;
    private Date finishDate;
    private String projectSummary;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getApproveNo() {
        return approveNo;
    }

    public void setApproveNo(String approveNo) {
        this.approveNo = approveNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(Integer buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public Double getMin_price() {
        return min_price;
    }

    public void setMin_price(Double min_price) {
        this.min_price = min_price;
    }

    public String getSellAddress() {
        return sellAddress;
    }

    public void setSellAddress(String sellAddress) {
        this.sellAddress = sellAddress;
    }

    public String getSellPhone() {
        return sellPhone;
    }

    public void setSellPhone(String sellPhone) {
        this.sellPhone = sellPhone;
    }

    public Integer getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public String getDesignCompany() {
        return designCompany;
    }

    public void setDesignCompany(String designCompany) {
        this.designCompany = designCompany;
    }

    public Double getTotalBuildingArea() {
        return totalBuildingArea;
    }

    public void setTotalBuildingArea(Double totalBuildingArea) {
        this.totalBuildingArea = totalBuildingArea;
    }

    public String getSellProxy() {
        return sellProxy;
    }

    public void setSellProxy(String sellProxy) {
        this.sellProxy = sellProxy;
    }

    public Double getSizeRate() {
        return sizeRate;
    }

    public void setSizeRate(Double sizeRate) {
        this.sizeRate = sizeRate;
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany;
    }

    public Double getGreenRate() {
        return greenRate;
    }

    public void setGreenRate(Double greenRate) {
        this.greenRate = greenRate;
    }

    public String getBuildingCompany() {
        return buildingCompany;
    }

    public void setBuildingCompany(String buildingCompany) {
        this.buildingCompany = buildingCompany;
    }

    public Double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(Double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getProjectSummary() {
        return projectSummary;
    }

    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary;
    }
}
