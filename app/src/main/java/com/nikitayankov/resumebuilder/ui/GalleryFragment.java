package com.nikitayankov.resumebuilder.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikitayankov.resumebuilder.R;
import com.nikitayankov.resumebuilder.core.workers.CVListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GalleryFragment extends Fragment {
    @BindView(R.id.cv_list)
    RecyclerView mCVList;
    CVListAdapter mCVListAdapter;
    LinearLayoutManager mCVListLayoutManager;

    @BindView(R.id.add_cv)
    FloatingActionButton mAddCV;

    @OnClick(R.id.add_cv)
    public void addCV() {
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        Fragment fragment = new CVCreatorFragment();

        fragmentManager.beginTransaction()
                .setCustomAnimations(
                        android.R.animator.fade_in, android.R.animator.fade_out,
                        android.R.animator.fade_in, android.R.animator.fade_out)
                .replace(R.id.frame, fragment)
                .addToBackStack(null)
                .commit();
    }

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    public GalleryFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCVListAdapter = new CVListAdapter(this.getActivity());
        mCVListLayoutManager = new LinearLayoutManager(this.getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
