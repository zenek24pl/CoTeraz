package to.zalicz.coteraz.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import to.zalicz.coteraz.main.models.News;

/**
 * Created by zeno on 2016-12-21.
 */

public class Newses extends BaseAnswer {
    @SerializedName("")
    @Expose
    List<News> loadData=new ArrayList<News>();

    public List<News> getLoadData() {
        return loadData;
    }
}
