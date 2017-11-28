package com.ccl.exp.mvptest.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ccl.exp.mvptest.R;
import com.ccl.exp.mvptest.dagger.component.DaggerLoginActivityComponent;
import com.ccl.exp.mvptest.dagger.module.LoginActivityModule;
import com.ccl.exp.mvptest.event.MyEvent;
import com.ccl.exp.mvptest.presenter.LoginPresenterImpl;
import com.ccl.exp.mvptest.utils.ToastUtils;
import com.ccl.exp.mvptest.view.ILoginView;
import com.jakewharton.rxbinding2.view.RxView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

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

    @Inject
    LoginPresenterImpl loginPresenter;


    @OnClick(R.id.btn_login_login)
    public void loginClick(View view) {
        btnLoginLogin.setEnabled(false);
        btnLoginClear.setEnabled(false);
        loginPresenter.doLogin(etLoginUsername.getText().toString(),
                etLoginPassword.getText().toString(),
                1);
        btnLoginLogin.setEnabled(true);
        btnLoginClear.setEnabled(true);
    }

    @Override
    public void onClearText() {
        etLoginUsername.setText("");
        etLoginPassword.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, String s) {
        btnLoginLogin.setEnabled(true);
        btnLoginClear.setEnabled(true);
        startActivity(new Intent(this, SecondactActivity.class));
        ToastUtils.showToast(this, s);
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressLogin.setVisibility(visibility);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRecive(MyEvent event) {
        ToastUtils.showToast(this, event.getMsg());
    }

    @Override
    public void onError(String msg) {
        btnLoginLogin.setEnabled(true);
        btnLoginClear.setEnabled(true);
        startActivity(new Intent(this, SecondactActivity.class));
        ToastUtils.showToast(this, msg);
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
        DaggerLoginActivityComponent.builder()
                .loginActivityModule(new LoginActivityModule(this))
                .build().inject(this);
        //loginPresenter = new LoginPresenterImpl(this);
        addPresenter(loginPresenter);
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        etLoginUsername.setText(loginPresenter.getName());
        etLoginPassword.setText(loginPresenter.getPasswd());
        RxView.clicks(btnLoginClear)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        loginPresenter.clear();
                    }
                });
    }

    @Override
    public void resume() {

    }

    @Override
    public String setTag() {
        return "main";
    }

    @Override
    public void onBackPressed() {
        loginPresenter.cancelHttp();
        //super.onBackPressed();
    }
}
