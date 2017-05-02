package ru.sberbank.user7.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements TestFragmentHost{
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.test);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.mainlayout, ButtonFragment.newInstance("button"), "aaa");
                transaction.add(R.id.mainlayout, TestFragment.newInstance("four"), "foo");
                transaction.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionInActivity:
                Fragment fragment = getFragmentManager().findFragmentByTag("foo");
                if (fragment!=null){
                    getFragmentManager().beginTransaction().remove(fragment).commit();
                    return true;

                }
            case R.id.actionDialog:
                AlertDialogFragment.newInstance("AlertDialog").show(getFragmentManager(), null);
        }
        return super.onOptionsItemSelected(item);
    }


    public void changeTest(String text) {
        TestFragment testFragment = (TestFragment) getFragmentManager().findFragmentByTag("aaa");
        if (testFragment!=null){
            testFragment.setText(text);
        }
    }

    @Override
    public void changeTest() {
        TestFragment testFragment = (TestFragment) getFragmentManager().findFragmentByTag("aaa");
        if (testFragment!=null){
            testFragment.setText("sdfsd");
        }
    }
}
