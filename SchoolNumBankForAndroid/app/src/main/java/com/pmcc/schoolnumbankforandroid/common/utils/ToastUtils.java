package com.pmcc.schoolnumbankforandroid.common.utils;
import android.widget.Toast;
import com.pmcc.schoolnumbankforandroid.common.base.MyApp;


/**
 * 动态toast
 */
public class ToastUtils {
    private static Toast toast;

    /**
     * 提示，用全局context
     * @param text
     */
    public static void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(MyApp.getInstance(), text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);
      //  toast.setGravity(Gravity.BOTTOM, 0, UIUtils.getDimention(R.dimen.dp_toast_bottom));
        toast.show();
    }

}
