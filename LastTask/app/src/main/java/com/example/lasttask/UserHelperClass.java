package com.example.lasttask;

public class UserHelperClass {

    String name, branch, regdNo, sub, subCode;

    public UserHelperClass() {

    }

    public UserHelperClass(String name, String branch, String regdNo, String sub, String subCode) {
        this.name = name;
        this.branch = branch;
        this.regdNo = regdNo;
        this.sub = sub;
        this.subCode = subCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getRegdNo() {
        return regdNo;
    }

    public void setRegdNo(String regdNo) {
        this.regdNo = regdNo;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }
}
