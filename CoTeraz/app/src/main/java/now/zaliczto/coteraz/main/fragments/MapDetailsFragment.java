package now.zaliczto.coteraz.main.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import now.zaliczto.coteraz.R;
import now.zaliczto.coteraz.main.models.Image;
import now.zaliczto.coteraz.main.models.News;
import now.zaliczto.coteraz.main.models.User;
import now.zaliczto.coteraz.main.retrofit.Rest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zeno on 2016-12-09.
 */

public class MapDetailsFragment extends Fragment {

    News news;
    List<News> pobrane;
    private ImageView bigim;
    private TextView name;
    private TextView info;
    private TextView adres;
    private TextView tel;
    private TextView strona;
    private RatingBar ratingBar;
    private Button result;
    private Button grade;

    public static MapDetailsFragment newInstance(Bundle bundle) {


        MapDetailsFragment fragment = new MapDetailsFragment();


        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            news = bundle.getParcelable("News");

        }
        View DbView = inflater.inflate(R.layout.map_details, container, false);
        bigim = (ImageView) DbView.findViewById(R.id.bigIm);
        result = (Button) DbView.findViewById(R.id.plusGrade);
        grade = (Button) DbView.findViewById(R.id.minusGrade);
        ratingBar = (RatingBar) DbView.findViewById(R.id.return_dialog_customRating);
        name = (TextView) DbView.findViewById(R.id.enterameTv);
        info = (TextView) DbView.findViewById(R.id.enterinfoTv);
        adres = (TextView) DbView.findViewById(R.id.enteradresTv);
        tel = (TextView) DbView.findViewById(R.id.entertelefonTv);
        strona = (TextView) DbView.findViewById(R.id.enterstronaTv);
        Picasso.with(getActivity().getApplicationContext())
                .load(news.placeImg)
                .into(bigim);
        //  bigim.setImageBitmap(news.getZdjecie().);
        name.setText(news.getName());
        info.setText(news.getInfo());
        info.setMovementMethod(new ScrollingMovementMethod());
        adres.setText(news.getAdres());
        tel.setText(news.getPhone());
        strona.setText(news.getWww());
        strona.setMovementMethod(new ScrollingMovementMethod());
        addListenerOnRatingBar();
        addListenerOnButton();


        return DbView;

    }

    private void addListenerOnButton() {
        grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                news.setRating((int) ratingBar.getRating());

            }
        });
    }

    private void addListenerOnRatingBar() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                result.setText("Ocena: " + (String.valueOf(v)));
                final Call<List<News>> cos1 = Rest.getCityService().rating(news.id, (int)v);
                cos1.enqueue(new Callback<List<News>>() {
                    @Override
                    public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                        pobrane = new ArrayList<News>();

                        pobrane =response.body();
                    }

                    @Override
                    public void onFailure(Call<List<News>> call, Throwable t) {

                    }
                });}});}





            @Override
        public void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
        }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
