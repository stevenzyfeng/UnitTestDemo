package com.bytedancer.unittestdemo;

import java.io.File;

public class User {

    private static final String CONFIG = "configfiles";
    private static final String TAIL = ".cfg";

    String mName;

    public User(String name) {
        this.mName = name;
    }

    public String configFileName() {
        return CONFIG + File.separator + mName + TAIL;
    }
}
