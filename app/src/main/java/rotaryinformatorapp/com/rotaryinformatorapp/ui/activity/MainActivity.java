package rotaryinformatorapp.com.rotaryinformatorapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import rotaryinformatorapp.com.rotaryinformatorapp.App;
import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.adapter.CategoriesRecyclerViewAdapter;
import rotaryinformatorapp.com.rotaryinformatorapp.util.Util;

/**
 * Created by Vladimir on 5/4/2016.
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setCategoriesAdapter();
    }

    private void initView() {
        categories = (RecyclerView) findViewById(R.id.categories);
        int numberOfColumns = Util.calculateNumberOfCategoryColums(getApplicationContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, numberOfColumns);
        categories.setLayoutManager(gridLayoutManager);
    }

    private void setCategoriesAdapter() {
        categories.setAdapter(new CategoriesRecyclerViewAdapter(getApplicationContext(), App.categories));
    }
}