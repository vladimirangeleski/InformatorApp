package rotaryinformatorapp.com.rotaryinformatorapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceManager {

    public static final String PREFERENCES = "rotary.informatorapp.shared.preferences";

    private static PreferenceManager preferenceManager;
    private SharedPreferences sharedPreferences;
    private Editor preferenceEditor;
    Context context;

    public static PreferenceManager getInstance(Context context) {
        if (null == preferenceManager) {
            preferenceManager = new PreferenceManager(context);
        }
        return preferenceManager;
    }

    private PreferenceManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCES,
                Context.MODE_PRIVATE);
        preferenceEditor = sharedPreferences.edit();
    }

    /**
     * clear data from system preferences
     */
    public void clearData() {
        preferenceEditor.clear();
        preferenceEditor.commit();
    }

    public String getToken() {
        return sharedPreferences.getString("rotary.app.token", "");
    }

    public void setToken(String hush) {
        preferenceEditor.putString("rotary.app.token", hush);
        preferenceEditor.commit();
    }
}