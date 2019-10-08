package com.xjl.service;

import com.xjl.domain.Cos;

import java.util.List;

public interface PictureService {
    /**
     * 保存商品
     * @param cos
     */
    void save(Cos cos);

    /**
     * 根据条件查询商品
     * @param cos
     * @return
     */
    List<Cos> findAll(Cos cos);
}
