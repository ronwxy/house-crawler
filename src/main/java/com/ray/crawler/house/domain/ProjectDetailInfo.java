package com.ray.crawler.house.domain;

import java.util.Date;

/**
 * Created by ray4w on 2016/7/15.
 */
public class ProjectDetailInfo extends BaseDomain {

    private static final long serialVersionUID = -9221213283825045950L;
    private String projectName;
    private Integer approveSellNum;
    private Integer availableSellNum;
    private Double publicMinPrice;
    private Double publicMaxPrice;
    private String area;
    private String approveNo;
    private String company;
    private Integer buildingNum;
    private String projectAddress;
    private Double minPrice; //�������
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
    private String buildCompany;
    private Double propertyPrice;
    private Date finishDate;
    private String projectSummary;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public Integer getApproveSellNum() {
		return approveSellNum;
	}

	public void setApproveSellNum(Integer approveSellNum) {
		this.approveSellNum = approveSellNum;
	}

	public Integer getAvailableSellNum() {
		return availableSellNum;
	}

	public void setAvailableSellNum(Integer availableSellNum) {
		this.availableSellNum = availableSellNum;
	}

	public Double getPublicMinPrice() {
		return publicMinPrice;
	}

	public void setPublicMinPrice(Double publicMinPrice) {
		this.publicMinPrice = publicMinPrice;
	}

	public Double getPublicMaxPrice() {
		return publicMaxPrice;
	}

	public void setPublicMaxPrice(Double publicMaxPrice) {
		this.publicMaxPrice = publicMaxPrice;
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
    
    public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
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

    public String getBuildCompany() {
		return buildCompany;
	}

	public void setBuildCompany(String buildCompany) {
		this.buildCompany = buildCompany;
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
