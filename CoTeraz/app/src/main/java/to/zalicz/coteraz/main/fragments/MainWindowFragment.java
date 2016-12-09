package to.zalicz.coteraz.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by zeno on 2016-12-09.
 */

public class MainWindowFragment extends Fragment {



    public static MainWindowFragment newInstance() {

        Bundle args = new Bundle();

        MainWindowFragment fragment = new MainWindowFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
