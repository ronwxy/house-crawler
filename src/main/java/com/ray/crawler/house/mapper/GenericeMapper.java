package com.ray.crawler.house.mapper;

import java.util.List;

import com.ray.crawler.house.domain.BaseDomain;

/**
 * Created by ray4w on 2016/7/15.
 */
public interface GenericeMapper<T extends BaseDomain> {

    public void insert(T t);

    public List<T> getAll();
}
