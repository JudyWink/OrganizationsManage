package org.jude.manageBack.pojo;

import java.util.Date;

public class Users {
    private Integer userid;

    private String username;

    private String useracount;

    private String userpassword;

    private String usertype;

    private String usersex;

    private String userphone;

    private String usernumber;

    private String useracademy;

    private String userclass;

    private String userhobby;

    private String useremail;

    private String userqq;

    private String userwechat;

    private String userphoto;

    private String defultorg;

    private String dormitory;

    private Date createtime;

    private Date updatetime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber == null ? null : usernumber.trim();
    }

    public String getUseracademy() {
        return useracademy;
    }

    public void setUseracademy(String useracademy) {
        this.useracademy = useracademy == null ? null : useracademy.trim();
    }

    public String getUserclass() {
        return userclass;
    }

    public void setUserclass(String userclass) {
        this.userclass = userclass == null ? null : userclass.trim();
    }

    public String getUserhobby() {
        return userhobby;
    }

    public void setUserhobby(String userhobby) {
        this.userhobby = userhobby == null ? null : userhobby.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserqq() {
        return userqq;
    }

    public void setUserqq(String userqq) {
        this.userqq = userqq == null ? null : userqq.trim();
    }

    public String getUserwechat() {
        return userwechat;
    }

    public void setUserwechat(String userwechat) {
        this.userwechat = userwechat == null ? null : userwechat.trim();
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }

    public String getDefultorg() {
        return defultorg;
    }

    public void setDefultorg(String defultorg) {
        this.defultorg = defultorg == null ? null : defultorg.trim();
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory == null ? null : dormitory.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}