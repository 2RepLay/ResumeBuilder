package com.nikitayankov.resumebuilder.core.workers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.nikitayankov.resumebuilder.core.models.cv.CV;

import java.util.ArrayList;

public class CVListAdapter extends RecyclerView.Adapter<CVListAdapter.CVListViewHolder> {
    private Context mContext;
    private ArrayList<CV> mCVS;

    public CVListAdapter (Context context) {
        mContext = context;
    }

    public CVListAdapter (Context context, ArrayList<CV> cvs) {
        mContext = context;
        mCVS = cvs;
    }

    @Override
    public CVListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CVListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CVListViewHolder extends RecyclerView.ViewHolder {

        public CVListViewHolder(View itemView) {
            super(itemView);
        }
    }
}
