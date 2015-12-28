package com.example.batman.jokesdisplay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Tobias on 26-12-2015.
 */
public class JokesActivityFragment extends Fragment {
    public JokesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_jokes, container, false);
        String joke = getActivity().getIntent().getExtras().getString(JokesActivity.JOKE);
        ((TextView) rootView.findViewById(R.id.textview_jokes)).setText(joke);
        return rootView;
    }
}
