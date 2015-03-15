package com.infiniteloop.booknetwork.interactors;

import android.content.Context;

import com.infiniteloop.booknetwork.callBacks.OnVolumesChanged;

/**
 * Created by Gherasim on 1/9/2015.
 */
public interface VolumesInteractor {

	public enum GetVolumesType{
		
		GetVolumesType_Default,
		GetVolumesType_Reload,
	}
	
    public void get(Context context, OnVolumesChanged listener, GetVolumesType type);
}
