package com.example.c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AboutKalamActivity extends AppCompatActivity {
    private FrameLayout homeframelayout;
    private TextView aboutprofession;
    private ImageView images;
    private ArrayList<AbdulKalamModel> abdulKalamModelArrayList;
    private AbdulKalamAdapter abdulKalamAdapter;
    private RecyclerView abdulkalamimagerecyclerview;
    private Button btnknowmoreforward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_kalam);
        homeframelayout = findViewById(R.id.Home_frameLayout);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            String professions = bundle.getString("profession");
            int image = bundle.getInt("photo");

            aboutprofession = findViewById(R.id.about_profession);
            aboutprofession.setText(professions);
            images = findViewById(R.id.images);
            images.setImageResource(image);

        }
        btnknowmoreforward=findViewById(R.id.btn_knowmore_forward);
        btnknowmoreforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AboutKalamActivity.this,AboutKalamLifeActivity.class);
                startActivity(intent);
            }
        });






    }
}