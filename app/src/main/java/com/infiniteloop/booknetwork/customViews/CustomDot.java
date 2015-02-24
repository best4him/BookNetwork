package com.infiniteloop.booknetwork.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.infiniteloop.booknetwork.R;

/**
 * Created by Bogdan on 2/22/2015.
 */
public class CustomDot extends LinearLayout {
    public CustomDot(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_views_custom_dot, this);
    }

    public CustomDot(Context context) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_views_custom_dot, this);
    }

    public void setDotImageRessource(int ressource) {

        ((ImageView) findViewById(R.id.customDotImageView)).setImageResource(ressource);
    }
}