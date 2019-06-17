package com.wd.tech.model.utlis;

import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClienUtlis {
    private volatile static OkHttpClienUtlis clienUtlis;
    private final OkHttpClient client;

    public OkHttpClienUtlis() {
        client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)//连接超时设置
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        if (message.startsWith("{") || message.startsWith("[")) {
                            Logger.t("===").json(message);
                        } else {
                            Logger.t("===").d(message);
                        }
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();


    }

    public static OkHttpClienUtlis getClienUtlis() {
        if (clienUtlis == null) {
            synchronized (OkHttpClienUtlis.class) {
                if (clienUtlis == null) {
                    clienUtlis = new OkHttpClienUtlis();

                }
            }
        }
        return clienUtlis;
    }

    public OkHttpClient getClient() {
        return client;

    }

}
