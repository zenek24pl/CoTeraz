package to.zalicz.coteraz.main.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import to.zalicz.coteraz.main.models.Newses;

/**
 * Created by zeno on 2016-12-20.
 */

public interface CityInterface {


    @GET("/greeting")
    Call<Newses> loadData();

    @PUT("/greeting")
    @FormUrlEncoded
    Call<Newses> putData();

    @POST("/greeting")
    @FormUrlEncoded
    Call<Newses> searchData(@Field("id") int id);

    @POST("/greeting/create")
    @FormUrlEncoded
    Call<Newses> addData(@Field("id") int id,
                         @Field("name") String name);

}
