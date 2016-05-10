package rotaryinformatorapp.com.rotaryinformatorapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.ui.fragment.CategoryFragment;

/**
 * Created by Vladimir on 5/4/2016.
 */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCategoryFragment();
    }

    private void initCategoryFragment() {
        FragmentManager fm = getSupportFragmentManager();
        CategoryFragment fragment = new CategoryFragment();
        fm.beginTransaction().replace(R.id.container, fragment, CategoryFragment.TAG).commit();
    }
}