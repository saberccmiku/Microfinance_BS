package com.saber.credit.bean;


public class SaveBusinessAttachParams {    
    /**
     * 业务单的id
     */
    private String id;
    /**
     * 附件id，以逗号分隔的字符串
     */
    private String attachIds;
    /**
     * 业务模块标准，例如ITSM,WO,FIN,……
     */
    private String model;    
    /**
     * 子功能点；例如ITSM模块下的信息工单:"INFOWO"
     */
    private String function;    
    /**
     * 上传环节
     */
    private String loadPhase;    
    /**
     * 上传人
     */
    private String loadUser ;   
    /**
     * 站点
     */
    private String siteid ;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getAttachIds() {
        return attachIds;
    }


    public void setAttachIds(String attachIds) {
        this.attachIds = attachIds;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public String getFunction() {
        return function;
    }


    public void setFunction(String function) {
        this.function = function;
    }


    public String getLoadPhase() {
        return loadPhase;
    }


    public void setLoadPhase(String loadPhase) {
        this.loadPhase = loadPhase;
    }


    public String getLoadUser() {
        return loadUser;
    }


    public void setLoadUser(String loadUser) {
        this.loadUser = loadUser;
    }


    public String getSiteid() {
        return siteid;
    }


    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }


    @Override
    public String toString() {
        return "saveBusinessAttachParams [id=" + id + ", attachIds=" + attachIds + ", model=" + model + ", function="
                + function + ", loadPhase=" + loadPhase +  ", loadUser=" + loadUser
                + ", siteid=" + siteid + "]";
    }
    
   
}
