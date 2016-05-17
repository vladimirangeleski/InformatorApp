package rotaryinformatorapp.com.rotaryinformatorapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rotaryinformatorapp.com.rotaryinformatorapp.App;
import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.adapter.CategoriesRecyclerViewAdapter;
import rotaryinformatorapp.com.rotaryinformatorapp.model.Category;
import rotaryinformatorapp.com.rotaryinformatorapp.ui.activity.MainActivity;
import rotaryinformatorapp.com.rotaryinformatorapp.util.BundleConstants;
import rotaryinformatorapp.com.rotaryinformatorapp.util.LogWrapper;
import rotaryinformatorapp.com.rotaryinformatorapp.util.Util;

/**
 * Created by Vladimir on 5/10/2016.
 */
public class CategoryFragment extends Fragment implements CategoriesRecyclerViewAdapter.OnCategoryItemClickListener {
    public static final String TAG = "CategoryFragment";
    private RecyclerView categories;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        initView(view);
        setCategoriesAdapter();
        return view;
    }

    private void initView(View view) {
        categories = (RecyclerView) view.findViewById(R.id.categories);
        categories.setHasFixedSize(true);
        int numberOfColumns = Util.calculateNumberOfCategoryColums(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(App.getContext(), numberOfColumns);
        categories.setLayoutManager(gridLayoutManager);
    }

    private void setCategoriesAdapter() {
        categories.setAdapter(new CategoriesRecyclerViewAdapter(App.getContext(), App.getCategories(), this));
    }

    private void openClickedCategory(Category category, int position) {
        FragmentManager fm = getFragmentManager();
        SubCategoriesFragment fragment = new SubCategoriesFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleConstants.CATEGORY, category);
        fragment.setArguments(bundle);
        fm.beginTransaction().replace(R.id.container, fragment, SubCategoriesFragment.TAG).addToBackStack(null).commit();
        //.setCustomAnimations(android.R.anim.fade_out, android.R.anim.fade_in)
    }

    @Override
    public void onCategoryClick(Category category, int position) {
        LogWrapper.d(TAG, "onCategoryClick categpry=" + category);
        openClickedCategory(category, position);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null)
            getActivity().setTitle(getString(R.string.app_name));

        if (getActivity() != null) {
            ((MainActivity) getActivity()).displayHomeAsUpEnabled(false);
        }
        changeActionbarColor();
    }

    private void changeActionbarColor() {
        if (getActivity() != null)
            ((MainActivity) getActivity()).changeActionbarColor(R.color.colorPrimary, R.color.colorPrimaryDark);
    }
}