package com.nhnacademy.board.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BoardUser implements User, Serializable {
    private String id;
    private String password;
    private String name;
    private String profileFileName;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProfileFileName() {
        return this.profileFileName;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        this.profileFileName = profileFileName;
    }
}
