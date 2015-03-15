package com.infiniteloop.booknetwork.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.infiniteloop.booknetwork.R;
import com.infiniteloop.booknetwork.adapters.VolumesAdapter;
import com.infiniteloop.booknetwork.interactors.VolumesInteractor.GetVolumesType;
import com.infiniteloop.booknetwork.models.Volume;
import com.infiniteloop.booknetwork.presenters.VolumesPresenterImpl;

import java.util.ArrayList;

/**
 * Created by Bogdan on 3/15/2015.
 */
public class VolumesViewFragment extends Fragment implements VolumesView, View.OnClickListener, AdapterView.OnItemClickListener{

    ListView mVolumesListView;
    RelativeLayout mProgressContainer, mContentContainer, mReloadContainer;
    //    EventsListViewFooter mBottomProgress;
    TextView mVolumesErrorMessage;
    VolumesAdapter mAdapterVolumes;

    VolumesPresenterImpl mVolumesPresenter;

    ArrayList<Volume> mVolumes = new ArrayList<Volume>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_volumes, container, false);

        mVolumesListView = (ListView) rootView.findViewById(R.id.fragment_volumes_listView);
        mProgressContainer = (RelativeLayout) rootView.findViewById(R.id.events_progressBarContainer);
        mContentContainer = (RelativeLayout) rootView.findViewById(R.id.events_contentContainer);
        mReloadContainer = (RelativeLayout) rootView.findViewById(R.id.eventsReloadContainer);
        mVolumesErrorMessage = (TextView) rootView.findViewById(R.id.eventsErrorMessage);

        mAdapterVolumes = new VolumesAdapter(getActivity(), mVolumes);
        mVolumesListView.setAdapter(mAdapterVolumes);

        mReloadContainer.setOnClickListener(this);
        mVolumesListView.setOnItemClickListener(this);

        mVolumesPresenter = new VolumesPresenterImpl(this);
        mVolumesPresenter.getVolumes(getActivity(), GetVolumesType.GetVolumesType_Default);

        return rootView;
    }

    @Override
    public void showVolumes(ArrayList<Volume> volumes) {
        mVolumes.clear();
        mVolumes.addAll(volumes);

        mAdapterVolumes.notifyDataSetChanged();

    }

    @Override
    public void showProgressDialog() {

        mProgressContainer.setVisibility(View.VISIBLE);
        mContentContainer.setVisibility(View.GONE);
        mReloadContainer.setVisibility(View.GONE);
    }

    @Override
    public void showContentContainer() {

        mContentContainer.setVisibility(View.VISIBLE);
        mProgressContainer.setVisibility(View.GONE);
        mReloadContainer.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {

        if(error != null && error.length() > 0)mVolumesErrorMessage.setText(error);
        mProgressContainer.setVisibility(View.GONE);
        mContentContainer.setVisibility(View.GONE);
        mReloadContainer.setVisibility(View.VISIBLE);

    }

    @Override
    public void showFooterProgress() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dismissFooterProgress() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showListViewFooterError(String error) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.eventsReloadContainer:

                mVolumesPresenter.getVolumes(getActivity(), GetVolumesType.GetVolumesType_Default);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

//        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new VolumeDetails(mVolumes.get(arg2))).addToBackStack(null).commit();
    }
}
