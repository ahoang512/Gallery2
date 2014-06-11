package edu.ucsb.cs.cs185.seanprasertsit.gallery2.app;

import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.TextView;

public class gallery extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

/*
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.Lmain);
        linearLayout.setBackgroundColor(Color.GRAY);
        ScrollView scroll = (ScrollView) findViewById(R.id.main);
        scroll.setBackgroundColor(Color.GRAY);
*/
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.


        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);


/*
        GridView gridview4 = (GridView) findViewById(R.id.gridView4);
        GridView gridview3 = (GridView) findViewById(R.id.gridView3);
        GridView gridview2 = (GridView) findViewById(R.id.gridView2);
        GridView gridview1 = (GridView) findViewById(R.id.gridView1);
        gridview1.setAdapter(new ImageAdapter1(this));
        gridview2.setAdapter(new ImageAdapter1(this));
        gridview3.setAdapter(new ImageAdapter1(this));
        gridview4.setAdapter(new ImageAdapter1(this));


        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(gallery.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(gallery.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        gridview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(gallery.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(gallery.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
*/



    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_gallery, container, false);

        return rootView;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment fragment = new Fragment();
            switch (position) {
                case 0:
                    return fragment = new CameraFragment();
                case 1:
                    return fragment = new GalleryFragment();
                case 2:
                    return fragment = new FriendFragment();
                default:
                    break;
            }
            return fragment;
            //return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_friends, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    public static class GalleryFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "1";

        public static GalleryFragment newInstance(int sectionNumber) {
            GalleryFragment fragment = new GalleryFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public GalleryFragment() {}

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
            //SurfaceView sview = (SurfaceView) rootView.findViewById(R.id.camera);

            GridView gridview4 = (GridView) rootView.findViewById(R.id.gridView4);
            GridView gridview3 = (GridView) rootView.findViewById(R.id.gridView3);
            GridView gridview2 = (GridView) rootView.findViewById(R.id.gridView2);
            GridView gridview1 = (GridView) rootView.findViewById(R.id.gridView1);
            gridview1.setAdapter(new ImageAdapter1(rootView.getContext()));
            gridview2.setAdapter(new ImageAdapter1(rootView.getContext()));
            gridview3.setAdapter(new ImageAdapter1(rootView.getContext()));
            gridview4.setAdapter(new ImageAdapter1(rootView.getContext()));


            gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(getActivity(), AlbumActivity.class);
                    ((gallery) getActivity()).startActivity(intent);
                }
            });

            gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(getActivity(), AlbumActivity.class);
                    ((gallery) getActivity()).startActivity(intent);
                }
            });

            gridview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(getActivity(), AlbumActivity.class);
                    ((gallery) getActivity()).startActivity(intent);
                }
            });

            gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(getActivity(), AlbumActivity.class);
                    ((gallery) getActivity()).startActivity(intent);
                }
            });



            return rootView;
        }
    }

    public static class CameraFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "1";

        public static CameraFragment newInstance(int sectionNumber) {
            CameraFragment fragment = new CameraFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public CameraFragment() {}

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_camera, container, false);
            //SurfaceView sview = (SurfaceView) rootView.findViewById(R.id.camera);
            return rootView;
        }
    }
    public static class FriendFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "2";

        public static FriendFragment newInstance(int sectionNumber) {
            FriendFragment fragment = new FriendFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public FriendFragment() {}

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_friends, container, false);
            return rootView;
        }
    }

}
