package com.infiniteloop.booknetwork.views;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infiniteloop.booknetwork.R;
import com.infiniteloop.booknetwork.utils.ViewUtils;

/**
 * Created by Bogdan on 2/21/2015.
 */
public class WelcomeFragment0  extends Fragment implements View.OnClickListener{

    OnClickToBeginButtonClicked mListener;

    TextView mTextViewBegin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mListener = (OnClickToBeginButtonClicked) getActivity();

        mTextViewBegin = (TextView) rootView.findViewById(R.id.fragment_main_TextView_begin);

        mTextViewBegin.setOnClickListener(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mTextViewBegin.startAnimation(ViewUtils.getAnimation(400, (float)1.5, 1));
            }
        }, 1000);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        ((MainActivity) activity).onSectionAttached(
//                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_main_TextView_begin:
                mListener.onClickToBeginButtonClicked();
                mTextViewBegin.setVisibility(View.GONE);
                break;

        }
    }

    public interface OnClickToBeginButtonClicked{

        public void onClickToBeginButtonClicked();
    }


}
