package com.master.controller;

import com.master.domain.SysMeun;
import com.master.error.BusinessException;
import com.master.response.CommonReturnType;
import com.master.service.BaseService;
import com.master.service.SysMeunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author maxinrui
 * @date 2019/1/16
 */
@Controller
@RequestMapping("sysmeun")
public class SysMeunController extends BaseService {
    @Autowired
    private SysMeunService sysMeunService;

    @RequestMapping("treeList")
    public String showTreeList() {
        return "meun/MeunTreeList";
    }

    @GetMapping("getMeunTree")
    @ResponseBody
    public CommonReturnType simpleTree() {
        return CommonReturnType.create(sysMeunService.getMeunTree());
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public CommonReturnType saveOrUpdate(SysMeun meun) throws BusinessException {
        return CommonReturnType.create(this.sysMeunService.saveOrUpdate(meun));
    }
}
