package com.infiniteloop.booknetwork.utils;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * Created by Bogdan on 2/22/2015.
 */
public class ViewUtils {

    public static Animation getAnimation(int duration, float initianScale, float finalScale) {

        ScaleAnimation animation = new ScaleAnimation(initianScale, finalScale,initianScale, finalScale, Animation.RELATIVE_TO_SELF, (float)0.5, Animation.RELATIVE_TO_SELF, (float)0.5);

        animation.setDuration(duration);

        return animation;

    }

}
