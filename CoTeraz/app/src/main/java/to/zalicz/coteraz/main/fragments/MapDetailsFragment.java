package to.zalicz.coteraz.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by zeno on 2016-12-09.
 */

public class MapDetailsFragment extends Fragment {




    public static MapDetailsFragment newInstance() {
        Bundle args = new Bundle();
        MapDetailsFragment fragment = new MapDetailsFragment();


        fragment.setArguments(args);
        return fragment;
    }
}
