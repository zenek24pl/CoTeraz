package to.zalicz.coteraz.main.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import to.zalicz.coteraz.R;
import to.zalicz.coteraz.main.onFragmentClick;

/**
 * Created by zeno on 2016-12-09.
 */

public class MainWindowFragment extends Fragment implements onFragmentClick {

    View view;
    onFragmentClick mapListener;

    public static MainWindowFragment newInstance() {

        Bundle args = new Bundle();

        MainWindowFragment fragment = new MainWindowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
view=inflater.inflate(R.layout.mainwindow,container,false);
        ImageButton imWhat=(ImageButton)view.findViewById(R.id.imMain);

        imWhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapListener.navigatetoMap();
            }
        });
     return view;

    }
}
