package com.infiniteloop.booknetwork.customViews;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Bogdan on 2/22/2015.
 */
public class CustomViewPager extends ViewPager{

    private boolean swipeable = true;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSwipeable(boolean state){

        swipeable = false;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {


        if(swipeable) {

            return super.onInterceptTouchEvent(ev);
        } else {

            return false;
        }
    }

    @Override
    public void scrollTo(int x, int y){
        if (swipeable){
            super.scrollTo(x, y);
        }
    }
}
