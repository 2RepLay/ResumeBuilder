package com.nikitayankov.resumebuilder.core;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nikitayankov.resumebuilder.R;
import com.nikitayankov.resumebuilder.core.debug.Debug;
import com.nikitayankov.resumebuilder.core.services.HeadHunterService;
import com.nikitayankov.resumebuilder.core.workers.RealmHelper;
import com.nikitayankov.resumebuilder.ui.dialog.HHDialog;
import com.nikitayankov.resumebuilder.ui.fragment.AuthFragment;

import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class BaseActivity extends AppCompatActivity implements AuthFragment.OnFragmentInteractionListener {
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

//        RealmResults<User> users = realm.where(User.class).findAll();
//        if (users.size() > 0) {
//            next = GalleryFragment.newInstance();
//        } else {
//            next = AuthFragment.newInstance();
//        }
//
//        ft.add(next, "auth").replace(R.id.frame, next).commit();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://hh.ru/")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .build();

                HeadHunterService service = retrofit.create(HeadHunterService.class);

                Call<String> call = service.authCall("code",
                        getString(R.string.hh_client_id),
                        getString(R.string.hh_client_secret));

                try {
                    Response<String> response = call.execute();

                    showDialog(response.body());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    void showDialog(String content) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment newFragment = HHDialog.newInstance(content);
        newFragment.show(ft, "dialog");
    }
}
