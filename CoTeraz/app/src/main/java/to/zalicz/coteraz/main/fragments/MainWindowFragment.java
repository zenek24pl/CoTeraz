package to.zalicz.coteraz.main.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import to.zalicz.coteraz.R;
import to.zalicz.coteraz.main.onFragmentClick;

/**
 * Created by zeno on 2016-12-09.
 */

public class MainWindowFragment extends Fragment implements View.OnClickListener {

    View view;
    boolean bored=false;
    boolean tired=false;
    boolean eat=false;
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
        final Button btEat=(Button)view.findViewById(R.id.btEat);
        final Button btBored=(Button)view.findViewById(R.id.btBoredd);
        final Button btTired=(Button)view.findViewById(R.id.btTired);


        btBored.setOnClickListener(this);

        btEat.setOnClickListener(this);
        btTired.setOnClickListener(this);

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
            case R.id.btBoredd:
                Toast.makeText(getActivity(), "bored", Toast.LENGTH_SHORT).show();
                bored=true;
                break;
            case R.id.btEat:
                Toast.makeText(getActivity(), "eat", Toast.LENGTH_SHORT).show();
                eat=true;
                break;
            case R.id.btTired:
                tired=true;
                Toast.makeText(getActivity(), "tired", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imMain:
               // if(eat&&bored){
                    mapListener.navigatetoMap();
              //  }
              //  else if(eat){
               //     mapListener.navigatetoMarkerDetails();
              //  }
              //  else if(tired){
               //     mapListener.navigatetoMap();
               // }
                break;
    }}
}
