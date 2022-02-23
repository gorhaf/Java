package main;

import java.io.Serializable;

public class Account implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private transient String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}