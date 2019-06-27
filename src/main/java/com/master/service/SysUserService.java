package com.master.service;

import com.master.domain.SysUser;
import com.master.repository.SysUserRepository;
import com.master.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Maxinrui
 * \* Date: 2019/6/12
 * \* Time: 9:51
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    public SysUser save(SysUser sysUser) {
        sysUser.setPassword(MD5Util.encode(sysUser.getPassword()));
        return this.sysUserRepository.save(sysUser);
    }

    public SysUser getByName(String name) {
        return this.sysUserRepository.findUsersByName(name);
    }

    public SysUser getById(Integer id) {
        return this.sysUserRepository.findById(id).get();
    }

}