package com.junhwa.doitmission13;

public class Client {
    private String name, birth, mobile;

    public Client(String name, String birth, String mobile) {
        this.name = name;
        this.birth = birth;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getMobile() {
        return mobile;
    }
}
