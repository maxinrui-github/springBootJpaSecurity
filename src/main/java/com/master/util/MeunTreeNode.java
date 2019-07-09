package com.master.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collections;
import java.util.List;

/**
 * @Description: 树节点
 * @Author: maxinrui
 * @CreateTime: 2019-07-08
 */
public class MeunTreeNode {

    private Integer id;

    private String text;

    private Integer parentId;

    private String href;

    private Integer sort;

    private String icon;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MeunTreeNode> nodes = Collections.emptyList();

    public MeunTreeNode() {
    }

    public MeunTreeNode(Integer id, String text, Integer parentId, String href, Integer sort, String icon) {
        this.id = id;
        this.text = text;
        this.parentId = parentId;
        this.href = href;
        this.sort = sort;
        this.icon = icon;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MeunTreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<MeunTreeNode> nodes) {
        this.nodes = nodes;
    }
}
