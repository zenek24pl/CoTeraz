package now.zaliczto.coteraz.main.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import now.zaliczto.coteraz.R;
import now.zaliczto.coteraz.main.onFragmentClick;

/**
 * Created by zeno on 2016-12-09.
 */

public class MainWindowFragment extends Fragment implements View.OnClickListener {

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


        imWhat.setOnClickListener(this);




     return view;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onFragmentClick) {
            mapListener = (onFragmentClick) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnActivityClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mapListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){


            case R.id.imMain:
              //
            mapListener.navigatetoMain();
                break;
    }}
}
