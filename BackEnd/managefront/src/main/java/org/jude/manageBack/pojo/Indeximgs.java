package org.jude.manageBack.pojo;

public class Indeximgs {
    private Integer indeximgid;

    private String indeximgurl;

    private String indeximgcreatetime;

    private Integer indeximgownerorg;

    private String indeximgowner;

    public Integer getIndeximgid() {
        return indeximgid;
    }

    public void setIndeximgid(Integer indeximgid) {
        this.indeximgid = indeximgid;
    }

    public String getIndeximgurl() {
        return indeximgurl;
    }

    public void setIndeximgurl(String indeximgurl) {
        this.indeximgurl = indeximgurl == null ? null : indeximgurl.trim();
    }

    public String getIndeximgcreatetime() {
        return indeximgcreatetime;
    }

    public void setIndeximgcreatetime(String indeximgcreatetime) {
        this.indeximgcreatetime = indeximgcreatetime == null ? null : indeximgcreatetime.trim();
    }

    public Integer getIndeximgownerorg() {
        return indeximgownerorg;
    }

    public void setIndeximgownerorg(Integer indeximgownerorg) {
        this.indeximgownerorg = indeximgownerorg;
    }

    public String getIndeximgowner() {
        return indeximgowner;
    }

    public void setIndeximgowner(String indeximgowner) {
        this.indeximgowner = indeximgowner == null ? null : indeximgowner.trim();
    }
}