package com.master.service;

import com.master.domain.SysMeun;
import com.master.domain.SysRole;
import com.master.domain.SysUser;
import com.master.repository.SysMeunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Maxinrui
 * \* Date: 2019/6/12
 * \* Time: 11:34
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class SysMeunService {
    @Autowired
    private SysUserService sysUserService;

    public Set<SysMeun> getMeuns() {
        Set<SysMeun> meuns = new HashSet();
        SysUser user = getUserDetails();
        Set<SysRole> roles = user.getRoles();
        for (SysRole role : roles) {
            meuns.addAll(role.getMeun());
        }
        return meuns;
    }

    private SysUser getUserDetails() {
        //获取当前用户
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        //查询当前用户
        SysUser user = this.sysUserService.getByName(userDetails.getUsername());
        return user;
    }
}