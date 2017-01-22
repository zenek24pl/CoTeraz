package now.zaliczto.coteraz.main.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import now.zaliczto.coteraz.R;
import now.zaliczto.coteraz.main.fragments.MainWindowFragment;
import now.zaliczto.coteraz.main.fragments.MapDetailsFragment;
import now.zaliczto.coteraz.main.fragments.MapFragment;
import now.zaliczto.coteraz.main.fragments.MenuFragment;
import now.zaliczto.coteraz.main.onFragmentClick;

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
    public void navigatetoMain() {


        FragmentManager fragmentManager = getSupportFragmentManager();


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.activity_root, MenuFragment.newInstance());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void navigatetoMarkerDetails(Bundle bundle) {



        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.activity_root, MapDetailsFragment.newInstance(bundle));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }












}
