package com.nikitayankov.resumebuilder.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nikitayankov.resumebuilder.R;
import com.nikitayankov.resumebuilder.core.models.user.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import static com.nikitayankov.resumebuilder.core.workers.RealmHelper.Config;


public class AuthFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private Realm mRealm;

    @BindView(R.id.name)
    EditText mName;

    @BindView(R.id.surname)
    EditText mSurname;

    @BindView(R.id.enter)
    Button mEnter;

    @OnClick(R.id.enter)
    public void setEnter(View view) {
        String name = mName.getText().toString();
        String surname = mSurname.getText().toString();

        if (mRealm != null) {
            mRealm.beginTransaction();

            User user = mRealm.createObject(User.class);

            user.setName(name);
            user.setSurname(surname);
            user.setAge(20);

            mRealm.commitTransaction();

            Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }

    public AuthFragment() {

    }

    public static AuthFragment newInstance() {
        return new AuthFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RealmConfiguration config = Config.getUserConfig();
        mRealm = Realm.getInstance(config);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth, container, false);
        ButterKnife.bind(this, view);

        mName.setText("Nikita");
        mSurname.setText("Yankov");

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
