package rotaryinformatorapp.com.rotaryinformatorapp.util;

import android.util.Log;

import rotaryinformatorapp.com.rotaryinformatorapp.BuildConfig;


/**
 * Created by cesaraguilar on 1/26/16.
 */
public class LogWrapper {

    public static void d(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.w(tag, message);
        }
    }

    public static void e(String tag, String message, Throwable e) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message, e);
        }
    }

}
