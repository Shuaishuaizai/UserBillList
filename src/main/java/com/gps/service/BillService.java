package com.gps.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gps.dao.BillMapper;
import com.gps.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {


    @Autowired
    private BillMapper billMapper;

    public List<Bill> list(Bill b) {
        return billMapper.select(b);
    }

    public int add(Bill bill) {
        return billMapper.insert(bill);
    }

    public Bill get(Long id) {
        return billMapper.selectByPrimaryKey(id);
    }

    public int update(Bill b) {
        return billMapper.updateByPrimaryKey(b);
    }

    public int delete(Long id) {
        return billMapper.deleteByPrimaryKey(id);
    }

    public PageInfo<Bill> listPage(Bill b, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
            billMapper.select(b);
        });
    }
}
