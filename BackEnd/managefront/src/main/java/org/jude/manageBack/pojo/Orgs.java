package org.jude.manageBack.pojo;

import java.util.Date;

public class Orgs {
    private Integer orgid;

    private String orgname;

    private Date orgcreatetime;

    private String orgleader;

    private String orgtype;

    private String orgslogan;

    private String orgintroduce;

    private String orghistory;

    private String orgcampus;

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public Date getOrgcreatetime() {
        return orgcreatetime;
    }

    public void setOrgcreatetime(Date orgcreatetime) {
        this.orgcreatetime = orgcreatetime;
    }

    public String getOrgleader() {
        return orgleader;
    }

    public void setOrgleader(String orgleader) {
        this.orgleader = orgleader == null ? null : orgleader.trim();
    }

    public String getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(String orgtype) {
        this.orgtype = orgtype == null ? null : orgtype.trim();
    }

    public String getOrgslogan() {
        return orgslogan;
    }

    public void setOrgslogan(String orgslogan) {
        this.orgslogan = orgslogan == null ? null : orgslogan.trim();
    }

    public String getOrgintroduce() {
        return orgintroduce;
    }

    public void setOrgintroduce(String orgintroduce) {
        this.orgintroduce = orgintroduce == null ? null : orgintroduce.trim();
    }

    public String getOrghistory() {
        return orghistory;
    }

    public void setOrghistory(String orghistory) {
        this.orghistory = orghistory == null ? null : orghistory.trim();
    }

    public String getOrgcampus() {
        return orgcampus;
    }

    public void setOrgcampus(String orgcampus) {
        this.orgcampus = orgcampus == null ? null : orgcampus.trim();
    }
}