package ru.itis.springbootdemo.api;

import ru.itis.springbootdemo.models.User;

import java.util.List;
import java.util.Optional;

public class AjaxResponseBody {

    String msg;
    Optional<User> result;

    //getters and setters


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Optional<User> getResult() {
        return result;
    }

    public void setResult(Optional<User> result) {
        this.result = result;
    }
}