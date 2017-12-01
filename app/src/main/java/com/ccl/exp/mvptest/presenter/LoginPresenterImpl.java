package com.ccl.exp.mvptest.presenter;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;

import com.ccl.exp.mvptest.global.GlobalApplication;
import com.ccl.exp.mvptest.model.LoginModel;
import com.ccl.exp.mvptest.model.UserModel;
import com.ccl.exp.mvptest.net.RetrofitManager;
import com.ccl.exp.mvptest.net.api.UserLogin;
import com.ccl.exp.mvptest.net.params.PostParams;
import com.ccl.exp.mvptest.net.response.BaseResponse;
import com.ccl.exp.mvptest.presenter.inter.ILoginPresenter;
import com.ccl.exp.mvptest.rx.NormalSubcriber;
import com.ccl.exp.mvptest.rx.RxManager;
import com.ccl.exp.mvptest.rx.RxSubscriptionManager;
import com.ccl.exp.mvptest.utils.CommonUtils;
import com.ccl.exp.mvptest.utils.LogUtil;
import com.ccl.exp.mvptest.utils.MD5Util;
import com.ccl.exp.mvptest.utils.ToastUtils;
import com.ccl.exp.mvptest.view.ILoginView;

import io.reactivex.Flowable;


/**
 * Created by ccl on 2017/11/2.
 */

public class LoginPresenterImpl extends BasePresenter<ILoginView> implements ILoginPresenter {
    private UserModel user;
    private Handler handler;

    public LoginPresenterImpl(ILoginView view) {
        super(view);
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void initData() {
        user = new UserModel();
        user.setName("mvp");
        user.setPassword("123456");
    }

    @Override
    public void clear() {
        mView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd, int force) {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.getInstance().getApplicationContext()
                .getSystemService(Context.TELEPHONY_SERVICE);
        WifiManager wm = (WifiManager) GlobalApplication.getInstance().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        String m_szWLANMAC = wm.getConnectionInfo().getMacAddress();
        String IMEI = telephonyManager.getDeviceId();
        String ICCID = "";
        try {
            ICCID = telephonyManager.getSimSerialNumber();
        } catch (Exception e) {
        } finally {
            String strDID = CommonUtils.getAndroidID() + IMEI + m_szWLANMAC;
            if ("0123456789ABCDEF".equals(strDID)) {
                ToastUtils.showToast(mView.getContext(), "未获取到设置唯一码,请重试");
                return;
            }
            if (TextUtils.isEmpty(name)) {
                ToastUtils.showToast(mView.getContext(), "请输入账号");
                return;
            }
            String strUserName = name;
            if (TextUtils.isEmpty(passwd)) {
                ToastUtils.showToast(mView.getContext(), "请输入密码");
                return;
            }
            String strUserPwd = passwd;
            String version = CommonUtils.getVersion(GlobalApplication.getInstance().getApplicationContext());
            PostParams postParams = new PostParams();
            postParams.addParams("loginName", strUserName);
            postParams.addParams("deviceNumber", strDID);
            postParams.addParams("iccid", ICCID);
            postParams.addParams("appVersion", "3.1.1.171020");
            postParams.addParams("password", MD5Util.getMD5(strUserPwd.toLowerCase().getBytes(), true));
            postParams.addParams("deviceName", Build.FINGERPRINT);
            postParams.addParams("isForce", "" + force);
            toLogin(postParams);
        }
    }

    @Override
    public String getName() {
        return user == null ? "" : user.getName();
    }

    @Override
    public String getPasswd() {
        return user == null ? "" : user.getPassword();
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        mView.onSetProgressBarVisibility(visiblity);
    }

    @Override
    public void toLogin(PostParams loginInfo) {
        setProgressBarVisiblity(View.VISIBLE);
        Flowable<BaseResponse<LoginModel>> loginFlowable = RetrofitManager.getInstance().create(UserLogin.class).userLogin(loginInfo);
        RxManager.getInstance().doSubscribe1(loginFlowable, new NormalSubcriber<LoginModel>(true, mView.getContext(), UserLogin.class.getSimpleName()) {

            @Override
            protected void _onError(Throwable t) {
                LogUtil.e(this, t.getMessage());
                setProgressBarVisiblity(View.INVISIBLE);
                mView.onError(t.getMessage());
            }

            @Override
            protected void onResponse(LoginModel loginModel) {
                LogUtil.e(this, loginModel.toString());
                setProgressBarVisiblity(View.INVISIBLE);
                mView.onLoginResult(true, loginModel.getStudentName());
            }
        });
    }

    @Override
    public void cancelHttp() {
        RxSubscriptionManager.getsInstance().cancel(UserLogin.class.getSimpleName());
        setProgressBarVisiblity(View.INVISIBLE);
        mView.onError("取消请求");
    }
}
