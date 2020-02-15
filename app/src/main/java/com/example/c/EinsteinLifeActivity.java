package com.example.c;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class EinsteinLifeActivity extends AppCompatActivity {
    private List<EinsteinViewPagerModel> einsteinviewPagerModelList;
    private EinsteinViewPagerAdapter einsteinviewPagerAdapter;
    private ViewPager einsteinviewPager;
    private final static long DELAY_TIME = 1500;
    private final static long PERIOD_TIME = 1500;
    private int currentPageEintein = 2;
    private Timer timer;
    private List<EinsteinRecyclerViewModel> einsteinRecyclerViewModelList;
    private EinsteinRecyclerViewAdapter einsteinRecyclerViewAdapter;
    private RecyclerView einsteinRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstein_life);

        einsteinviewPager = findViewById(R.id.einstein_viewpager);
        einsteinviewPagerModelList = new ArrayList<>();
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein8));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein9));


        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein1));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein2));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein3));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein4));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein5));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein6));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein7));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein8));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein9));

        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein1));
        einsteinviewPagerModelList.add(new EinsteinViewPagerModel(R.drawable.einstein2));


        einsteinviewPagerAdapter = new EinsteinViewPagerAdapter(einsteinviewPagerModelList);
        einsteinviewPager.setAdapter(einsteinviewPagerAdapter);

        einsteinviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                      currentPageEintein=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if(state==ViewPager.SCROLL_STATE_IDLE)
                {
                    pagelooper();
                }
            }
        });

         startSlideShow();
    einsteinviewPager.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            pagelooper();
            stopSlideShow();
            if(motionEvent.getAction()==MotionEvent.ACTION_UP)
            {
                startSlideShow();
            }
            return false;
        }
    });

              einsteinRecyclerview=findViewById(R.id.recyler_View_einstein);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        einsteinRecyclerview.setLayoutManager(layoutManager);
        einsteinRecyclerViewModelList=new ArrayList<>();
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewModelList.add(new EinsteinRecyclerViewModel(R.drawable.einstein5,"Childhood"));
        einsteinRecyclerViewAdapter=new EinsteinRecyclerViewAdapter(einsteinRecyclerViewModelList);
        einsteinRecyclerview.setAdapter(einsteinRecyclerViewAdapter);
        einsteinRecyclerViewAdapter.notifyDataSetChanged();

    }

    private void stopSlideShow() {
    timer.cancel();

    }

    private void startSlideShow() {


       final Handler handler=new Handler();
       final Runnable update=new Runnable() {
           @Override
           public void run() {
               if(currentPageEintein>=einsteinviewPagerModelList.size()) {

                       currentPageEintein = 1;
                   }
                   einsteinviewPager.setCurrentItem(currentPageEintein++, true);
               }

       };

      timer =new Timer();
      timer.schedule(new TimerTask() {
          @Override
          public void run() {
              handler.post(update);}
          },DELAY_TIME,PERIOD_TIME);
      }



    private void pagelooper() {

        if (currentPageEintein == einsteinviewPagerModelList.size() - 2)
        {
            currentPageEintein = 2;
            einsteinviewPager.setCurrentItem(currentPageEintein, false);
        }
        if (currentPageEintein == 1)
        {
            currentPageEintein = einsteinviewPagerModelList.size() - 3;
            einsteinviewPager.setCurrentItem(currentPageEintein, false);
        }
    }



}
