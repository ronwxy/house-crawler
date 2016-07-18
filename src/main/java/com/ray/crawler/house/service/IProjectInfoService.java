package com.ray.crawler.house.service;

import java.util.List;

import com.ray.crawler.house.domain.ProjectInfo;

/**
 * Created by ray4w on 2016/7/15.
 */
public interface IProjectInfoService extends IGenericService<ProjectInfo> {
	
	public List<String> getProjectDetailUrls();
}
