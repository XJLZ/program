package com.xjl.service.Impl;

import com.xjl.dao.PictureDao;
import com.xjl.domain.Cos;
import com.xjl.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;

    @Override
    public void save(Cos cos) {
        pictureDao.save(cos);
    }

    @Override
    public List<Cos> findAll(Cos cos) {
        Example<Cos> example = Example.of(cos);
        //根据条件进行查询数据
        return pictureDao.findAll(example);
    }
}
