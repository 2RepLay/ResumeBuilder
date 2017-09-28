package com.nikitayankov.resumebuilder.ui.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.nikitayankov.resumebuilder.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HHDialog extends DialogFragment {

    public static HHDialog newInstance(String content) {
        HHDialog hhDialog = new HHDialog();

        Bundle args = new Bundle();
        args.putString("content", content);

        hhDialog.setArguments(args);

        return hhDialog;
    }

    @BindView(R.id.web_view)
    WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hh_dialog, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String content = getArguments().getString("content");

        mWebView.loadData(content, "text/html", "UTF-8");
    }
}
