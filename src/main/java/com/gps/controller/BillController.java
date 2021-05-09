package com.gps.controller;

import com.github.pagehelper.PageInfo;
import com.gps.entity.Bill;
import com.gps.entity.BillType;
import com.gps.service.BillService;
import com.gps.service.BillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private BillTypeService typeService;

    /**
     * 查询
     *
     * @param bill
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Bill bill, Model model) {
        List<BillType> types = typeService.list();
        model.addAttribute("types", types);
        List<Bill> bills = billService.list(bill);
        model.addAttribute("list", bills);
        model.addAttribute("bill", bill);
        return "/bill/list";
    }

    /**
     * 跳转到添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model) {
        List<BillType> types = typeService.list();
        model.addAttribute("types", types);
        return "/bill/add";
    }

    /**
     * 进行添加
     *
     * @param bill
     * @return
     */
    @RequestMapping("/add")
    public String add(Bill bill) {
        billService.add(bill);
        return "redirect:/bill/list";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        billService.delete(id);
        return "redirect:/bill/list";
    }

    /**
     * 修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") long id, Model model) {
        List<BillType> types = typeService.list();
        model.addAttribute("types", types);
        Bill bill = billService.get(id);
        model.addAttribute("bill", bill);
        return "/bill/update";
    }

    @RequestMapping("/update")
    public String update(Bill bill) {
        billService.update(bill);
        return "redirect:/bill/list";
    }

    @RequestMapping("/list-page")
    public String listPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            Bill b,
            Model model
    ) {
        List<BillType> types = typeService.list();
        model.addAttribute("types", types);
        PageInfo<Bill> page = billService.listPage(b, pageNum, pageSize);
        model.addAttribute("page", page);
        return "/bill/list-page";

    }
}
