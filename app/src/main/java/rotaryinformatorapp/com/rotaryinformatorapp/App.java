package rotaryinformatorapp.com.rotaryinformatorapp;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

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
        Fabric.with(this, new Crashlytics());
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
        initMVRCategory();

        /**
         *sud
         */
        initSUDCategory();

        /**
         *katastar
         */
        initKATASTARCategory();

        /**
         * UJP
         */
        //initUJPCategory();

        /**
         * MATICNO
         */
        initMATICNOCategory();

        /**
         * FZO
         */
        initFZOCategory();

        /**
         * PIOM
         */
        initPIOMCategory();

        /**
         * About rotary
         */
        initAboutRotaryCategory();
    }

    private void initSUDCategory() {
        Category category = new Category(1, getString(R.string.category_sud), R.drawable.sud_selector, R.color.sudStatusBar, R.color.sudActionBar);
        for (int i = 0; i < getResources().getTextArray(R.array.category_sud).length; i++) {
            category.addSubCategory(new SubCategory(i, getResources().getStringArray(R.array.category_sud)[i], getResources().getStringArray(R.array.documents_sud)[i], R.color.sudIndicator));

        }
        categories.add(category);
    }

    private void initMVRCategory() {
        Category category = new Category(1, getString(R.string.category_mvr), R.drawable.mvr_selector, R.color.mvrStatusBar, R.color.mvrActionBar);
        for (int i = 0; i < getResources().getTextArray(R.array.category_mvr).length; i++) {
            category.addSubCategory(new SubCategory(i, getResources().getStringArray(R.array.category_mvr)[i], getResources().getStringArray(R.array.documents_mvr)[i], R.color.mvrIndicator));

        }
        categories.add(category);
    }

    private void initUJPCategory() {
        Category category = new Category(1, getString(R.string.category_ujp), R.drawable.ujp_selector, R.color.ujpStatusBar, R.color.ujpActionBar);
        for (int i = 0; i < getResources().getTextArray(R.array.category_ujp).length; i++) {
            category.addSubCategory(new SubCategory(i, getResources().getStringArray(R.array.category_ujp)[i], getResources().getStringArray(R.array.documents_ujp)[i], R.color.ujpIndicator));

        }
        categories.add(category);
    }

    private void initMATICNOCategory() {
        Category category = new Category(1, getString(R.string.category_maticno), R.drawable.maticno_selector, R.color.maticnoStatusBar, R.color.maticnoActionBar);
        for (int i = 0; i < getResources().getTextArray(R.array.category_maticno).length; i++) {
            category.addSubCategory(new SubCategory(i, getResources().getStringArray(R.array.category_maticno)[i], getResources().getStringArray(R.array.documents_maticno)[i], R.color.maticnoIndicator));

        }
        categories.add(category);
    }

    private void initKATASTARCategory() {
        Category category = new Category(1, getString(R.string.category_katastar), R.drawable.katastar_selector, R.color.katastarStatusBar, R.color.katastarActionBar);
        for (int i = 0; i < getResources().getTextArray(R.array.category_katastar).length; i++) {
            category.addSubCategory(new SubCategory(i, getResources().getStringArray(R.array.category_katastar)[i], getResources().getStringArray(R.array.documents_katastar)[i], R.color.katastarIndicator));

        }
        categories.add(category);
    }

    private void initFZOCategory() {
        Category category = new Category(1, getString(R.string.category_fzo), R.drawable.fzo_selector, R.color.fzoStatusBar, R.color.fzoActionBar);
        for (int i = 0; i < getResources().getTextArray(R.array.category_fzo).length; i++) {
            category.addSubCategory(new SubCategory(i, getResources().getStringArray(R.array.category_fzo)[i], getResources().getStringArray(R.array.documents_fzo)[i], R.color.fzoIndicator));

        }
        categories.add(category);
    }

    private void initPIOMCategory() {
        Category category = new Category(1, getString(R.string.category_piom), R.drawable.piom_selector, R.color.piomStatusBar, R.color.piomActionBar);
        for (int i = 0; i < getResources().getTextArray(R.array.category_piom).length; i++) {
            category.addSubCategory(new SubCategory(i, getResources().getStringArray(R.array.category_piom)[i], getResources().getStringArray(R.array.documents_piom)[i], R.color.piomIndicator));

        }
        categories.add(category);
    }

    private void initAboutRotaryCategory() {
        Category category = new Category(99, getString(R.string.category_about_rotary), R.drawable.rotary_selector, R.color.colorPrimary, R.color.colorPrimaryDark);

        categories.add(category);
    }
}
