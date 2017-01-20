package now.zaliczto.coteraz.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zeno on 2016-12-21.
 */

public class NewsAnswer extends BaseAnswer{

    @SerializedName("")
    @Expose
    private News news;

    public News getNews(){
        return news;
    }
}
