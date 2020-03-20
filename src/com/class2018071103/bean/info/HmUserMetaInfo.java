package com.class2018071103.bean.info;


import com.class2018071103.bean.HmUser;

import java.util.ArrayList;
import java.util.List;

public class HmUserMetaInfo {
    private String userName;
    private String userSchool;
    private Byte userSex;
    private String userAvatar;

    public static List<HmUserMetaInfo> buildList(List<HmUser> userList) {
        List<HmUserMetaInfo> hmUserMetaInfoList = new ArrayList<>(userList.size());
        for (HmUser hmUser : userList) {
            hmUserMetaInfoList.add(build(hmUser));
        }
        return hmUserMetaInfoList;
    }

    public static HmUserMetaInfo build(HmUser user) {
        HmUserMetaInfo hmUserMetaInfo = new HmUserMetaInfo();
        hmUserMetaInfo.setUserAvatar(user.getHeadImg());
        hmUserMetaInfo.setUserName(user.getUserName());
        hmUserMetaInfo.setUserSchool(user.getUserSchool());
        hmUserMetaInfo.setUserSex(user.getUserSex());
        return hmUserMetaInfo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
}
