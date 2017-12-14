package com.connxun.morui.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.connxun.morui.view.widget.treeview.TreeNodeId;
import com.connxun.morui.view.widget.treeview.TreeNodeLabel;
import com.connxun.morui.view.widget.treeview.TreeNodePid;

/**
 * @author wushange
 * @date 2017/12/14
 */

@Entity
public class Contacts {
    /**
     * id : DK200
     * name : 生产部
     * pId : 0
     */
    @PrimaryKey
    @TreeNodeId
    @NonNull
    private String id;
    @TreeNodeLabel
    private String name;
    @TreeNodePid
    private String pid;

    private long userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
