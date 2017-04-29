package net.jspiner.lobbuble;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class Util {

    private static HttpService httpService;


    private static Gson gsonObject;

    //gson
    public static Gson getGson(){
        if(gsonObject == null){

            gsonObject = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
        }

        return gsonObject;
    }

    public static synchronized HttpService getService() {
        if(httpService == null){

            OkHttpClient.Builder client = new OkHttpClient.Builder();
            client.connectTimeout(20, TimeUnit.SECONDS);
            client.readTimeout(20, TimeUnit.SECONDS);
            client.writeTimeout(20, TimeUnit.SECONDS);


            httpService =
                    new Retrofit.Builder()
                            .baseUrl("https://lobubble.azurewebsites.net/")
                            .client(client.build())
                            .addConverterFactory(GsonConverterFactory.create(getGson()))
                            .build()
                            .create(HttpService.class);

        }

        return httpService;
    }
}
