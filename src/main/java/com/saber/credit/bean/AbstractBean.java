package com.saber.credit.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saber on 2019/1/2
 * 基类
 */
public class AbstractBean {

    private String id;
    private String createUser;
    private Date createDate;
    private String lastChangeUser;
    private Date lastChangeDate;
    private String delFlag;

    /**
     * 附件id，用来接收请求参数保存<br/>
     * 支持多个类别的附件attachmentType-attachmentIdList
     */
    Map<String,List<String>> attachmentIdListMap=new HashMap<String, List<String>>();
    /**
     * 附件，用来返回页面渲染附件<br/>
     * 支持多个类别的附件attachmentType-attachmentIdList
     */
    Map<String,List<Map<String, Object>>>attachmentListMap=new HashMap<String, List<Map<String, Object>>>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastChangeUser() {
        return lastChangeUser;
    }

    public void setLastChangeUser(String lastChangeUser) {
        this.lastChangeUser = lastChangeUser;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Map<String, List<String>> getAttachmentIdListMap() {
        return attachmentIdListMap;
    }

    public void setAttachmentIdListMap(Map<String, List<String>> attachmentIdListMap) {
        this.attachmentIdListMap = attachmentIdListMap;
    }

    public Map<String, List<Map<String, Object>>> getAttachmentListMap() {
        return attachmentListMap;
    }

    public void setAttachmentListMap(Map<String, List<Map<String, Object>>> attachmentListMap) {
        this.attachmentListMap = attachmentListMap;
    }
}
