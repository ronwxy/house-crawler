package com.ray.crawler.house.mapper;

import java.util.List;

import com.ray.crawler.house.domain.ProjectInfo;

import org.springframework.stereotype.Repository;

/**
 * Created by ray4w on 2016/7/15.
 */
@Repository
public interface ProjectInfoMapper extends GenericeMapper<ProjectInfo> {
	
	public List<String> getProjectDetailUrls();
}
