package org.jude.manageBack.pojo;

import java.util.Date;

public class RelationActivities {
    private Integer relationActivitiesId;

    private Integer orgid;

    private Integer userid;

    private Date sinuptime;

    private String admission;

    private Integer activitiesid;

    private String actname;

    public Integer getRelationActivitiesId() {
        return relationActivitiesId;
    }

    public void setRelationActivitiesId(Integer relationActivitiesId) {
        this.relationActivitiesId = relationActivitiesId;
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

    public Date getSinuptime() {
        return sinuptime;
    }

    public void setSinuptime(Date sinuptime) {
        this.sinuptime = sinuptime;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission == null ? null : admission.trim();
    }

    public Integer getActivitiesid() {
        return activitiesid;
    }

    public void setActivitiesid(Integer activitiesid) {
        this.activitiesid = activitiesid;
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname == null ? null : actname.trim();
    }
}