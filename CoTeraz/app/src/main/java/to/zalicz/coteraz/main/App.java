package to.zalicz.coteraz.main;

import android.app.Application;
import android.content.Context;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import to.zalicz.coteraz.main.retrofit.Rest;

/**
 * Created by zeno on 2016-12-21.
 */

public class App extends Application {


    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext=this;
        Rest.init();
        FlowManager.init(new FlowConfig.Builder(this).build());

    }
    public static Context getAppContext() {
        return appContext;
    }
}
