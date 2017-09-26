package com.nikitayankov.resumebuilder.ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nikitayankov.resumebuilder.R;
import com.nikitayankov.resumebuilder.core.debug.Debug;
import com.nikitayankov.resumebuilder.core.models.cv.CV;
import com.nikitayankov.resumebuilder.core.models.cv.CVContactInformation;
import com.nikitayankov.resumebuilder.core.models.cv.achievement.Achievement;
import com.nikitayankov.resumebuilder.core.models.cv.skill.Skill;
import com.nikitayankov.resumebuilder.core.workers.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CVCreatorFragment extends Fragment {
    private Realm mRealm;

    @BindView(R.id.vacancy)
    EditText mVacancy;

    @BindView(R.id.salary)
    EditText mSalary;

    @BindView(R.id.email)
    EditText mEmail;

    @BindView(R.id.phone)
    EditText mPhone;

    @BindView(R.id.skills)
    RecyclerView mSkills;

    @BindView(R.id.achievements)
    RecyclerView mAchievements;

    @BindView(R.id.save)
    Button mAddCV;

    @OnClick(R.id.save)
    public void saveCV() {
        String vacancy = mVacancy.getText().toString();
        long salary = Long.parseLong(mSalary.getText().toString());
        String email = mEmail.getText().toString();
        String phone = mPhone.getText().toString();

        CVContactInformation cvContactInformation = new CVContactInformation(email, phone);

        List<Skill> skillList = new ArrayList<>();
        List<Achievement> achievementList = new ArrayList<>();

        CV cv = CV.newBuilder()
                .setVacancy(vacancy)
                .setSalary(salary)
                .addContactInformation(cvContactInformation)
                .addSkills(skillList)
                .addAchievements(achievementList)
                .build();

        if (mRealm != null) {
            mRealm.beginTransaction();
            mRealm.copyToRealm(cv);
            mRealm.commitTransaction();

            Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();

            Debug.Log(cv.toString());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RealmConfiguration config = RealmHelper.Config.getCVConfig();
        mRealm = Realm.getInstance(config);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_cv, container, false);
        ButterKnife.bind(this, view);

        loadDebug();
        return view;
    }

    @SuppressLint("SetTextI18n")
    void loadDebug() {
        this.mVacancy.setText("Android");
        this.mSalary.setText("2000");
        this.mEmail.setText("nickrocket97@gmail.com");
        this.mPhone.setText("0123456789");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
