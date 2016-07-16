package com.ray.crawler.house.mapper;

import com.ray.crawler.house.domain.BaseDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ray4w on 2016/7/15.
 */
public interface GenericeMapper<T extends BaseDomain> {

    public T insert(T t);

    public List<T> getAll();
}
