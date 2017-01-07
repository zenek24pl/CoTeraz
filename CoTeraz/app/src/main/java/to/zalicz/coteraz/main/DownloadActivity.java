package to.zalicz.coteraz.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import to.zalicz.coteraz.R;
import to.zalicz.coteraz.main.fragments.MapDetailsFragment;
import to.zalicz.coteraz.main.models.News;
import to.zalicz.coteraz.main.models.Newses;
import to.zalicz.coteraz.main.retrofit.Rest;

import static to.zalicz.coteraz.main.addons.Tools.showErrorToast;


public class DownloadActivity extends Fragment {


private static News news;
private List<News> pobrane;
    String pob;
    ArrayAdapter<News> arrayAdapter;
    TextView test;

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


        News newdb=new News();
        newdb.save();
        return  DbView;
    }

    public void loadData(){
        Rest.getCityService().loadData().enqueue(new Callback<Newses>() {
            @Override
            public void onResponse(Call<Newses> call, Response<Newses> response) {
               pobrane= new ArrayList<News>();
// tu sie cale body pobiera wsio z newsow
               pobrane=response.body().getLoadData();
                test.setText(pobrane.get(0).toString());
          //      if(news.())
              //  {                Toast.makeText(getActivity(),"pusyo", Toast.LENGTH_SHORT).show();

               // }

                Toast.makeText(getActivity(),"succes", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Newses> call, Throwable t) {
            showErrorToast();
                Toast.makeText(getContext(),"SSS", Toast.LENGTH_SHORT).show();;

            }
        });
    }



}
