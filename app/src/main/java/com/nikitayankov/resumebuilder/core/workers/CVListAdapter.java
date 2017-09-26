package com.nikitayankov.resumebuilder.core.workers;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nikitayankov.resumebuilder.R;
import com.nikitayankov.resumebuilder.core.models.cv.CV;
import com.nikitayankov.resumebuilder.ui.PreviewFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class CVListAdapter extends RealmRecyclerViewAdapter<CV, CVListAdapter.CVListViewHolder> {
    private Context mContext;
    private ArrayList<CV> mCVS = new ArrayList<>();

    public CVListAdapter(Context context, OrderedRealmCollection<CV> cvs) {
        super(cvs, true);

        mContext = context;
        mCVS.addAll(cvs);
    }

    @Override
    public CVListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_card, parent, false);

        return new CVListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CVListViewHolder holder, int position) {
        holder.setCV(mCVS.get(position));
    }

    @Override
    public int getItemCount() {
        return mCVS.size();
    }

    class CVListViewHolder extends RecyclerView.ViewHolder {
        private CV mCV;

        @BindView(R.id.cv_title)
        TextView mCVTitle;

        @OnClick(R.id.card_root)
        void onClick() {
            PreviewFragment fragment = new PreviewFragment();

            FragmentManager fm = ((AppCompatActivity) mContext).getFragmentManager();
            fm.beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.frame, fragment)
                    .commit();
        }

        CVListViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        void setCV(CV cv){
            this.mCV = cv;
            this.mCVTitle.setText(cv.getVacancy());
        }
    }
}
