package com.codegym.model;

public class ConfiguringEmail {
//    private int id;
    private String languages;
    private int pageSize;
    private String spamsFillter;
    private String signature;

    public ConfiguringEmail() {
    }

    public ConfiguringEmail(String languages, int pageSize, String spamsFillter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    //    public ConfiguringEmail(int id, String languages, int pageSize, String spamsFillter, String signature) {
//        this.id = id;
//        this.languages = languages;
//        this.pageSize = pageSize;
//        this.spamsFillter = spamsFillter;
//        this.signature = signature;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(String spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
