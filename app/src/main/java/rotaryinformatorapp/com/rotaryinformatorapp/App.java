package rotaryinformatorapp.com.rotaryinformatorapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rotaryinformatorapp.com.rotaryinformatorapp.model.Category;
import rotaryinformatorapp.com.rotaryinformatorapp.model.SubCategory;

/**
 * Created by Vladimir on 5/5/2016.
 */
public class App extends Application {

    public static List<Category> categories = Collections.emptyList();

    @Override
    public void onCreate() {
        super.onCreate();
        createCategories();
    }

    private void createCategories() {
        categories = new ArrayList<>(8);
        /**
         *mvr
         */
        Category category1 = new Category(1, getString(R.string.category_mvr), R.drawable.ic_description_black_36dp);
        category1.addSubCategory(new SubCategory(1, getString(R.string.sub_category_sud_1), 777));
        category1.addSubCategory(new SubCategory(2, getString(R.string.sub_category_sud_2), 778));
        categories.add(category1);

        /**
         *sud
         */
        Category category2 = new Category(2, getString(R.string.category_sud), R.drawable.ic_description_black_36dp);
        category2.addSubCategory(new SubCategory(1, getString(R.string.sub_category_sud_1), 777));
        category2.addSubCategory(new SubCategory(2, getString(R.string.sub_category_sud_2), 778));
        categories.add(category2);

        /**
         *sud
         */
        Category category3 = new Category(3, getString(R.string.category_katastar), R.drawable.ic_description_black_36dp);
        category3.addSubCategory(new SubCategory(1, getString(R.string.sub_category_sud_1), 777));
        category3.addSubCategory(new SubCategory(2, getString(R.string.sub_category_sud_2), 778));
        categories.add(category3);

        /**
         *sud
         */
        Category category4 = new Category(4, getString(R.string.category_ujp), R.drawable.ic_description_black_36dp);
        category4.addSubCategory(new SubCategory(1, getString(R.string.sub_category_sud_1), 777));
        category4.addSubCategory(new SubCategory(2, getString(R.string.sub_category_sud_2), 778));
        categories.add(category4);
    }

}
