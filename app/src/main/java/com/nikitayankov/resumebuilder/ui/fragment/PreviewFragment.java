package com.nikitayankov.resumebuilder.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nikitayankov.resumebuilder.R;
import com.nikitayankov.resumebuilder.core.models.cv.CV;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PreviewFragment extends Fragment {
    public static PreviewFragment getInstance(CV cv) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("cv", cv);

        PreviewFragment previewFragment = new PreviewFragment();
        previewFragment.setArguments(bundle);

        return previewFragment;
    }

    private CV mCV;

    @BindView(R.id.cv_photo)
    ImageView mCvPhoto;

    @BindView(R.id.cv_name)
    TextView mCvName;

    @BindView(R.id.cv_vacancy)
    TextView mCvVacancy;

    @BindView(R.id.cv_salary)
    TextView mCvSalary;

    @BindView(R.id.cv_email)
    TextView mCvEmail;

    @BindView(R.id.cv_phone)
    TextView mCvPhone;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        mCV = (CV) bundle.getSerializable("cv");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview, container, false);
        ButterKnife.bind(this, view);

        mCvName.setText(mCV.getName());
        mCvVacancy.setText(mCV.getVacancy());
        mCvSalary.setText(String.valueOf(mCV.getSalary()));
        mCvEmail.setText(mCV.getEmail());
        mCvPhone.setText(mCV.getPhone());

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
