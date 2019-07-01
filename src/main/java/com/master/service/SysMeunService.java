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
import java.util.TreeSet;

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
public class SysMeunService extends BaseService{
    @Autowired
    private SysUserService sysUserService;

    public Set<SysMeun> getMeuns() {
        Set<SysMeun> meuns = new TreeSet<>();
        getCurrentUser().getRoles().forEach(role -> {
            meuns.addAll(role.getMeun());
        });
        return meuns;
    }
}