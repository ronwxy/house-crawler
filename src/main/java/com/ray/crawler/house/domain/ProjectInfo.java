package com.ray.crawler.house.domain;

import java.util.Date;

/**
 * Created by ray4w on 2016/7/15.
 */
public class ProjectInfo extends BaseDomain{

    private static final long serialVersionUID = -6079999362323386817L;
    private String projectName;
    private String address;
    private String presellNo;
    private Date certificateDate;
    private String detailUrl;


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPresellNo() {
        return presellNo;
    }

    public void setPresellNo(String presellNo) {
        this.presellNo = presellNo;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}
    
}
