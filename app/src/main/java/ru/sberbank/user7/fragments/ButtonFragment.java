package ru.sberbank.user7.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user7 on 02.05.2017.
 */

public class ButtonFragment extends Fragment {
    private  static final String ARG_TEXT = "button";
    public static TestFragment newInstance(String text){
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentbutton, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TestFragmentHost) getActivity()).changeTest();
            }
        });
        return view;
    }


}
