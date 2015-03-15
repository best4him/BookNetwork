package com.infiniteloop.booknetwork.views;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;

import com.infiniteloop.booknetwork.R;
import com.infiniteloop.booknetwork.customViews.CustomViewPager;
import com.infiniteloop.booknetwork.customViews.CustomViewPagerDots;

import java.util.Locale;

public class WelcomeActivity extends FragmentActivity implements ViewPager.OnPageChangeListener{

    public static final int NUMBER_OF_PAGES = 6;

    SectionsPagerAdapter mSectionsPagerAdapter;

    CustomViewPager mViewPager;
    CustomViewPagerDots mViewPagerDots;
    private boolean swipeable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPagerDots = (CustomViewPagerDots) findViewById(R.id.activity_welcome_custom_view_pager_dots);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (CustomViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        if(position == NUMBER_OF_PAGES-2) {


            float alpha = 1 -  (float)positionOffsetPixels/1080;
            AlphaAnimation alphaUp = new AlphaAnimation(alpha, alpha);
            alphaUp.setFillAfter(true);
            ((RelativeLayout) findViewById(R.id.activity_welcome_container)).startAnimation(alphaUp);

        }
    }

    @Override
    public void onPageSelected(int position) {

        if(swipeable)mViewPagerDots.setPage(position);

        if(position == NUMBER_OF_PAGES-1) {

//            swipeable = false;
//
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    WelcomeActivity.this.finish();
                }
            }, 400);
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//
//                    mViewPager.setSwipeable(false);
//                }
//            }, 270);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Bundle bundle = new Bundle();
            bundle.putInt(WelcomeFragment1.WELCOME_SCREEN_NUMBER, position);

            Fragment fragment = new WelcomeFragment1();

            fragment.setArguments(bundle);

            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return NUMBER_OF_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    public void skip(View v) {

        finish();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        public PlaceholderFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
//            return rootView;
//        }
//    }

}
