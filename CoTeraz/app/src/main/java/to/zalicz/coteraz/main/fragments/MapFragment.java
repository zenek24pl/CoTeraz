package to.zalicz.coteraz.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by zeno on 2016-12-09.
 */

public class MapFragment extends Fragment {


    public static MapFragment newInstance() {

        Bundle args = new Bundle();

        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
