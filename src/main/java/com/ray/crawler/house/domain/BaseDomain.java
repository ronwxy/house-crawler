package com.ray.crawler.house.domain;

import java.io.Serializable;

/**
 * Created by ray4w on 2016/7/15.
 */
public abstract class BaseDomain implements Serializable{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
