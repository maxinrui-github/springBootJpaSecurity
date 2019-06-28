package com.master.controller;

import com.master.controller.viewobject.UserVO;
import com.master.domain.SysUser;
import com.master.error.BusinessException;
import com.master.error.EmBusinessError;
import com.master.response.CommonReturnType;
import com.master.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Maxinrui
 * \* Date: 2019/6/12
 * \* Time: 9:35
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
@RequestMapping("user")
public class SysUserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/getUser")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        SysUser user = this.sysUserService.getById(id);
        if (user == null) {
           // user.setPassword("1");
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        UserVO userVO = convertFromModel(user);
        return CommonReturnType.create(userVO);
    }

    public UserVO convertFromModel(SysUser user) {
        if (user == null) return null;
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;

    }
}