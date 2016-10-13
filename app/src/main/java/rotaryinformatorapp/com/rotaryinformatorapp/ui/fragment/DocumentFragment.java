package rotaryinformatorapp.com.rotaryinformatorapp.ui.fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.joanzapata.pdfview.PDFView;

import java.io.IOException;

import rotaryinformatorapp.com.rotaryinformatorapp.App;
import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.model.SubCategory;
import rotaryinformatorapp.com.rotaryinformatorapp.ui.activity.MainActivity;
import rotaryinformatorapp.com.rotaryinformatorapp.util.BundleConstants;
import rotaryinformatorapp.com.rotaryinformatorapp.util.LogWrapper;
import rotaryinformatorapp.com.rotaryinformatorapp.util.Util;

/**
 * Created by Vladimir on 5/10/2016.
 */
public class DocumentFragment extends Fragment {
    public static final String TAG = DocumentFragment.class.getName();

    private SubCategory subCategory;

    private PDFView pdfView;
    private FloatingActionButton sendEmail;

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
        display(subCategory.getAssetFileName());
        return view;
    }

    private void initView(View view) {
        pdfView = (PDFView) view.findViewById(R.id.pdfview);
        sendEmail = (FloatingActionButton) view.findViewById(R.id.sendEmail);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{});
                email.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.document) + " " + subCategory.getName());
                email.putExtra(Intent.EXTRA_TEXT, "");
                //need this to prompts email client only
                email.setType("message/rfc822");
                email.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                Uri uri1 = null;
                try {
                    uri1 = Uri.fromFile(Util.getAssetFile(App.getContext(), subCategory.getAssetFileName()));
                    LogWrapper.d(TAG, "URI=" + uri1);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(App.getContext(), "Wooops", Toast.LENGTH_LONG).show();
                }

                email.putExtra(Intent.EXTRA_STREAM, uri1);
                startActivity(Intent.createChooser(email, "Одбери Email клиент :"));
            }
        });
        sendEmail.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(subCategory.getColor())));

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedFragment", TAG);
        outState.putSerializable(BundleConstants.CATEGORY, BundleConstants.SUB_CATEGORY);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            ((MainActivity) getActivity()).displayHomeAsUpEnabled(true);
        }
    }

    private void display(String assetFileName) {
        try {
            pdfView.fromAsset(assetFileName).showMinimap(true).enableSwipe(true)
                    .load();
            if (getActivity() != null)
                getActivity().setTitle(subCategory.getName());
        } catch (Exception e) {
            LogWrapper.e(TAG, e.getMessage());
            Toast.makeText(App.getContext(), getString(R.string.load_file_error), Toast.LENGTH_SHORT).show();
            try {
                exitFragment();
            } catch (Exception e1) {
                LogWrapper.e(TAG, e1.getMessage());
            }
        }
    }

    private void exitFragment() {
        getFragmentManager().popBackStack();
    }
}