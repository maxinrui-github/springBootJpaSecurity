package com.master.service;

import com.master.domain.SysMeun;
import com.master.domain.SysUser;
import com.master.error.BusinessException;
import com.master.error.EmBusinessError;
import com.master.repository.SysMeunRepository;
import com.master.repository.SysUserRepository;
import com.master.util.MD5Util;
import com.master.util.MeunTreeNode;
import com.master.validator.ValidationResult;
import com.master.validator.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
public class SysMeunService extends BaseService {
    @Autowired
    private SysMeunRepository sysMeunRepository;
    @Autowired
    private ValidatorImpl validator;

    public Map getMeuns() {
        Set<SysMeun> meuns = new TreeSet<>();
        getCurrentUser().getRoles().forEach(role -> {
            meuns.addAll(role.getMeun());
        });
        Map result = new HashMap();
        result.put("meuns", meuns);
        result.put("user", getCurrentUser());
        return result;
    }

    public int update(SysMeun meun) throws BusinessException {
        ValidationResult result = validator.validate(meun);
        if (result.isHasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, result.getErrMsg());
        }
        int updateResult = this.sysMeunRepository.updateById(meun);
        if (updateResult < 1) {
            throw new BusinessException(EmBusinessError.UPDATE_ERROR, result.getErrMsg());
        }
        return updateResult;
    }

    public SysMeun save(SysMeun meun) throws BusinessException {
        ValidationResult result = validator.validate(meun);
        if (result.isHasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, result.getErrMsg());
        }
        int updateResult = this.sysMeunRepository.updateById(meun);
        return this.sysMeunRepository.save(meun);
    }

    public List<MeunTreeNode> getMeunTree() {

        List<SysMeun> meuns = this.sysMeunRepository.findAll();
        List<MeunTreeNode> treeNodes = new ArrayList<>();
        if (meuns.size() > 0 && meuns != null) {
            List<MeunTreeNode> nodeList = null;
            for (int i = 0; i < meuns.size(); i++) {
                if (meuns.get(i).getParentId() == 0) {
                    MeunTreeNode node = new MeunTreeNode(meuns.get(i).getId(), meuns.get(i).getName(), meuns.get(i).getParentId(), meuns.get(i).getHref(), meuns.get(i).getSort(), meuns.get(i).getIcon());
                    nodeList = new ArrayList<>();
                    treeNodes.add(node);
                    for (int j = 0; j < meuns.size(); j++) {
                        if (meuns.get(j).getParentId() == meuns.get(i).getId()) {
                            MeunTreeNode temp = new MeunTreeNode(meuns.get(j).getId(), meuns.get(j).getName(), meuns.get(j).getParentId(), meuns.get(j).getHref(), meuns.get(j).getSort(), meuns.get(j).getIcon());
                            nodeList.add(temp);
                        }
                    }
                    node.setNodes(nodeList);
                }
            }

        }
        return treeNodes;
    }
}