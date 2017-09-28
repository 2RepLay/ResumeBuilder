package com.nikitayankov.resumebuilder.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikitayankov.resumebuilder.R;
import com.nikitayankov.resumebuilder.core.models.cv.CV;

import butterknife.ButterKnife;

public class PreviewFragment extends Fragment {

    public static PreviewFragment getInstance(CV cv) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("cv", cv);

        PreviewFragment previewFragment = new PreviewFragment();
        previewFragment.setArguments(bundle);

        return previewFragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
