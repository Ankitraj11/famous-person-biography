package com.example.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KalamLifeRecyclerViewAdapter extends RecyclerView.Adapter<KalamLifeRecyclerViewAdapter.ViewHolder> {
    List<KalamLifeRecyclerViewModel> kalamLifeRecyclerViewModelList;

    public KalamLifeRecyclerViewAdapter(List<KalamLifeRecyclerViewModel> kalamLifeRecyclerViewModelList) {
        this.kalamLifeRecyclerViewModelList = kalamLifeRecyclerViewModelList;
    }

    @NonNull
    @Override
    public KalamLifeRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.kalam_life_recycler_single_view,null);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull KalamLifeRecyclerViewAdapter.ViewHolder holder, int position) {
               KalamLifeRecyclerViewModel kalamLifeRecyclerViewModel=kalamLifeRecyclerViewModelList.get(position);
               String text=kalamLifeRecyclerViewModel.getText();
               int images=kalamLifeRecyclerViewModel.getImages();
               holder.setData(text,images);

    }

    @Override
    public int getItemCount() {
        return kalamLifeRecyclerViewModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

         textView=itemView.findViewById(R.id.kalam_recycler_text);
         imageView=itemView.findViewById(R.id.kalam_recycler_image);
        }
        private void setData(String text,int image)
        {
            textView.setText(text);
            imageView.setImageResource(image);

        }


    }
}
