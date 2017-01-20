package now.zaliczto.coteraz.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import now.zaliczto.coteraz.R;
import now.zaliczto.coteraz.main.fragments.LoginFragmen;
import now.zaliczto.coteraz.main.fragments.MapDetailsFragment;
import now.zaliczto.coteraz.main.fragments.MenuFragment;
import now.zaliczto.coteraz.main.models.User;
import now.zaliczto.coteraz.main.onFragmentClick;
import now.zaliczto.coteraz.main.retrofit.Rest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static now.zaliczto.coteraz.main.fragments.LoginFragmen.czyprem;
import static now.zaliczto.coteraz.main.fragments.LoginFragmen.logg;
import static now.zaliczto.coteraz.main.fragments.LoginFragmen.pass;

/**
 * Created by zeno on 2017-01-19.
 */

public class ConfirmationActivity extends AppCompatActivity implements View.OnClickListener,onFragmentClick{
    public static int uwaga;
    onFragmentClick mapListener;
    List<User> pobrane;
    String type;
    int id;
    String czy_pyklo;
    LoginFragmen newfrag=new LoginFragmen();
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_layout);

        //Getting Intent
        Intent intent = getIntent();
        loadDatauser();



        try {
            JSONObject jsonDetails = new JSONObject(intent.getStringExtra("PaymentDetails"));

            //Displaying payment details
            showDetails(jsonDetails.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));
        } catch (JSONException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void showDetails(JSONObject jsonDetails, String paymentAmount) throws JSONException {
        //Views
        TextView textViewId = (TextView) findViewById(R.id.paymentId);
        TextView textViewStatus= (TextView) findViewById(R.id.paymentStatus);
        TextView textViewAmount = (TextView) findViewById(R.id.paymentAmount);
        Button goBack=(Button)findViewById(R.id.goBack);
        goBack.setOnClickListener(this);
        //Showing the details from json object
        textViewId.setText(jsonDetails.getString("id"));
        textViewStatus.setText(jsonDetails.getString("state"));
        textViewAmount.setText(paymentAmount+" USD");


    }

    public void loadDatauser(){

        Rest.getCityService().getl(logg,pass).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                pobrane = new ArrayList<User>();

                pobrane =response.body();
                for(User it:pobrane)
                {
                    id=it.id;

                    type="premium";
                    czyprem=true;
                }
                addpremiumm();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                //  showErrorToast();
                //  Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });
    }


    public void addpremiumm(){
        Call<User> cos2= Rest.getCityService().addpermium(id,type);
        cos2.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                pobrane = new ArrayList<User>();
                czy_pyklo=response.body().response;



            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //  showErrorToast();
                //  Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imbored:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.loginid, LoginFragmen.newInstance());
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
                break;
        }
    }


    @Override
    public void navigatetoMap() {
        FragmentManager fragmentManager = getSupportFragmentManager();


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.activity_root, now.zaliczto.coteraz.main.fragments.MapFragment.newInstance());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void navigatetoMarkerDetails(Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.confirm_root, MapDetailsFragment.newInstance(bundle));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void navigatetoMain() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.confirm_root, MenuFragment.newInstance());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    @Override
    public void navigatetoDownload() {

    }

    @Override
    public void navigatetoLogin() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.confirm_root, LoginFragmen.newInstance());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
