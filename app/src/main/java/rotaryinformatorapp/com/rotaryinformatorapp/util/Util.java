package rotaryinformatorapp.com.rotaryinformatorapp.util;

import android.content.Context;
import android.content.res.Configuration;

import rotaryinformatorapp.com.rotaryinformatorapp.R;

/**
 * Created by Vladimir on 5/5/2016.
 */
public class Util {

    public static int calculateNumberOfCategoryColums(Context context) {
        boolean isTablet = context.getResources().getBoolean(R.bool.isTablet);
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (isTablet) {
                return 3;
            } else {
                return 2;
            }
        } else {
            if (isTablet) {
                return 4;
            } else {
                return 2;
            }
        }
    }
}
