package org.jude.manageBack.pojo;

import java.util.Date;

public class RelationPosition {
    private Integer relationPositionId;

    private Integer orgid;

    private Integer userid;

    private String orgposition;

    private Date joinpositiontime;

    private Date leavepositiontime;

    public Integer getRelationPositionId() {
        return relationPositionId;
    }

    public void setRelationPositionId(Integer relationPositionId) {
        this.relationPositionId = relationPositionId;
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

    public String getOrgposition() {
        return orgposition;
    }

    public void setOrgposition(String orgposition) {
        this.orgposition = orgposition == null ? null : orgposition.trim();
    }

    public Date getJoinpositiontime() {
        return joinpositiontime;
    }

    public void setJoinpositiontime(Date joinpositiontime) {
        this.joinpositiontime = joinpositiontime;
    }

    public Date getLeavepositiontime() {
        return leavepositiontime;
    }

    public void setLeavepositiontime(Date leavepositiontime) {
        this.leavepositiontime = leavepositiontime;
    }
}