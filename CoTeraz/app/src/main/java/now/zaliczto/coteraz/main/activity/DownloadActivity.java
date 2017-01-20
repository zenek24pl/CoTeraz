package now.zaliczto.coteraz.main.activity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import now.zaliczto.coteraz.R;
import now.zaliczto.coteraz.main.models.News;
import now.zaliczto.coteraz.main.retrofit.Rest;

import static now.zaliczto.coteraz.main.addons.Tools.showErrorToast;


public class DownloadActivity extends Fragment {


private static News news;
private List<News> pobrane;
    String pob;
    ArrayAdapter<News> arrayAdapter;
    TextView test;
    ImageView impic;

    public static DownloadActivity newInstance() {
        Bundle args = new Bundle();
        DownloadActivity fragment = new DownloadActivity();


        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View DbView=inflater.inflate(R.layout.activity_main,container,false);
        loadData();
        test=(TextView)DbView.findViewById(R.id.test);
        impic=(ImageView)DbView.findViewById(R.id.impic);


        News newdb=new News();
        newdb.save();
        return  DbView;
    }

    public void loadData(){
        Rest.getCityService().loadDataglod().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
               pobrane= new ArrayList<News>();
// tu sie cale body pobiera wsio z newsow
               pobrane=response.body();
                for (News c : pobrane) {
                    test.append("Name: " + c.getName()+ "\n" + "info: " + c.getInfo() + "\n"
                    +"lat "+c.getLat()+"\n"+ "lng "+c.getLng()+"\n"+ "www "+c.getWww());
                }
              //  test.setText(pobrane.get(0).getLoadDataglod().toString());
          //      if(news.())
              //  {                Toast.makeText(getActivity(),"pusyo", Toast.LENGTH_SHORT).show();

               // }

                Toast.makeText(getActivity(),"succes", Toast.LENGTH_SHORT).show();
             //   http://c.wrzuta.pl/wi5673/5d532e3b002a571e4d189f64
                Picasso.with(getActivity().getApplicationContext())
                        .load("http://x3.cdn03.imgwykop.pl/c3201142/comment_LhwU2c5Bbqvvgn1KJZUNpnvPqvOcwdNN,w400.jpg")
                        .into(impic);
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
            showErrorToast();
                Toast.makeText(getContext(),"SSS", Toast.LENGTH_SHORT).show();;

            }
        });
    }



}
