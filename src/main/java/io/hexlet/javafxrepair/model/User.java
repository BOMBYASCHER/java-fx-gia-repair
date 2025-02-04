package io.hexlet.javafxrepair.model;

public class User {
    private Integer id;
    private String fio;
    private String phone;
    private String login;
    private String password;
    private String type;

    public User(String type, String password, String login, String phone, String fio, Integer id) {
        this.type = type;
        this.password = password;
        this.login = login;
        this.phone = phone;
        this.fio = fio;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getPhone() {
        return phone;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }
}
