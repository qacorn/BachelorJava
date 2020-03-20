package com.class2018071002.entity;

import com.class2018071001.entity.ExamineeStatus;
import com.class2018071001.entity.Gender;
import com.class2018071001.entity.LicenseType;

public class Examinee {

    private int examineeId;
    private String identityCardNumber;
    private String name;
    private String password;
    private Gender gender;
    private LicenseType licenseType;
    private ExamineeStatus examineeStatus;
    private long addTime;
    private long updateTime;

    public int getExamineeId() {
        return examineeId;
    }

    public void setExamineeId(int examineeId) {
        this.examineeId = examineeId;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    public ExamineeStatus getExamineeStatus() {
        return examineeStatus;
    }

    public void setExamineeStatus(ExamineeStatus examineeStatus) {
        this.examineeStatus = examineeStatus;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
