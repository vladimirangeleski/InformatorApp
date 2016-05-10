package rotaryinformatorapp.com.rotaryinformatorapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rotaryinformatorapp.com.rotaryinformatorapp.App;
import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.adapter.SubCategoriesRecyclerViewAdapter;
import rotaryinformatorapp.com.rotaryinformatorapp.model.Category;
import rotaryinformatorapp.com.rotaryinformatorapp.model.SubCategory;
import rotaryinformatorapp.com.rotaryinformatorapp.util.BundleConstants;

/**
 * Created by Vladimir on 5/10/2016.
 */
public class SubCategoriesFragment extends Fragment implements SubCategoriesRecyclerViewAdapter.OnSubCategoryItemClickListener {
    public static final String TAG = "SubCategoriesFragment";

    private Category category;
    private RecyclerView recyclerView;
    private SubCategoriesRecyclerViewAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(BundleConstants.CATEGORY)) {
            category = (Category) getArguments().getSerializable(BundleConstants.CATEGORY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_categories, container, false);
        initView(view);
        setSubCategoriesAdapter();
        return view;
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.sub_categories);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(App.getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setSubCategoriesAdapter() {
        recyclerView.setAdapter(new SubCategoriesRecyclerViewAdapter(App.getContext(), category.getSubCategories(), this));
    }

    @Override
    public void onSubCategoryClick(SubCategory category, int position) {

    }
}
