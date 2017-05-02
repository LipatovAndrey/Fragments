package ru.sberbank.user7.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user7 on 02.05.2017.
 */

public class TestFragment extends Fragment  {
    private int frcounter = 0;
    public void setText(String text){
        ((TextView)getView()).setText(text);
    getArguments().putString(ARG_TEXT, text);}
    private  static final String ARG_TEXT = "text";
    public static TestFragment newInstance(String text){
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        frcounter++;
        TextView view = (TextView) inflater.inflate(R.layout.test_fragment, container, false);
        String text = getArguments().getString(ARG_TEXT);
        view.setText(text + " " + Integer.toString(frcounter));

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionFragment:

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(R.string.messageSimpleDialog);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
        }
        return true;
    }
}
