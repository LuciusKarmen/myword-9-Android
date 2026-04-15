package com.example.myapplication.utils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;


public class Result {

    private static final String TAG = "Result";
    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

    private static final Gson gson = new Gson();


    public static <T> void get(String url, final Type dataType, final HttpCallback<T> callback) {
        Log.d(TAG, "GET 请求: " + url);
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "请求失败", e);
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    if (!response.isSuccessful()) {
                        callback.onHttpError(response.code());
                        return;
                    }

                    String json = response.body().string();
                    Log.d(TAG, "响应: " + json);


                    Type resultType = new TypeToken<Result<T>>() {}.getType();
                    Result<T> result = gson.fromJson(json, resultType);

                    if (result.getCode() == 200) {
                        callback.onSuccess(result.getData());
                    } else {
                        callback.onError(result.getCode(), result.getMessage());
                    }
                } catch (Exception e) {
                    Log.e(TAG, "解析失败", e);
                    callback.onParseError(e);
                } finally {
                    response.close();
                }
            }
        });
    }

    public interface HttpCallback<T> {
        void onSuccess(T data);
        void onFailure(IOException e);
        void onHttpError(int httpCode);
        void onError(int code, String message);      // 业务错误（如 code != 200）
        void onParseError(Exception e);             // JSON 解析失败
    }
}