package com.nikitayankov.resumebuilder.core;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nikitayankov.resumebuilder.R;
import com.nikitayankov.resumebuilder.core.models.user.User;
import com.nikitayankov.resumebuilder.core.workers.RealmHelper;
import com.nikitayankov.resumebuilder.ui.AuthFragment;
import com.nikitayankov.resumebuilder.ui.GalleryFragment;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class BaseActivity extends AppCompatActivity implements AuthFragment.OnFragmentInteractionListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_activity);

        // TODO: 23.09.2017 Remove fragment manager from here
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment next;

        RealmConfiguration config = RealmHelper.Config.getUserConfig();
        Realm realm = Realm.getInstance(config);

        RealmResults<User> users = realm.where(User.class).findAll();
        if (users.size() > 0) {
            next = GalleryFragment.newInstance();
        } else {
            next = AuthFragment.newInstance();
        }

        ft.add(next, "auth").replace(R.id.frame, next).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
