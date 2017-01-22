package now.zaliczto.coteraz.main.models;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeno on 2016-12-20.
 */
@Parcel

public class News extends BaseModel implements Parcelable{
    @PrimaryKey
    @Column
    @SerializedName("id")
    public int id;

    @Column
    @SerializedName("name")
    public String name;
    @Column
    @SerializedName("info")
    public String info;

    @Column
    @SerializedName("marker_icon")
    public String m_icon;

    @Column
    @SerializedName("lat")
    public    double lat;
    @Column
    @SerializedName("lng")
    public double lng;
    @Column
    @SerializedName("rating")
    public int rating;


    @Column
    @SerializedName("www")
    public String www;

    @Column
    @SerializedName("adress")
    public String adres;

    @Column
    @SerializedName("phone")
    public String phone;
    @Column
    @SerializedName("type")
    public String type;
    @Column
    @SerializedName("placeImage")
    public String placeImg;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getM_icon() {
        return m_icon;
    }

    public void setM_icon(String m_icon) {
        this.m_icon = m_icon;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPlaceImg() {
        return placeImg;
    }

    public void setPlaceImg(String placeImg) {
        this.placeImg = placeImg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    List<News> loadDataglod = new ArrayList<News>();
    List<News> loadDatanuda = new ArrayList<News>();
    List<News> loadDatazakupy = new ArrayList<News>();
    List<News> loadDatanaprawa = new ArrayList<News>();
    List<News> loadDatapieniadze = new ArrayList<News>();
    List<News> loadDatazmeczenie = new ArrayList<News>();

    public List<News> getLoadDatanaprawa() {
        return loadDatanaprawa;
    }

    public void setLoadDatanaprawa(List<News> loadDatanaprawa) {
        this.loadDatanaprawa = loadDatanaprawa;
    }

    public List<News> getLoadDatapieniadze() {
        return loadDatapieniadze;
    }

    public void setLoadDatapieniadze(List<News> loadDatapieniadze) {
        this.loadDatapieniadze = loadDatapieniadze;
    }



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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.info);
        dest.writeString(this.m_icon);
        dest.writeDouble(this.lat);
        dest.writeDouble(this.lng);
        dest.writeInt(this.rating);
        dest.writeString(this.www);
        dest.writeString(this.adres);
        dest.writeString(this.phone);
        dest.writeString(this.type);
        dest.writeString(this.placeImg);
        dest.writeTypedList(this.loadDataglod);
        dest.writeTypedList(this.loadDatanuda);
        dest.writeTypedList(this.loadDatazakupy);
        dest.writeTypedList(this.loadDatazmeczenie);
    }

    public News() {
    }

    protected News(android.os.Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.info = in.readString();
        this.m_icon = in.readString();
        this.lat = in.readDouble();
        this.lng = in.readDouble();
        this.rating = in.readInt();
        this.www = in.readString();
        this.adres = in.readString();
        this.phone = in.readString();
        this.type = in.readString();
        this.placeImg = in.readString();
        this.loadDataglod = in.createTypedArrayList(News.CREATOR);
        this.loadDatanuda = in.createTypedArrayList(News.CREATOR);
        this.loadDatazakupy = in.createTypedArrayList(News.CREATOR);
        this.loadDatazmeczenie = in.createTypedArrayList(News.CREATOR);
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(android.os.Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
