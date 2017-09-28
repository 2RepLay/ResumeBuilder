package com.nikitayankov.resumebuilder.ui.fragment;

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
import com.nikitayankov.resumebuilder.core.models.cv.CV;
import com.nikitayankov.resumebuilder.core.workers.CVListAdapter;
import com.nikitayankov.resumebuilder.core.workers.RealmHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class GalleryFragment extends Fragment {

    Realm mRealm;

    CVListAdapter mCVListAdapter;
    LinearLayoutManager mCVListLayoutManager;

    @BindView(R.id.cv_list)
    RecyclerView mCVList;

    @BindView(R.id.add_cv)
    FloatingActionButton mAddCV;

    @OnClick(R.id.add_cv)
    public void addCV() {
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        Fragment fragment = new CVCreatorFragment();

        fragmentManager.beginTransaction()
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

        RealmConfiguration configuration = RealmHelper.Config.getCVConfig();
        mRealm = Realm.getInstance(configuration);

        mCVListAdapter = new CVListAdapter(this.getActivity(), mRealm.where(CV.class).findAll());
        mCVListLayoutManager = new LinearLayoutManager(this.getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        ButterKnife.bind(this, view);

        mCVList.setAdapter(mCVListAdapter);
        mCVList.setLayoutManager(mCVListLayoutManager);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
