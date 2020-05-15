package org.jude.manageBack.pojo;

import java.util.Date;

public class MessagesBackups {
    private Integer messageid;

    private String messagetext;

    private String messagetitle;

    private Integer messagelaunch;

    private String messagereceive;

    private String messagestatus;

    private String messagetype;

    private Date messagecreatetime;

    private Date messagereadtime;

    private String messagelaunchname;

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext == null ? null : messagetext.trim();
    }

    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle == null ? null : messagetitle.trim();
    }

    public Integer getMessagelaunch() {
        return messagelaunch;
    }

    public void setMessagelaunch(Integer messagelaunch) {
        this.messagelaunch = messagelaunch;
    }

    public String getMessagereceive() {
        return messagereceive;
    }

    public void setMessagereceive(String messagereceive) {
        this.messagereceive = messagereceive == null ? null : messagereceive.trim();
    }

    public String getMessagestatus() {
        return messagestatus;
    }

    public void setMessagestatus(String messagestatus) {
        this.messagestatus = messagestatus == null ? null : messagestatus.trim();
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype == null ? null : messagetype.trim();
    }

    public Date getMessagecreatetime() {
        return messagecreatetime;
    }

    public void setMessagecreatetime(Date messagecreatetime) {
        this.messagecreatetime = messagecreatetime;
    }

    public Date getMessagereadtime() {
        return messagereadtime;
    }

    public void setMessagereadtime(Date messagereadtime) {
        this.messagereadtime = messagereadtime;
    }

    public String getMessagelaunchname() {
        return messagelaunchname;
    }

    public void setMessagelaunchname(String messagelaunchname) {
        this.messagelaunchname = messagelaunchname == null ? null : messagelaunchname.trim();
    }
}