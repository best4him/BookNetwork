package com.infiniteloop.booknetwork.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infiniteloop.booknetwork.R;

/**
 * Created by Bogdan on 2/21/2015.
 */
public class WelcomeFragment1  extends Fragment {

    public static final String WELCOME_SCREEN_NUMBER = "com.infiniteloop.booknetwork.welcome_screen_number";

    private ImageView mImageViewImage;
    private TextView mTextViewTitle1, mTextViewTitle2, mTextViewContent;
    private LinearLayout mLinearLayoutWaitContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        mImageViewImage = (ImageView) rootView.findViewById(R.id.fragment_welcome_ImageViewimage);
        mTextViewTitle1 = (TextView) rootView.findViewById(R.id.fragment_welcome_TextView_title1);
        mTextViewTitle2 = (TextView) rootView.findViewById(R.id.fragment_welcome_TextView_title2);
        mTextViewContent = (TextView) rootView.findViewById(R.id.fragment_welcome_TextView_content);
        mLinearLayoutWaitContainer = (LinearLayout) rootView.findViewById(R.id.fragment_welcome_LinearLayout_loading);

        if(getArguments() != null ) {

            switch (getArguments().getInt(WELCOME_SCREEN_NUMBER)) {

                case 0:
                    mTextViewTitle2.setVisibility(View.VISIBLE);
                    mTextViewTitle2.setText("Kristo Godari");
                    mImageViewImage.setVisibility(View.GONE);
                    break;
                case 1:
                    mImageViewImage.setImageResource(R.drawable.search);
                    mTextViewTitle1.setText(getResources().getString(R.string.welcome_search_title));
                    mTextViewContent.setText(getResources().getString(R.string.welcome_search_content));

                    break;
                case 2:
                    mTextViewTitle1.setText(getResources().getString(R.string.welcome_review_title));
                    mTextViewContent.setText(getResources().getString(R.string.welcome_review_content));
                    mImageViewImage.setImageResource(R.drawable.review);
                    break;
                case 3:
                    mImageViewImage.setImageResource(R.drawable.rate);
                    mTextViewTitle1.setText(getResources().getString(R.string.welcome_rate_title));
                    mTextViewContent.setText(getResources().getString(R.string.welcome_rate_content));
                    break;
                case 4:
                    mImageViewImage.setImageResource(R.drawable.share);
                    mTextViewTitle1.setText(getResources().getString(R.string.welcome_share_title));
                    mTextViewContent.setText(getResources().getString(R.string.welcome_share_content));
                    mLinearLayoutWaitContainer.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    mImageViewImage.setVisibility(View.GONE);
                    mTextViewTitle1.setVisibility(View.GONE);
                    mTextViewTitle2.setVisibility(View.GONE);
                    mTextViewContent.setVisibility(View.GONE);

            }
        }

        return rootView;
    }

}
