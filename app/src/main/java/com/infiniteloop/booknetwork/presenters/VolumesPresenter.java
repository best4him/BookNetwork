package com.infiniteloop.booknetwork.presenters;

import android.content.Context;

import com.infiniteloop.booknetwork.interactors.VolumesInteractor;

/**
 * Created by Gherasim on 1/9/2015.
 */
public interface VolumesPresenter {

    public void getVolumes(Context context, VolumesInteractor.GetVolumesType type);

}
