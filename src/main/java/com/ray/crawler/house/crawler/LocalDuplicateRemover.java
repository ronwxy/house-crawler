package com.ray.crawler.house.crawler;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

public class LocalDuplicateRemover implements DuplicateRemover{
	
	private List<String> requestUrls = new ArrayList<String>();

	public boolean isDuplicate(Request request, Task task) {
		NameValuePair[] nameValuePairs = (NameValuePair[]) request.getExtra("nameValuePair");
//		NameValuePair value = nameValuePairs[1];
//		System.out.println("handle page=====:  " + value);
		return false;
	}

	public void resetDuplicateCheck(Task task) {
		requestUrls.clear();
	}

	public int getTotalRequestsCount(Task task) {
		return requestUrls.size();
	}

	
}
