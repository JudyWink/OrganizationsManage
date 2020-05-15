package org.jude.manageBack.pojo;

import java.util.Date;

public class Activities {
    private Integer activitityid;

    private String activitityname;

    private Date activititystarttime;

    private Date activitityendtime;

    private Integer orgid;

    private Integer activitityscount;

    private String activititytype;

    private String activititydescribe;

    private String activitityplace;

    private String activititystatus;

    private String orgname;

    private Date signuptime;

    private Date signupendtime;

    public Integer getActivitityid() {
        return activitityid;
    }

    public void setActivitityid(Integer activitityid) {
        this.activitityid = activitityid;
    }

    public String getActivitityname() {
        return activitityname;
    }

    public void setActivitityname(String activitityname) {
        this.activitityname = activitityname == null ? null : activitityname.trim();
    }

    public Date getActivititystarttime() {
        return activititystarttime;
    }

    public void setActivititystarttime(Date activititystarttime) {
        this.activititystarttime = activititystarttime;
    }

    public Date getActivitityendtime() {
        return activitityendtime;
    }

    public void setActivitityendtime(Date activitityendtime) {
        this.activitityendtime = activitityendtime;
    }

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    public Integer getActivitityscount() {
        return activitityscount;
    }

    public void setActivitityscount(Integer activitityscount) {
        this.activitityscount = activitityscount;
    }

    public String getActivititytype() {
        return activititytype;
    }

    public void setActivititytype(String activititytype) {
        this.activititytype = activititytype == null ? null : activititytype.trim();
    }

    public String getActivititydescribe() {
        return activititydescribe;
    }

    public void setActivititydescribe(String activititydescribe) {
        this.activititydescribe = activititydescribe == null ? null : activititydescribe.trim();
    }

    public String getActivitityplace() {
        return activitityplace;
    }

    public void setActivitityplace(String activitityplace) {
        this.activitityplace = activitityplace == null ? null : activitityplace.trim();
    }

    public String getActivititystatus() {
        return activititystatus;
    }

    public void setActivititystatus(String activititystatus) {
        this.activititystatus = activititystatus == null ? null : activititystatus.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public Date getSignuptime() {
        return signuptime;
    }

    public void setSignuptime(Date signuptime) {
        this.signuptime = signuptime;
    }

    public Date getSignupendtime() {
        return signupendtime;
    }

    public void setSignupendtime(Date signupendtime) {
        this.signupendtime = signupendtime;
    }
}