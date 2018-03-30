package com.ydw.myspider;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;


import com.ydw.myspider.ui.fragment.FirstFragment;
import com.ydw.myspider.ui.fragment.HomepageFragment;

/**
 * Created by Administrator on 2018/3/20 0020.
 */

public class FirstTabAdapter extends FragmentPagerAdapter {
    private String[] tabNames = {"主页", "消息", "发现", "我"};
    private int[] tabIcons = {R.drawable.maintab_1_selector, R.drawable.maintab_2_selector, R.drawable.maintab_3_selector,
            R.drawable.maintab_4_selector};
    private LayoutInflater inflater;

    public FirstTabAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);

//        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tabNames.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Bundle bundle = null;
        switch (position) {
            case 0:
                fragment = new FirstFragment();
                bundle = new Bundle();
                bundle.putInt("pos", 0);
                bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[position]);
                fragment.setArguments(bundle);
                break;
            case 1:
                fragment = new HomepageFragment();
                bundle = new Bundle();
                bundle.putInt("pos", 1);
                bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[position]);
                fragment.setArguments(bundle);
                break;
            case 2:
                fragment = new FirstFragment();
                bundle = new Bundle();
                bundle.putInt("pos", 2);
                bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[position]);
                fragment.setArguments(bundle);
                break;
            case 3:
                fragment = new FirstFragment();
                bundle = new Bundle();
                bundle.putInt("pos", 3);
                bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[position]);
                fragment.setArguments(bundle);
                break;
        }
        return fragment;
    }

//    @Override
//    public View getViewForTab(int position, View convertView, ViewGroup container) {
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.tab_main, container, false);
//        }
//        TextView textView = (TextView) convertView;
//        textView.setText(tabNames[position]);
//        textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
//        return textView;
//    }
//
//    @Override
//    public Fragment getFragmentForPage(int position) {
//        FirstFragment mainFragment = new FirstFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[position]);
//        bundle.putInt(FirstFragment.INTENT_INT_INDEX, position);
//        mainFragment.setArguments(bundle);
//        return mainFragment;
//    }
}
