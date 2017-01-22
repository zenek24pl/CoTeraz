package now.zaliczto.coteraz.main.models;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;

import org.parceler.Parcel;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeno on 2017-01-19.
 */
@Parcel
public class User {
    @PrimaryKey
    @Column
    @SerializedName("id")
    public int id;

    @Column
    @SerializedName("response")
    public String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Column
    @SerializedName("login")
    public String login;
    @Column
    @SerializedName("password")
    public String password;
    @Column
    @SerializedName("type")
    public String type;


    List<User> loadDatausers = new ArrayList<User>();
    public List<User> getLoadDatausers() {
        return loadDatausers;
    }
    List<User> getl=new ArrayList<>();

    public void setLoadDatausers(List<User> loadDatausers) {
        this.loadDatausers = loadDatausers;
    }
}
