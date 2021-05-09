package com.gps.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gps.entity.Bill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BillServiceTest {


    @Autowired
    private BillService service;

    @Test
    public void testList() {

        Bill bill=new Bill();
        bill.setTitle("a");
        service.list(bill).forEach(b -> System.out.println(b.getTitle()));
//        Bill bill = service.get(4l);
//        System.out.println(bill);
    }

    @Test
    public void findPage() {
        Bill b = new Bill();
        b.setTitle("a");
        PageInfo<Bill> page = PageHelper.startPage(1, 10).doSelectPageInfo(() -> {
            service.list(b);
        });
        page.getList().forEach(bill1 -> {
            System.out.println(bill1.getId() + " " + bill1.getTitle());
        });
        System.out.println("总行数=" + page.getTotal());
        System.out.println("当前页=" + page.getPageNum());
        System.out.println("每页行数=" + page.getPageSize());
        System.out.println("总页数=" + page.getPages());
        System.out.println("起始行数=" + page.getStartRow());
        System.out.println("是第一页=" + page.isIsFirstPage());
        System.out.println("是最后页=" + page.isIsLastPage());
        System.out.println("还有下一页=" + page.isHasNextPage());
        System.out.println("还有上一页=" + page.isHasPreviousPage());
        System.out.println("页码列表" + Arrays.toString(page.getNavigatepageNums()));
    }
}