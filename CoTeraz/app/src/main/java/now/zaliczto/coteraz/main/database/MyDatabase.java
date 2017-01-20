package now.zaliczto.coteraz.main.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by zeno on 2016-12-23.
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)

public class MyDatabase {
    public static final String NAME = "NewsDatabase";

    public static final int VERSION = 1;
}
