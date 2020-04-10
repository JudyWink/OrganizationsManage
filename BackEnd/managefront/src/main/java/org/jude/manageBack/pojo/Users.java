package org.jude.manageBack.pojo;

import java.util.Date;

public class Users {
    private Integer userid;

    private String useracount;

    private String userpassword;

    private Date createtime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUseracount() {
        return useracount;
    }

    public void setUseracount(String useracount) {
        this.useracount = useracount == null ? null : useracount.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}