package now.zaliczto.coteraz.main.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import now.zaliczto.coteraz.R;

import now.zaliczto.coteraz.main.models.Image;
import now.zaliczto.coteraz.main.models.News;
import now.zaliczto.coteraz.main.onFragmentClick;
import now.zaliczto.coteraz.main.retrofit.Rest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static now.zaliczto.coteraz.main.addons.Tools.showErrorToast;

/**
 * Created by zeno on 2017-01-11.
 */

public class MenuFragment extends Fragment implements View.OnClickListener {
    View view;
    onFragmentClick mapListener;
    public static int choose;
    Image image;
    private ImageView imTired;
    private ImageView imBored;
    private ImageView imHungry;
    private ImageView imShop;
    private ImageView imRepair;
    private ImageView imMoney;
    List<Image> pobrane;



    public static MenuFragment newInstance() {

        Bundle args = new Bundle();

        MenuFragment fragment = new MenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.grid_menu, container, false);
        imBored=(ImageView)view.findViewById(R.id.imbored);
        imHungry=(ImageView)view.findViewById(R.id.hungryIv);
        imTired=(ImageView)view.findViewById(R.id.tiredIv);
        imShop=(ImageView)view.findViewById(R.id.shopIv);
        loadDataImg();
        imHungry.setOnClickListener(this);
        imTired.setOnClickListener(this);
        imBored.setOnClickListener(this);
        imShop.setOnClickListener(this);

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
    public void loadlod(){
        for(Image item:pobrane) {
            if(item.name.equals("Hungry")){
            Picasso.with(getActivity().getApplicationContext())
                    .load(item.src)
                    .into(imHungry);}
            if(item.name.equals("Shopping")) {

                Picasso.with(getActivity().getApplicationContext())
                        .load(item.src)
                        .into(imShop);
            }
            if(item.name.equals("Tired")){

                Picasso.with(getActivity().getApplicationContext())
                    .load(item.src)
                    .into(imTired);}
            if(item.name.equals("Bored")){

                Picasso.with(getActivity().getApplicationContext())
                    .load(item.src)
                    .into(imBored);}


    }}
    @Override
    public void onDetach() {
        super.onDetach();
        mapListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.imbored:
                choose=1;
                mapListener.navigatetoMap();
                break;
            case R.id.shopIv:
                choose=2;
                mapListener.navigatetoMap();
                break;
            case R.id.tiredIv:
                choose=3;
                mapListener.navigatetoMap();
                break;
            case R.id.hungryIv:
                choose=4;
                mapListener.navigatetoMap();
                break;

        }}

    public void loadDataImg(){


        Rest.getCityService().loadDataImg().enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                pobrane = new ArrayList<Image>();
                pobrane =response.body();
              //  AsyncTask dd=new BitmapAsync(){}.execute();
      //          loadlod();
                loadlod();
            }

            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {
                showErrorToast();
                Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });
    }
    public class BitmapAsync extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Pobieranie danych w toku...");
          //  progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            progressDialog.dismiss();

        }
    }
}
