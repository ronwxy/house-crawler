package com.ray.crawler.house.service;

import com.ray.crawler.house.domain.BaseDomain;

import java.util.List;

/**
 * Created by ray4w on 2016/7/15.
 */
public interface IGenericService<T extends BaseDomain> {

    public T create(T t);

    public List<T> getAll();


}
