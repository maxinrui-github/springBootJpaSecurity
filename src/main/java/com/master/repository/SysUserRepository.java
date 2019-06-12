package com.master.repository;

import com.master.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Maxinrui
 * \* Date: 2019/6/12
 * \* Time: 9:50
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

    public SysUser findUsersByName(String name);
}