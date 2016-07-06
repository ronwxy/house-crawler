package com.ray.crawler.house;

import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

public class LocalDuplicateRemover implements DuplicateRemover{
	
	private List<String> requestUrls = new ArrayList<String>();

	public boolean isDuplicate(Request request, Task task) {
		return false;
	}

	public void resetDuplicateCheck(Task task) {
		requestUrls.clear();
	}

	public int getTotalRequestsCount(Task task) {
		return requestUrls.size();
	}

	
}
