package com.example.c;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private FrameLayout homeFrameLayout;
    Button rightarrow;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rightarrow = view.findViewById(R.id.right_arrow);
        homeFrameLayout = getActivity().findViewById(R.id.Home_frameLayout);

        rightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSyllabusFragment(new FamousPersonListFragment());
            }
        });

        return view;
    }


    private void setSyllabusFragment (FamousPersonListFragment famousPersonListFragment)
    {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slide_fron_right);
        fragmentTransaction.replace(homeFrameLayout.getId(), famousPersonListFragment);
        fragmentTransaction.commit();

    }




}
