package com.example.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EinsteinRecyclerViewAdapter extends RecyclerView.Adapter<EinsteinRecyclerViewAdapter.ViewHolder> {
    private List<EinsteinRecyclerViewModel> einsteinRecyclerViewModelList=new ArrayList<>();

    public EinsteinRecyclerViewAdapter(List<EinsteinRecyclerViewModel> einsteinRecyclerViewModelList) {
        this.einsteinRecyclerViewModelList = einsteinRecyclerViewModelList;
    }


    @Override
    public int getItemCount() {
        return einsteinRecyclerViewModelList.size();

    }



    @NonNull
    @Override
    public EinsteinRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.einstein_recycler_singleview,null);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EinsteinRecyclerViewAdapter.ViewHolder holder, int position) {

        EinsteinRecyclerViewModel einsteinRecyclerViewModel=einsteinRecyclerViewModelList.get(position);
        String currentLifeStatus=einsteinRecyclerViewModel.getLifestatus();
        int image=einsteinRecyclerViewModel.getImages();
        holder.setData(currentLifeStatus,image);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView currentLifeStatus;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

          currentLifeStatus=itemView.findViewById(R.id.einstein_recyclerview_text);
          image=itemView.findViewById(R.id.einstein_recyclerview_image);

        }

            private void setData(String currentlifeStatus,int images)
            {
                currentLifeStatus.setText(currentlifeStatus);
                image.setImageResource(images);
            }
    }
}
