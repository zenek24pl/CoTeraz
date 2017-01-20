package now.zaliczto.coteraz.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeno on 2016-12-21.
 */

public class Newses extends BaseAnswer {
    @SerializedName("")
    @Expose
    List<News> loadDataglod = new ArrayList<News>();
    List<News> loadDatanuda = new ArrayList<News>();
    List<News> loadDatazakupy = new ArrayList<News>();
    List<News> loadDatazmeczenie = new ArrayList<News>();

    public List<News> getLoadDataglod() {
        return loadDataglod;
    }

    public void setLoadDataglod(List<News> loadDataglod) {
        this.loadDataglod = loadDataglod;
    }

    public List<News> getLoadDatanuda() {
        return loadDatanuda;
    }

    public void setLoadDatanuda(List<News> loadDatanuda) {
        this.loadDatanuda = loadDatanuda;
    }

    public List<News> getLoadDatazakupy() {
        return loadDatazakupy;
    }

    public void setLoadDatazakupy(List<News> loadDatazakupy) {
        this.loadDatazakupy = loadDatazakupy;
    }

    public List<News> getLoadDatazmeczenie() {
        return loadDatazmeczenie;
    }

    public void setLoadDatazmeczenie(List<News> loadDatazmeczenie) {
        this.loadDatazmeczenie = loadDatazmeczenie;
    }


}
