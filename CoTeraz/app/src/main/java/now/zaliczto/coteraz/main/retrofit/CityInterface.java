package now.zaliczto.coteraz.main.retrofit;

import java.util.List;

import now.zaliczto.coteraz.main.models.Image;
import now.zaliczto.coteraz.main.models.News;
import now.zaliczto.coteraz.main.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import now.zaliczto.coteraz.main.models.Newses;
import retrofit2.http.Path;

/**
 * Created by zeno on 2016-12-20.
 */

public interface CityInterface {


    @GET("/CoTerazApp/mvc/nuda")
    Call<List<News>> loadDatanuda();

    @GET("/CoTerazApp/mvc/zakupy")
    Call<List<News>> loadDatazakupy();

    @GET("/CoTerazApp/mvc/zmeczenie")
    Call<List<News>> loadDatazmeczenie();

    @GET("/CoTerazApp/mvc/glod")
    Call<List<News>> loadDataglod();

    @GET("/CoTerazApp/mvc/repair")
    Call<List<News>> loadDatanaprawa();

    @GET("/CoTerazApp/mvc/money")
    Call<List<News>> loadDatapieniadze();

    @GET("/CoTerazApp/mvc/images")
    Call<List<Image>> loadDataImg();

    @GET("/CoTerazApp/mvc/user/{login}/{password}")
    Call<List<User>> getl(@Path("login") String login,
                     @Path("password") String password);

    @POST("/CoTerazApp/mvc/user/{login}/{password}")
    Call<User> login(@Path("login") String login,
                     @Path("password") String password);

    @POST("/CoTerazApp/mvc/user/add/{login}/{password}")
    Call<User> register(@Path("login") String login,
                     @Path("password") String password);

    @POST("/CoTerazApp/mvc/changeRating/{id}/{newRating}")
    Call<List<News>> rating(@Path("id") int id,
                        @Path("newRating") int rating);
    @POST("/CoTerazApp/mvc/user/changeType/{id}/{type}")
    Call<User> addpermium(@Path("id") int id,
                        @Path("type") String type);

}
