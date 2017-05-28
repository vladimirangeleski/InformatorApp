package rotaryinformatorapp.com.rotaryinformatorapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rotaryinformatorapp.com.rotaryinformatorapp.App;
import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.adapter.SubCategoriesRecyclerViewAdapter;
import rotaryinformatorapp.com.rotaryinformatorapp.custom.DividerItemDecoration;
import rotaryinformatorapp.com.rotaryinformatorapp.model.Category;
import rotaryinformatorapp.com.rotaryinformatorapp.model.SubCategory;
import rotaryinformatorapp.com.rotaryinformatorapp.ui.activity.MainActivity;
import rotaryinformatorapp.com.rotaryinformatorapp.util.BundleConstants;
import rotaryinformatorapp.com.rotaryinformatorapp.util.SimpleDividerItemDecoration;

/**
 * Created by Vladimir on 5/10/2016.
 */
public class SubCategoriesFragment extends Fragment implements SubCategoriesRecyclerViewAdapter.OnSubCategoryItemClickListener {
    public static final String TAG = "SubCategoriesFragment";

    private Category category;
    private RecyclerView recyclerView;
    private SubCategoriesRecyclerViewAdapter.OnSubCategoryItemClickListener onSubCategoryItemClickListener;

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
        onSubCategoryItemClickListener = this;
        initView(view);
        setSubCategoriesAdapter();
        return view;
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.sub_categories);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(App.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(App.getContext(), R.drawable.divider));
        //recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
    }

    private void setSubCategoriesAdapter() {
        recyclerView.setAdapter(new SubCategoriesRecyclerViewAdapter(App.getContext(), category.getSubCategories(), onSubCategoryItemClickListener));
    }

    @Override
    public void onSubCategoryClick(SubCategory category, int position) {
        openClickedDocument(category, position);
    }

    private void openClickedDocument(SubCategory category, int position) {
        FragmentManager fm = getFragmentManager();
        DocumentFragment fragment = new DocumentFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleConstants.SUB_CATEGORY, category);
        fragment.setArguments(bundle);
        FragmentTransaction ft = fm.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.container, fragment, DocumentFragment.TAG).addToBackStack(null).commit();
        //.setCustomAnimations(android.R.anim.fade_out, android.R.anim.fade_in)
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedFragment", TAG);
        outState.putSerializable(BundleConstants.CATEGORY, category);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null)
            getActivity().setTitle(category.getName());

        if (getActivity() != null) {
            ((MainActivity) getActivity()).displayHomeAsUpEnabled(true);
        }
        changeActionbarColor();
    }

    private void changeActionbarColor() {
        if (getActivity() != null)
            ((MainActivity) getActivity()).changeActionbarColor(category.getStatusbarColor(), category.getActionbarColor());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onSubCategoryItemClickListener = null;
    }
}
