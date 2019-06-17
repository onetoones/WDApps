package com.wd.tech.model.utlis;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofiterUtlis {
    private volatile static RetrofiterUtlis retrofiterUtlis;
    private final Retrofit retrofit;

    public RetrofiterUtlis() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClienUtlis.getClienUtlis().getClient())
                .build();
    }

    private RetrofiterUtlis getRetrofiterUtlis() {
        if (retrofiterUtlis == null) {
            synchronized (RetrofiterUtlis.class) {
                if (retrofiterUtlis == null) {
                    retrofiterUtlis = new RetrofiterUtlis();
                }
            }
        }
        return retrofiterUtlis;
    }
    public RetrfiterApi getAPI(){
        return retrofit.create(RetrfiterApi.class);
}

}
