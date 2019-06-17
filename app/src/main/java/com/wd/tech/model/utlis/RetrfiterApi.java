package com.wd.tech.model.utlis;



import com.wd.tech.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrfiterApi {
    @POST(Api.REGISTER)
    @FormUrlEncoded
    Observable<MyBean> getRegisters(@Field("phone") String phone, @Field("pwd") String pwd);//注册

    @POST(Api.LOGIN)
    @FormUrlEncoded
    Observable<MyBean> getLogin(@Field("phone") String phone, @Field("pwd") String pwd);//登陆

}
