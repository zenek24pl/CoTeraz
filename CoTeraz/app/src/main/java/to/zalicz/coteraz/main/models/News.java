package to.zalicz.coteraz.main.models;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.parceler.Parcel;

import to.zalicz.coteraz.main.database.MyDatabase;

/**
 * Created by zeno on 2016-12-20.
 */
@Parcel
@Table(database = MyDatabase.class)

public class News extends BaseModel{
    @PrimaryKey
    @Column
    @SerializedName("id")
    int id;

    @Column
    @SerializedName("content")
    String content;

    @Override
    public String toString() {
        return id  + content ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
