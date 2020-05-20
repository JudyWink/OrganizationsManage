package org.jude.manageBack.pojo;

import java.util.Date;

public class Documents {
    private String username;

    private Integer documentid;

    private String documentname;

    private String documentowner;

    private String documenttype;

    private Date documentuploadtime;

    private Integer downloadcount;

    private String documenturl;

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getDocumentid() {
        return documentid;
    }

    public void setDocumentid(Integer documentid) {
        this.documentid = documentid;
    }

    public String getDocumentname() {
        return documentname;
    }

    public void setDocumentname(String documentname) {
        this.documentname = documentname == null ? null : documentname.trim();
    }

    public String getDocumentowner() {
        return documentowner;
    }

    public void setDocumentowner(String documentowner) {
        this.documentowner = documentowner == null ? null : documentowner.trim();
    }

    public String getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(String documenttype) {
        this.documenttype = documenttype == null ? null : documenttype.trim();
    }

    public Date getDocumentuploadtime() {
        return documentuploadtime;
    }

    public void setDocumentuploadtime(Date documentuploadtime) {
        this.documentuploadtime = documentuploadtime;
    }

    public Integer getDownloadcount() {
        return downloadcount;
    }

    public void setDownloadcount(Integer downloadcount) {
        this.downloadcount = downloadcount;
    }

    public String getDocumenturl() {
        return documenturl;
    }

    public void setDocumenturl(String documenturl) {
        this.documenturl = documenturl == null ? null : documenturl.trim();
    }
}