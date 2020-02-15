package com.example.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class EinsteinViewPagerAdapter extends PagerAdapter {
    List<EinsteinViewPagerModel> einsteinViewPagerModelList;



    public EinsteinViewPagerAdapter(List<EinsteinViewPagerModel> einsteinViewPagerModelList) {
        this.einsteinViewPagerModelList = einsteinViewPagerModelList;
    }


    @Override
    public int getCount() {

        return einsteinViewPagerModelList.size();
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

      View view= LayoutInflater.from(container.getContext()).inflate(R.layout.einstein_viewpager_singleview,null);
        ImageView imageView=view.findViewById(R.id.einstein_viewpager_image);
            int images=einsteinViewPagerModelList.get(position).getImages();
            imageView.setImageResource(images);

               container.addView(view,0);
               return  view;

}
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);

    }



}

