package rotaryinformatorapp.com.rotaryinformatorapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rotaryinformatorapp.com.rotaryinformatorapp.model.Category;

/**
 * Created by Vladimir on 5/5/2016.
 */
public class App extends Application {

    public static List<Category> categories = Collections.emptyList();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    static {
        categories = new ArrayList<>(8);
        categories.add(new Category("UJP", R.drawable.ic_description_black_36dp));
        categories.add(new Category("MVR", R.drawable.ic_description_black_36dp));
        categories.add(new Category("SUD", R.drawable.ic_description_black_36dp));
        categories.add(new Category("KATASTAR", R.drawable.ic_description_black_36dp));
    }

}
