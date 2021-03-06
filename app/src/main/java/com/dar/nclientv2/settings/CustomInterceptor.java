package com.dar.nclientv2.settings;

import com.dar.nclientv2.utility.LogUtility;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CustomInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request();
        LogUtility.d("Requested url: "+request.url());
        Request.Builder r=request.newBuilder();
        r.addHeader("User-Agent",Global.getUserAgent());

        return chain.proceed(r.build());
    }
}
