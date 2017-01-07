package to.zalicz.coteraz.main.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import to.zalicz.coteraz.R;

/**
 * Created by zeno on 2016-12-09.
 */

public class MapDetailsFragment extends Fragment {


    EditText editName,editSurname,editMarks ,editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;

    Button btnviewUpdate;


    public static MapDetailsFragment newInstance() {
        Bundle args = new Bundle();
        MapDetailsFragment fragment = new MapDetailsFragment();


        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View DbView=inflater.inflate(R.layout.map_details,container,false);
        editName = (EditText)DbView.findViewById(R.id.editText_name);
        editSurname = (EditText)DbView.findViewById(R.id.editText_surname);
        editMarks = (EditText)DbView.findViewById(R.id.editText_Marks);
        editTextId = (EditText)DbView.findViewById(R.id.editText_id);
        btnAddData = (Button)DbView.findViewById(R.id.button_add);
        btnviewAll = (Button)DbView.findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)DbView.findViewById(R.id.button_update);
        btnDelete= (Button)DbView.findViewById(R.id.button_delete);

        return DbView;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the filter; this adds items to the action bar if it is present.
               inflater.inflate(R.menu.filterr,menu);
        super.onCreateOptionsMenu(menu,inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
     //       return true;
     //   }

        return super.onOptionsItemSelected(item);
    }
}
