package com.udacity.gradle.builditbigger.free;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

public class MainActivityFragment extends Fragment {

    private Button btn_joke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        btn_joke = root.findViewById(R.id.btn_joke);

        btn_joke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke() {

        new EndpointsAsyncTask(getContext()).execute();

    }
}