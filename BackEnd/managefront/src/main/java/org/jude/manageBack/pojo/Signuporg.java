package org.jude.manageBack.pojo;

import java.util.Date;

public class Signuporg {
    private Integer signupid;

    private Integer userid;

    private Integer orgid;

    private Date admissiontime;

    private String isnotadmission;

    private Date signuporgtime;

    public Integer getSignupid() {
        return signupid;
    }

    public void setSignupid(Integer signupid) {
        this.signupid = signupid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    public Date getAdmissiontime() {
        return admissiontime;
    }

    public void setAdmissiontime(Date admissiontime) {
        this.admissiontime = admissiontime;
    }

    public String getIsnotadmission() {
        return isnotadmission;
    }

    public void setIsnotadmission(String isnotadmission) {
        this.isnotadmission = isnotadmission == null ? null : isnotadmission.trim();
    }

    public Date getSignuporgtime() {
        return signuporgtime;
    }

    public void setSignuporgtime(Date signuporgtime) {
        this.signuporgtime = signuporgtime;
    }
}