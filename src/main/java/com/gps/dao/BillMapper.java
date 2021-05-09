package com.gps.dao;

import com.gps.entity.Bill;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BillMapper extends Mapper<Bill> {
  List<Bill> select(Bill bill);
}
