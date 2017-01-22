package me.maybewill.mvpdemo.Presenter;

import android.text.TextUtils;

import me.maybewill.mvpdemo.Interface.MainInterface;

/**
 * Created by yao on 2017/1/22.
 */

public class MainPresenter {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private final MainInterface view;

    public MainPresenter(MainInterface view) {
        this.view = view;
    }

    public void login (String username, String password) {
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(username)) {
            view.LoginFailed("账号或密码不能为空");
        } else if (username.length() < 3) {
            view.LoginFailed("账号长度不能小于3位");
        } else if (username.equals(USERNAME)) {
            if (password.equals(PASSWORD)) {
                view.LoginSuccess();
            } else {
                view.LoginFailed("密码错误");
            }
        } else {
            view.LoginFailed("账号错误");
        }
    }
}
