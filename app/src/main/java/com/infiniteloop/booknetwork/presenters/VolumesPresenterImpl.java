package com.infiniteloop.booknetwork.presenters;

import android.content.Context;

import com.infiniteloop.booknetwork.callBacks.OnVolumesChanged;
import com.infiniteloop.booknetwork.interactors.VolumesInteractor;
import com.infiniteloop.booknetwork.interactors.VolumesInteractorImpl;
import com.infiniteloop.booknetwork.models.Volume;
import com.infiniteloop.booknetwork.views.VolumesView;

import java.util.ArrayList;

/**
 * Created by Gherasim on 1/9/2015.
 */
public class VolumesPresenterImpl implements VolumesPresenter, OnVolumesChanged {

    VolumesView mVolumesView;
    VolumesInteractorImpl mVolumesInteractor;

    public VolumesPresenterImpl(VolumesView mEventsView) {
        this.mVolumesView = mEventsView;

        mVolumesInteractor = VolumesInteractorImpl.staticInstance();
    }
    
	@Override
	public void getVolumes(Context context, VolumesInteractor.GetVolumesType type) {
		
		mVolumesView.showProgressDialog();
		mVolumesInteractor.get(context, this, type);
	}
	
	@Override
	public void onVolumesChanged(ArrayList<Volume> volumes) {
		mVolumesView.showContentContainer();
		mVolumesView.showVolumes(volumes);
		
	}
	
	@Override
	public void onVolumesRequestFailed(String errorMessage) {
		mVolumesView.showError(errorMessage);
		
	}
	
}
