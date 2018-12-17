package com.ming.system.domain;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2018/12/17 22:44
 */
public class UserVO {

    private UserDO userDO = new UserDO();

    //旧密码
    private String pwdOld;

    //新密码
    private String pwdNew;

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public String getPwdOld() {
        return pwdOld;
    }

    public void setPwdOld(String pwdOld) {
        this.pwdOld = pwdOld;
    }

    public String getPwdNew() {
        return pwdNew;
    }

    public void setPwdNew(String pwdNew) {
        this.pwdNew = pwdNew;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserVO{");
        sb.append("userDO=").append(userDO);
        sb.append(", pwdOld='").append(pwdOld).append('\'');
        sb.append(", pwdNew='").append(pwdNew).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
