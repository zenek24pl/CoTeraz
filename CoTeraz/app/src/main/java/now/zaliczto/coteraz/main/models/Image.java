package now.zaliczto.coteraz.main.models;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeno on 2017-01-20.
 */

public class Image {
    @PrimaryKey
    @Column
    @SerializedName("id")
    public int id;
    @Column
    @SerializedName("name")
    public String name;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public List<Image> getLoadDataImg() {
        return loadDataImg;
    }

    public void setLoadDataImg(List<Image> loadDataImg) {
        this.loadDataImg = loadDataImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    @SerializedName("src")
    public String src;

    List<Image> loadDataImg = new ArrayList<Image>();
}
