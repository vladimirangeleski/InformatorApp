package rotaryinformatorapp.com.rotaryinformatorapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joanzapata.pdfview.PDFView;

import java.io.File;

import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.model.SubCategory;
import rotaryinformatorapp.com.rotaryinformatorapp.util.BundleConstants;

/**
 * Created by Vladimir on 5/10/2016.
 */
public class DocumentFragment extends Fragment {
    public static final String TAG = "DocumentFragment";

    private SubCategory subCategory;

    private PDFView pdfView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(BundleConstants.SUB_CATEGORY)) {
            subCategory = (SubCategory) getArguments().getSerializable(BundleConstants.SUB_CATEGORY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_document, container, false);
        initView(view);
        display("test.pdf");
        return view;
    }

    private void initView(View view) {
        pdfView = (PDFView) view.findViewById(R.id.pdfview);
    }

    private void display(String assetFileName) {
        getActivity().setTitle(subCategory.getName());

        pdfView.fromAsset(assetFileName)
                .load();
    }
}