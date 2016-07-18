package com.ray.crawler.house.service;

import java.util.List;

import com.ray.crawler.house.domain.ProjectInfo;
import com.ray.crawler.house.mapper.ProjectInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ray4w on 2016/7/15.
 */
@Service
public class ProjectInfoServiceImpl extends GenericServiceImpl<ProjectInfo> implements IProjectInfoService{

	@Autowired
	private ProjectInfoMapper projectInfoMapper;
	
	@Override
	public List<String> getProjectDetailUrls() {
		return projectInfoMapper.getProjectDetailUrls();
	}
}
