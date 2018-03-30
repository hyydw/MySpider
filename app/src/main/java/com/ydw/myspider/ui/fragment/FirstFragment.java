package com.ydw.myspider.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ydw.myspider.R;

/**
 * Created by Administrator on 2018/3/20 0020.
 */

public class FirstFragment extends Fragment{

    public static final String INTENT_STRING_TABNAME = "intent_String_tabname";
    public static final String INTENT_INT_INDEX = "intent_int_index";
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.tab_center, container, false);
        TextView textView = (TextView)fragmentView.findViewById(R.id.textView);
        Bundle bundle = getArguments();
//        String tabName = bundle.getString(INTENT_STRING_TABNAME);
//        int index = bundle.getInt(INTENT_INT_INDEX);
//        textView.setText(tabName);
        return fragmentView;
    }
//    @Override
//    protected View onCreateView(Bundle savedInstanceState) {
//        super.onCreateView(savedInstanceState);
//        final View fragmentView = inflater.inflate(R.layout.fragment_debug, container, false);
//        setContentView(R.layout.tab_center);
//        TextView textView = (TextView)findViewById(R.id.textView);
//        Bundle bundle = getArguments();
//        String tabName = bundle.getString(INTENT_STRING_TABNAME);
//        int index = bundle.getInt(INTENT_INT_INDEX);
//        textView.setText(tabName);
//    }
}
