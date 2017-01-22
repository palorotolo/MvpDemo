package me.maybewill.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.maybewill.mvpdemo.Interface.MainInterface;
import me.maybewill.mvpdemo.Presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainInterface {

    private EditText edittext_password;
    private EditText edittext_username;
    private Button button;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        edittext_password = (EditText) findViewById(R.id.edittext_password);
        edittext_username = (EditText) findViewById(R.id.edittext_username);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        mainPresenter = new MainPresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                LoginEvent();
                break;
        }
    }

    private void LoginEvent() {
        String password = edittext_password.getText().toString();
        String username = edittext_username.getText().toString();
        mainPresenter.login(username, password);
    }

    @Override
    public void LoginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
