package com.example.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AbdulKalamAdapter extends RecyclerView.Adapter<AbdulKalamAdapter.ViewHolder> {

    ArrayList<AbdulKalamModel> abdulKalamModelList;

    public AbdulKalamAdapter(ArrayList<AbdulKalamModel> abdulKalamModelList) {
        this.abdulKalamModelList = abdulKalamModelList;
    }

    @NonNull
    @Override
    public AbdulKalamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.abdul_kalam_single_view,null);
      return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AbdulKalamAdapter.ViewHolder holder, int position) {
                AbdulKalamModel abdulKalamModel=abdulKalamModelList.get(position);
                int images=abdulKalamModel.getImages();
        holder.setImage(images);
    }

    @Override
    public int getItemCount() {
       abdulKalamModelList=new ArrayList<>();
        return abdulKalamModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView abdulkalamimages;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            abdulkalamimages=itemView.findViewById(R.id.abdulkalam_image);

        }
            private void setImage(int image)
            {
              abdulkalamimages.setImageResource(image);
            }
    }

}
