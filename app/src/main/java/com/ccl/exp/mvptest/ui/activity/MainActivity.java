package com.ccl.exp.mvptest.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ccl.exp.mvptest.R;
import com.ccl.exp.mvptest.event.MyEvent;
import com.ccl.exp.mvptest.presenter.LoginPresenterImpl;
import com.ccl.exp.mvptest.utils.ToastUtils;
import com.ccl.exp.mvptest.view.ILoginView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity implements ILoginView {

    @BindView(R.id.et_login_username)
    EditText etLoginUsername;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.btn_login_login)
    Button btnLoginLogin;
    @BindView(R.id.btn_login_clear)
    Button btnLoginClear;
    @BindView(R.id.progress_login)
    ProgressBar progressLogin;

    @OnClick(R.id.btn_login_login)
    public void loginClick(View view) {
        btnLoginLogin.setEnabled(false);
        btnLoginClear.setEnabled(false);
        loginPresenter.doLogin(etLoginUsername.getText().toString(),
                etLoginPassword.getText().toString(),
                1);
    }

    @OnClick(R.id.btn_login_clear)
    public void clearClick(View view) {
        loginPresenter.clear();
    }

    private LoginPresenterImpl loginPresenter;

    @Override
    public void onClearText() {
        etLoginUsername.setText("");
        etLoginPassword.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, String s) {
        btnLoginLogin.setEnabled(true);
        btnLoginClear.setEnabled(true);
        startActivity(new Intent(this,SecondactActivity.class));
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressLogin.setVisibility(visibility);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRecive(MyEvent event) {
        ToastUtils.showToast(this,event.getMsg());
    }

    @Override
    public void onError(String msg) {
        btnLoginLogin.setEnabled(true);
        btnLoginClear.setEnabled(true);
        startActivity(new Intent(this,SecondactActivity.class));
    }

    @Override
    public void initBefore() {
        needEventBus = true;
    }

    @Override
    public int initXmlId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initdata() {
        loginPresenter = new LoginPresenterImpl(this);
        addPresenter(loginPresenter);
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        etLoginUsername.setText(loginPresenter.getName());
        etLoginPassword.setText(loginPresenter.getPasswd());
    }

    @Override
    public void resume() {

    }

    @Override
    public String setTag() {
        return "main";
    }

}
