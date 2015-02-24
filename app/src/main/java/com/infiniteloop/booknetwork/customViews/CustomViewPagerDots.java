package com.infiniteloop.booknetwork.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.infiniteloop.booknetwork.R;
import com.infiniteloop.booknetwork.utils.ViewUtils;

import java.util.ArrayList;

/**
 * Created by Bogdan on 2/22/2015.
 */
public class CustomViewPagerDots extends LinearLayout{

    ArrayList<CustomDot> mDots;
    CustomDot mDot0, mDot1,mDot2,mDot3,mDot4;
    CustomDot mLastPageDot;

    public CustomViewPagerDots(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_views_custom_dots, this);

        mDot0 = (CustomDot) findViewById(R.id.cumstom_dot0);
        mDot1 = (CustomDot) findViewById(R.id.cumstom_dot1);
        mDot2 = (CustomDot) findViewById(R.id.cumstom_dot2);
        mDot3 = (CustomDot) findViewById(R.id.cumstom_dot3);
        mDot4 = (CustomDot) findViewById(R.id.cumstom_dot4);

        mDots = new ArrayList<CustomDot>();

        mDots.add(mDot0);mDots.add(mDot1);mDots.add(mDot2);mDots.add(mDot3);mDots.add(mDot4);

        mLastPageDot = mDots.get(0);
        mLastPageDot.setDotImageRessource(R.drawable.shape_dot_black);

    }

    public void setPage(int pageNumber) {

        if(mLastPageDot != null) {
            mLastPageDot.setDotImageRessource(R.drawable.shape_dot);
            mLastPageDot = mDots.get(pageNumber);
            mLastPageDot.setDotImageRessource(R.drawable.shape_dot_black);

            mLastPageDot.startAnimation(ViewUtils.getAnimation(400, 2, 1));
        }
    }
}
