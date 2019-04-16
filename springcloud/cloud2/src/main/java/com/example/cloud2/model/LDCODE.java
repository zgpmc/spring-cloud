package com.example.cloud2.model;

public class LDCODE {
    private String codetype;

    private String code;

    private String codename;

    private String describe;

    public LDCODE(String codetype, String code, String codename, String describe) {
        this.codetype = codetype;
        this.code = code;
        this.codename = codename;
        this.describe = describe;
    }

    public LDCODE() {
        super();
    }

    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype == null ? null : codetype.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename == null ? null : codename.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}