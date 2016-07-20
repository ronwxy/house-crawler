package com.ray.crawler.house.crawler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import com.alibaba.fastjson.JSON;
import com.ray.crawler.house.domain.HouseInfo;
import com.ray.crawler.house.service.IHouseInfoService;

public class HouseParsePipeline implements Pipeline {

	@Override
	public void process(ResultItems resultItems, Task task) {
		String content = resultItems.get("content");
		String code = resultItems.get("code");
		Map<String, String> jsonMap = (Map<String, String>) JSON.parse(content);
		String tableContent = jsonMap.get("content");

		try {
			Document doc = DocumentHelper.parseText(tableContent);
			Element root = doc.getRootElement();
			Iterator rowIter = root.elementIterator("tr");
			Element rowEle = (Element) rowIter.next();
			while (rowIter.hasNext()) {
				HouseInfo houseInfo = new HouseInfo();
				rowEle = (Element) rowIter.next();
				Iterator colIter = rowEle.elementIterator("td");
				List<String> dataList = new ArrayList<String>();
				while (colIter.hasNext()) {
					Element colEle = (Element) colIter.next();

					dataList.add((String) colEle.getData());

				}
				if (dataList.size() == 11) {
					
					houseInfo.setHouseNo(dataList.get(0));
					
					
					houseInfo.setFloorNo(dataList.get(1));
					
					houseInfo.setHouseUse(dataList.get(2));
					houseInfo.setHouseType(dataList.get(3));
					houseInfo.setDecorate(dataList.get(4));
					if (dataList.get(5) != null && !"-".equals(dataList.get(5))) {
						houseInfo.setBuildingArea(Double.valueOf(dataList
								.get(5)));
					}
					if (dataList.get(6) != null && !"-".equals(dataList.get(6))) {
						houseInfo.setHouseArea(Double.valueOf(dataList.get(6)));
					}
					if (dataList.get(7) != null && !"-".equals(dataList.get(7))) {
						houseInfo.setShareArea(Double.valueOf(dataList.get(7)));
					}
					if (dataList.get(8) != null && !"-".equals(dataList.get(8))) {
						houseInfo.setPublishPrice(Double.valueOf(dataList
								.get(8)));
					}
					if (dataList.get(9) != null && !"-".equals(dataList.get(9))) {
						houseInfo
								.setTotalPrice(Double.valueOf(dataList.get(9)));
					}
					houseInfo.setSaleState(dataList.get(10));
					houseInfo.setCode(code);
					IHouseInfoService houseInfoService = HousePageProcessor
							.getContext().getBean(IHouseInfoService.class);
					houseInfoService.create(houseInfo);
				}else{
					System.out.println("Î´½âÎö£º " + dataList);
				}

			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
