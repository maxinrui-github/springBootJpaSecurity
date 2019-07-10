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

    @Transactional
    @Modifying
    @Query(value = "UPDATE sys_meun m SET " +
                    "m.name =CASE WHEN :#{#meun.name} IS NULL THEN m.name ELSE :#{#meun.name} END ," +
                    "m.href =CASE WHEN :#{#meun.href} IS NULL THEN m.href ELSE :#{#meun.href} END ," +
                    "m.parent_id =CASE WHEN :#{#meun.parentId} IS NULL THEN m.parent_id ELSE :#{#meun.parentId} END ," +
                    "m.sort =CASE WHEN :#{#meun.sort} IS NULL THEN m.sort ELSE :#{#meun.sort} END ," +
                    "m.icon =CASE WHEN :#{#meun.icon} IS NULL THEN  m.icon ELSE :#{#meun.icon} END " +
                    " WHERE m.id=:#{#meun.id}",nativeQuery = true)
    int updateById(@Param("meun") SysMeun meun);

}