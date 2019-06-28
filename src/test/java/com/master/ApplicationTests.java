package com.master;

import com.master.domain.SysMeun;
import com.master.domain.SysRole;
import com.master.domain.SysUser;
import com.master.error.BusinessException;
import com.master.repository.SysMeunRepository;
import com.master.repository.SysRoleRepository;
import com.master.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleRepository sysRoleRepository;
    @Autowired
    private SysMeunRepository sysMeunRepository;

    @Test
    @Transactional
    public void save() {
        SysUser user = new SysUser();
        user.setName("admin");
        user.setPassword("e3d0c85bf9d69d7ff11c1440a870d6c7");
        SysRole role = new SysRole();
        SysRole role1 = new SysRole();
        role.setName("ROLE_ADMIN");
        role1.setName("ROLE_USER");
        Set roles = new HashSet<>();
        roles.add(role);
        roles.add(role1);
        user.setRoles(roles);

        SysMeun meun = new SysMeun();
        SysMeun meun1 = new SysMeun();
        meun.setName("菜单一");
        meun1.setName("菜单二");
        Set meuns = new HashSet<>();
        meuns.add(meun);
        meuns.add(meun1);
        meun.setRoles(roles);
        meun1.setRoles(roles);
        role.setMeun(meuns);
        this.sysMeunRepository.saveAll(meuns);
        this.sysRoleRepository.saveAll(roles);
        try {
            this.sysUserService.save(user);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

}
