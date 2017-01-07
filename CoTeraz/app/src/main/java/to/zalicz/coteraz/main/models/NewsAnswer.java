package to.zalicz.coteraz.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import to.zalicz.coteraz.main.models.News;

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
