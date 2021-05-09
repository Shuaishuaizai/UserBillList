package com.gps.service;

import com.gps.dao.BillTypeMapper;
import com.gps.entity.BillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillTypeService {

    @Autowired
    private BillTypeMapper typeMapper;

    public List<BillType> list() {
        return typeMapper.selectAll();
    }
}
