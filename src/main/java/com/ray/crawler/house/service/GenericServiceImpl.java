package com.ray.crawler.house.service;

import com.ray.crawler.house.domain.BaseDomain;
import com.ray.crawler.house.mapper.GenericeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ray4w on 2016/7/15.
 */
public abstract class GenericServiceImpl<T extends BaseDomain> implements IGenericService<T> {

    @Autowired
    private GenericeMapper<T> genericeMapper;

    public T create(T t) {
        genericeMapper.insert(t);
        return t;
    }

    public List<T> getAll() {
        return genericeMapper.getAll();
    }
}
