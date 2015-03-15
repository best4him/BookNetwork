package com.infiniteloop.booknetwork.callBacks;

import com.infiniteloop.booknetwork.models.Volume;

import java.util.ArrayList;

/**
 * Created by Gherasim on 1/9/2015.
 */
public interface OnVolumesChanged {

    public void onVolumesChanged(ArrayList<Volume> Volumes);
    public void onVolumesRequestFailed(String errorMessage);

}
