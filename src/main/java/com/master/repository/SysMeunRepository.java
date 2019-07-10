package com.master.repository;

import com.master.domain.SysMeun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Maxinrui
 * \* Date: 2019/6/12
 * \* Time: 11:32
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface SysMeunRepository extends JpaRepository<SysMeun, Integer> {

}