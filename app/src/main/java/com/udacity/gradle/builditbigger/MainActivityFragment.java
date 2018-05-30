package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button btn_joke;
    private TextView tv_des;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        btn_joke = root.findViewById(R.id.btn_joke);
        tv_des = root.findViewById(R.id.instructions_text_view);

        btn_joke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });

       if (BuildConfig.FLAVOR.equals("free")) {

            com.udacity.gradle.builditbigger.free.MainActivityFragment freeFragment = new com.udacity.gradle.builditbigger.free.MainActivityFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, freeFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            btn_joke.setVisibility(View.GONE);
            tv_des.setVisibility(View.GONE);
        }

        return root;
    }

    public void tellJoke() {
        new EndpointsAsyncTask(getContext()).execute();
    }
}
