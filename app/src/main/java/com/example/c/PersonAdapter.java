package com.example.c;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
     private List<PersonModel> personModelList =new ArrayList<>();
private Context context;

    public PersonAdapter(List<PersonModel> personModelList) {
        this.personModelList = personModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.persons_single_view,null);
        return   new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            PersonModel personModel = personModelList.get(position);
            String names= personModel.getName();
            int images=personModel.getImage();

          holder.setTopic(names,position,images);

    }



    @Override
    public int getItemCount() {
        return personModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView image;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

        //  itemView.setOnClickListener(new View.OnClickListener() {
          //    @Override
           //   public void onClick(View view) {

             //     PersonModel personModel = personModelList.get(getAdapterPosition());

            //     String professions= personModel.getProfession();
             //    int image= personModel.getImage();

               //   Intent intent=new Intent(view.getContext(), AboutKalamActivity.class);
             //    intent.putExtra("profession",professions);
             //    intent.putExtra("photo",image);
             //     view.getContext().startActivity(intent);
             // }
         // });


         textView=itemView.findViewById(R.id.person_name);
         image=itemView.findViewById(R.id.person_image);
        }
        private void setTopic(String name, final int position,int images){
            textView.setText(name);
            image.setImageResource(images);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == 0) {
                        PersonModel personModel = personModelList.get(getAdapterPosition());

                        String professions = personModel.getProfession();
                        int image = personModel.getImage();

                        Intent intent = new Intent(view.getContext(), AboutKalamActivity.class);
                        intent.putExtra("profession", professions);
                        intent.putExtra("photo", image);
                        view.getContext().startActivity(intent);
                    }
                   else if(position==1)
                    {
                        PersonModel personModel = personModelList.get(getAdapterPosition());

                        String professions = personModel.getProfession();
                        int image = personModel.getImage();

                        Intent intent = new Intent(view.getContext(), EinsteinActivity.class);
                        intent.putExtra("profession", professions);
                        intent.putExtra("photo", image);
                        view.getContext().startActivity(intent);



                    }

                }
            });
    }





    }}

