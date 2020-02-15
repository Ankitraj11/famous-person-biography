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

 public class AboutKalamLifeActivity extends AppCompatActivity {
 final private static  long PERIOD_TIME=1500;
 final private static   long DELAY_TIME=1500;
 private int currentpage=2;
 private Timer timer;
 private ViewPager viewPager;
 List<KalamViewPagerModel> kalamViewPagerModelList;
  private KalamLifeViewPagerAdapter kalamLifeViewPagerAdapter;
  private RecyclerView kalamliferecyclerview;
  private List<KalamLifeRecyclerViewModel> kalamLifeRecyclerViewModelList;
  private KalamLifeRecyclerViewAdapter kalamLifeRecyclerViewAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_kalam_life);
        viewPager = findViewById(R.id.kalam_life_viewpager);
        kalamViewPagerModelList = new ArrayList<>();

        kalamViewPagerModelList = new ArrayList<>();
        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul5));
        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul6));

        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul1));
        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul2));
        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul3));
        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul4));
        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul5));
        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul6));
        // kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul1));
        // kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul2));
        //  kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul3));
        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul1));
        kalamViewPagerModelList.add(new KalamViewPagerModel(R.drawable.abdul2));

        kalamLifeViewPagerAdapter = new KalamLifeViewPagerAdapter(kalamViewPagerModelList);
        viewPager.setAdapter(kalamLifeViewPagerAdapter);


        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentpage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    pageLoppper();
                }
            }
        };
        viewPager.addOnPageChangeListener(onPageChangeListener);
        startSLideShow();

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                  pageLoppper();
                  stopSlideshow();
                  if(motionEvent.getAction()==MotionEvent.ACTION_UP)
                  {
                      startSLideShow();
                  }



                return false;
            }
        });

        kalamliferecyclerview=findViewById(R.id.kalam_recycler_view);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        kalamliferecyclerview.setLayoutManager(layoutManager);
        kalamLifeRecyclerViewModelList=new ArrayList<>();

        kalamLifeRecyclerViewModelList.add(new KalamLifeRecyclerViewModel(R.drawable.abdul3,"Birth"));
        kalamLifeRecyclerViewModelList.add(new KalamLifeRecyclerViewModel(R.drawable.abdul4,"Education"));
        kalamLifeRecyclerViewModelList.add(new KalamLifeRecyclerViewModel(R.drawable.abdul1,"ChildHood"));
        kalamLifeRecyclerViewModelList.add(new KalamLifeRecyclerViewModel(R.drawable.abdul5,"awards"));
        kalamLifeRecyclerViewModelList.add(new KalamLifeRecyclerViewModel(R.drawable.abdul6,"Isro"));
        kalamLifeRecyclerViewModelList.add(new KalamLifeRecyclerViewModel(R.drawable.abdul2,"Sprituality"));
        kalamLifeRecyclerViewModelList.add(new KalamLifeRecyclerViewModel(R.drawable.abdul1,"As a missile Man"));
        kalamLifeRecyclerViewModelList.add(new KalamLifeRecyclerViewModel(R.drawable.abdul6,"Death"));

        kalamLifeRecyclerViewAdapter=new KalamLifeRecyclerViewAdapter(kalamLifeRecyclerViewModelList);
        kalamliferecyclerview.setAdapter(kalamLifeRecyclerViewAdapter);
        kalamLifeRecyclerViewAdapter.notifyDataSetChanged();

    }


    private void startSLideShow() {

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                 if(currentpage>=kalamViewPagerModelList.size()) {
                      currentpage = 1;}
                     viewPager.setCurrentItem(currentpage++, true);
                 }
    };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);}},
             DELAY_TIME, PERIOD_TIME);

            }

            private void pageLoppper() {

       if(currentpage==kalamViewPagerModelList.size()-2)
       {
           currentpage=2;
           viewPager.setCurrentItem(currentpage,false);
       }
      if(currentpage==1)
      {
          currentpage=kalamViewPagerModelList.size()-3;
          viewPager.setCurrentItem(currentpage,false);
      }


    }
  private void stopSlideshow()
  {

      timer.cancel();}
  }


