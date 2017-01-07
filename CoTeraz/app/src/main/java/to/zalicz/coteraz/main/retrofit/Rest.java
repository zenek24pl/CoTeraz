package to.zalicz.coteraz.main.retrofit;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import to.zalicz.coteraz.main.retrofit.CityInterface;
import to.zalicz.coteraz.main.retrofit.RequestInterceptor;

/**
 * Created by zeno on 2016-12-21.
 */

public class Rest {

    public static final String SERVER="http://192.168.0.3:8080/greeting/";
    private static Gson gson;
    private static OkHttpClient okHttpClient;
    private static CityInterface cityService;

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static Gson getGson() {
        return gson;
    }

    public static CityInterface getCityService() {
        return cityService;
    }

    public static void init(){
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new RequestInterceptor())
                .addInterceptor(loggingInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        cityService=retrofit.create(CityInterface.class);

        gson=new Gson();
    }
}
