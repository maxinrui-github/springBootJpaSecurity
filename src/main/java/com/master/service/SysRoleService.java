package com.master.service;

import com.master.domain.SysRole;
import com.master.repository.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SysRoleService extends BaseService{
    @Autowired
    private SysRoleRepository sysRoleRepository;

    public SysRole save(SysRole sysRole) {
        return this.sysRoleRepository.save(sysRole);
    }

    public SysRole getOne(Integer id) {
        return this.sysRoleRepository.getOne(id);
    }

}