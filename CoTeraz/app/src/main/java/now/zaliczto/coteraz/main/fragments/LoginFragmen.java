package now.zaliczto.coteraz.main.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import now.zaliczto.coteraz.R;
import now.zaliczto.coteraz.main.OnActivityInteraction;
import now.zaliczto.coteraz.main.models.User;
import now.zaliczto.coteraz.main.onFragmentClick;
import now.zaliczto.coteraz.main.retrofit.CityInterface;
import now.zaliczto.coteraz.main.retrofit.Rest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static now.zaliczto.coteraz.main.addons.Tools.showErrorToast;

/**
 * Created by zeno on 2017-01-19.
 */

public class LoginFragmen extends Fragment implements View.OnClickListener{
    OnActivityInteraction activityInteraction;

    Button register;
    Button login;
    EditText etLogin;
    EditText etPassword;
    List<User> pobrane;
    User user;
    public static String  logg;
    public static String pass;
    String czy_pyklo;
    String jajca;
    onFragmentClick maplistener;
    public static boolean czyprem=false;
    public static LoginFragmen newInstance() {


        LoginFragmen fragment = new LoginFragmen();

        Bundle args=new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View DbView = inflater.inflate(R.layout.login, container, false);
        etLogin = (EditText) DbView.findViewById(R.id.etLogin);

        etPassword = (EditText) DbView.findViewById(R.id.etPassword);
        login = (Button) DbView.findViewById(R.id.btLogin);
        register = (Button) DbView.findViewById(R.id.btRegister);


        login.setOnClickListener(this);
        register.setOnClickListener(this);
        loadDatausers();
        return DbView;
    }
    public OnActivityInteraction getActions() {

        if (activityInteraction == null) {
            Log.d("BaseFragment", String.format("Fragment %s accessing activity interaction when detached. Returning null", this.getClass().getSimpleName()));
        }
        return activityInteraction;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btRegister:
                logg=etLogin.getText().toString();
                pass=etPassword.getText().toString();
                Call<User> cos= Rest.getCityService().register(logg,pass);
                cos.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        czy_pyklo=response.body().response;
                        Toast.makeText(getActivity(),czy_pyklo,Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(),"Zarejestrowany ,teraz mozesz sie zalogowac ",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getActivity(),"Nie udało się zapraszamy za rok",Toast.LENGTH_SHORT).show();

                    }
                });
                break;
            case R.id.btLogin:
                pass = String.valueOf(etPassword.getText());
                logg = String.valueOf(etLogin.getText());

                Call<User> cos1= Rest.getCityService().login(logg,pass);
                cos1.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        czy_pyklo=response.body().response;
                        Toast.makeText(getActivity(),czy_pyklo,Toast.LENGTH_SHORT).show();
                        if(czy_pyklo.equals("Succes")) {
                            Toast.makeText(getActivity(), "Logowanie", Toast.LENGTH_LONG).show();
                            if (response.isSuccessful()) {
                            AsyncTask task=new BitmapAsync(){}.execute();
                             //   loadDatausers();
                                //String usus = user.type;


                               // if(jajca.equals("premium"))
                              //      czyprem = true;

                            //   maplistener.navigatetoMain();

                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getActivity(),"Nie udało się zapraszamy za rok",Toast.LENGTH_SHORT).show();

                    }
                });


                break;
        }
    }
    public class BitmapAsync extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Pobieranie danych w toku...");
            progressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            loadDatausers();
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            progressDialog.dismiss();

        }
    }
    public void loadDatausers(){

        if (getActions() != null) {
            getActions().showProgressBar();
        }
        Rest.getCityService().getl(logg,pass).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                pobrane = new ArrayList<User>();

                pobrane =response.body();
                for(User it:pobrane)
                {
                    if(it.type.equals("premium"))
                        czyprem = true;
                    maplistener.navigatetoMain();

                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
              //  showErrorToast();
              //  Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onFragmentClick) {
            maplistener = (onFragmentClick) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnActivityClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        maplistener = null;
    }
}
