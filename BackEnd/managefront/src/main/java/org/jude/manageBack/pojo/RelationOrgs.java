package org.jude.manageBack.pojo;

import java.util.Date;

public class RelationOrgs {
    private Integer relationOrgsId;

    private Integer orgid;

    private Integer userid;

    private String position;

    private String department;

    private Date jointime;

    public Integer getRelationOrgsId() {
        return relationOrgsId;
    }

    public void setRelationOrgsId(Integer relationOrgsId) {
        this.relationOrgsId = relationOrgsId;
    }

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }
}