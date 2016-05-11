package rotaryinformatorapp.com.rotaryinformatorapp;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rotaryinformatorapp.com.rotaryinformatorapp.model.Category;
import rotaryinformatorapp.com.rotaryinformatorapp.model.SubCategory;

/**
 * Created by Vladimir on 5/5/2016.
 */
public class App extends Application {

    private static List<Category> categories = Collections.emptyList();
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        createCategories();
        context = getApplicationContext();
    }

    /**
     * get application context
     *
     * @return
     */
    public static Context getContext() {
        return context;
    }

    /**
     * get categories
     *
     * @return
     */
    public static List<Category> getCategories() {
        return categories;
    }

    private void createCategories() {
        categories = new ArrayList<>(8);
        /**
         *mvr
         */
        Category category1 = new Category(1, getString(R.string.category_mvr), R.drawable.ic_description_black_36dp);
        category1.addSubCategory(new SubCategory(1, getString(R.string.sub_category_mvr_1), "test.pdf"));
        category1.addSubCategory(new SubCategory(2, getString(R.string.sub_category_mvr_2), "acro7_pg_ue.pdf"));
        category1.addSubCategory(new SubCategory(2, getString(R.string.sub_category_mvr_2), "acro7_pg_ue.pdf"));
        categories.add(category1);

        /**
         *sud
         */
        Category category2 = new Category(2, getString(R.string.category_sud), R.drawable.ic_description_black_36dp);
        category2.addSubCategory(new SubCategory(1, getString(R.string.sub_category_sud_1), "test.pdf"));
        category2.addSubCategory(new SubCategory(2, getString(R.string.sub_category_sud_2), "acro7_pg_ue.pdf"));
        categories.add(category2);

        /**
         *sud
         */
        Category category3 = new Category(3, getString(R.string.category_katastar), R.drawable.ic_description_black_36dp);
        category3.addSubCategory(new SubCategory(1, getString(R.string.sub_category_katastar_1), "acro7_pg_ue.pdf"));
        category3.addSubCategory(new SubCategory(2, getString(R.string.sub_category_katastar_2), "acro7_pg_ue.pdf"));
        category3.addSubCategory(new SubCategory(2, getString(R.string.sub_category_katastar_3), "acro7_pg_ue.pdf"));
        categories.add(category3);

        /**
         *sud
         */
        Category category4 = new Category(4, getString(R.string.category_ujp), R.drawable.ic_description_black_36dp);
        category4.addSubCategory(new SubCategory(1, getString(R.string.sub_category_sud_1), ""));
        category4.addSubCategory(new SubCategory(2, getString(R.string.sub_category_sud_2), ""));
        categories.add(category4);
    }

}
