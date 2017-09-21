package com.nikitayankov.resumebuilder.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nikitayankov.resumebuilder.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GalleryFragment extends Fragment {
    @BindView(R.id.cv_list)
    RecyclerView mCVList;

    @BindView(R.id.add_cv)
    FloatingActionButton mAddCV;

    @OnClick(R.id.add_cv)
    public void addCV() {
        Toast.makeText(getActivity(), "Add!", Toast.LENGTH_SHORT).show();
    }

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    public GalleryFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
