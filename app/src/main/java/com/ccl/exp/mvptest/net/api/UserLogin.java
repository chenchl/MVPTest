package com.ccl.exp.mvptest.net.api;

import com.ccl.exp.mvptest.constant.AppConstant;
import com.ccl.exp.mvptest.model.LoginModel;
import com.ccl.exp.mvptest.net.params.PostParams;
import com.ccl.exp.mvptest.net.response.BaseResponse;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ccl on 2017/11/4.
 */

public interface UserLogin {
    String BASE_URL = AppConstant.APPHOMEURL;

    @POST("login")
    Flowable<BaseResponse<LoginModel>> userLogin(@Body PostParams loginjson);
}
