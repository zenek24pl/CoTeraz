package to.zalicz.coteraz.main.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import to.zalicz.coteraz.R;
import to.zalicz.coteraz.main.DownloadActivity;
import to.zalicz.coteraz.main.fragments.MainWindowFragment;
import to.zalicz.coteraz.main.fragments.MapDetailsFragment;
import to.zalicz.coteraz.main.fragments.MapFragment;
import to.zalicz.coteraz.main.onFragmentClick;

public class MainActivity extends AppCompatActivity implements onFragmentClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.add(R.id.activity_root, MainWindowFragment.newInstance());
        fragmentTransaction.commit();



    }

    @Override
    public void navigatetoMap() {


        FragmentManager fragmentManager = getSupportFragmentManager();


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.activity_root, MapFragment.newInstance());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void navigatetoMarkerDetails() {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.activity_root, MapDetailsFragment.newInstance());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
    @Override
    public void navigatetoDownload() {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.activity_root, DownloadActivity.newInstance());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
