package com.ray.crawler.house.domain;

import java.util.Date;

/**
 * Created by ray4w on 2016/7/15.
 */
public class BuildingInfo extends BaseDomain {

    private static final long serialVersionUID = 2176786695143534716L;
    private String presellNo;
    private String buildingNo;
    private Date certificateDate;
    private Double approveSellArea;
    private String landNo;
    private String projectApproveNo;
    private String landApproveNo;
    private String buildApproveNo;
    private String code;

    public String getPresellNo() {
        return presellNo;
    }

    public void setPresellNo(String presellNo) {
        this.presellNo = presellNo;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public Double getApproveSellArea() {
        return approveSellArea;
    }

    public void setApproveSellArea(Double approveSellArea) {
        this.approveSellArea = approveSellArea;
    }

    public String getLandNo() {
        return landNo;
    }

    public void setLandNo(String landNo) {
        this.landNo = landNo;
    }

    public String getProjectApproveNo() {
        return projectApproveNo;
    }

    public void setProjectApproveNo(String projectApproveNo) {
        this.projectApproveNo = projectApproveNo;
    }

    public String getLandApproveNo() {
        return landApproveNo;
    }

    public void setLandApproveNo(String landApproveNo) {
        this.landApproveNo = landApproveNo;
    }

    public String getBuildApproveNo() {
        return buildApproveNo;
    }

    public void setBuildApproveNo(String buildApproveNo) {
        this.buildApproveNo = buildApproveNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
