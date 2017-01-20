package now.zaliczto.coteraz.main.dialoged;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import now.zaliczto.coteraz.R;
import now.zaliczto.coteraz.main.activity.PaypalBuy;
import now.zaliczto.coteraz.main.onFragmentClick;

/**
 * Created by zeno on 2017-01-12.
 */

public class NaviDialog extends DialogFragment implements View.OnClickListener{
    private Button dialognaviButton;
    private Button dialogCloseButton;
    onFragmentClick buylistener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_d,container,
                false);
        findViews(rootView);
        setListeners();
        return rootView;
    }

    private void findViews(View rootView) {

        dialognaviButton = (Button) rootView.findViewById(R.id.buy_bt);
        dialogCloseButton = (Button) rootView.findViewById(R.id.close_bt);


    }

    private void setListeners() {
        dialognaviButton.setOnClickListener(this);
        dialogCloseButton.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        final Window dialogWindow = getDialog().getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = -300;
        dialogWindow.setAttributes(lp);
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buy_bt:
                Intent i = new Intent(getActivity(), PaypalBuy.class);
                startActivity(i);
                break;
            case R.id.close_bt:
                getDialog().dismiss();
                break;
        }
    }
}
