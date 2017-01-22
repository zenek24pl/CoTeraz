package now.zaliczto.coteraz.main.addons;

/**
 * Created by zeno on 2016-12-21.
 */


import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import now.zaliczto.coteraz.R;
import now.zaliczto.coteraz.main.App;


public class Tools {

    public static void showErrorToast() {
        Context context = App.getAppContext();
        Toast.makeText(context, context.getString(R.string.error_ocurred_during_payment), Toast.LENGTH_SHORT).show();
    }

    public static void showErrorConnectionToast() {
        Context context = App.getAppContext();
        Toast.makeText(context, context.getString(R.string.error_ocurred_during_payment), Toast.LENGTH_SHORT).show();
    }

    public static void setTextOrHideView(View rootView, String text, int textViewId) {
        TextView textText = (TextView) rootView.findViewById(textViewId);
        if (text != null && !text.equals("")) {
            textText.setText(text);
        } else {
            textText.setVisibility(View.GONE);
        }
    }

    public static boolean isNullOrEmpty(String text) {
        return text == null || "".equals(text);
    }

    public static void hideKeyboard(View view) {
        if (view != null) {
            try {
                InputMethodManager imm = (InputMethodManager) App.getAppContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            } catch (Exception ignored) { /* safely ignore, as ex in here means we could not hide keyboard */ }
        }
    }






}
