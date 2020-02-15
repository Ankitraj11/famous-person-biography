package com.example.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class KalamLifeViewPagerAdapter extends PagerAdapter {
    private List<KalamViewPagerModel> kalamViewPagerModelList;

    public KalamLifeViewPagerAdapter(List<KalamViewPagerModel> kalamViewPagerModelList) {
        this.kalamViewPagerModelList = kalamViewPagerModelList;
    }

    @Override
    public int getCount() {
        return kalamViewPagerModelList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//         super.instantiateItem(container, position);

         View view= LayoutInflater.from(container.getContext()).inflate(R.layout.kalamlife_viewpager_singleview,null);
        ImageView imageView=view.findViewById(R.id.viewpager_image);
        int images=kalamViewPagerModelList.get(position).getImages();
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
      //  super.destroyItem(container, position, object);

        container.removeView((View)object);
    }
}
