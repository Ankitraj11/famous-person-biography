package com.example.c;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FamousPersonListFragment extends Fragment {
 Button backarrow;
 private RecyclerView recyclerView;
 private PersonAdapter personAdapter;
 private List<PersonModel> personModelList;
 private ArrayList<AbdulKalamModel> abdulKalamModelArrayList;
       private FrameLayout homeFrameLayout;
    public FamousPersonListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_famous_person_list, container, false);
        backarrow=view.findViewById(R.id.back_arrow_syllabus);
        homeFrameLayout=getActivity().findViewById(R.id.Home_frameLayout);


       backarrow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               setHomeFragement(new HomeFragment());
           }
       });

       personModelList =new ArrayList<>();
       recyclerView=view.findViewById(R.id.recyler_View);
          abdulKalamModelArrayList=new ArrayList<>();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.abdul1));
        personModelList.add(new PersonModel("Einstein","Scientist",R.drawable.einstein1));
        //personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.hwavei));
       // personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.nature1));
       // personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.nature7));
       // personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.nature5));
       // personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.nature4));
      //  personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.nature6));
       // personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.pay));
      //  personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.google));
      //  personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.google));
      //  personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.google));
      //  personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.google ));
      //  personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.google));
      //  personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.google));
     //   personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.google));
      //  personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.google));
     //   personModelList.add(new PersonModel("Dr.APJ Abdul Kalam Azad","Scientist",R.drawable.google));


        personAdapter =new PersonAdapter(personModelList);
        recyclerView.setAdapter(personAdapter);
        personAdapter.notifyDataSetChanged();


        return  view;



    }

    private void setHomeFragement(HomeFragment homeFragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_fron_right,R.anim.slide_from_left);
        fragmentTransaction.replace(homeFrameLayout.getId(),homeFragment);
          fragmentTransaction.commit();
    }


}
