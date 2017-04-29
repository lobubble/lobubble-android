package net.jspiner.lobbuble;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class Util {

    private static HttpService httpService;

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
                            .build()
                            .create(HttpService.class);

        }

        return httpService;
    }
}
