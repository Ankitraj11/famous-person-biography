package com.example.c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EinsteinActivity extends AppCompatActivity {
ImageView images;
TextView professions;
private Button knowmore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstein);
        images=findViewById(R.id.einstein_image);
        professions=findViewById(R.id.einstein_profession);
        knowmore=findViewById(R.id.einstein_knowmore);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            int image=bundle.getInt("photo");
            String profession=bundle.getString("profession");
            images.setImageResource(image);
            professions.setText(profession);


        }

                 knowmore.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Intent intent =new Intent(EinsteinActivity.this,EinsteinLifeActivity.class);
                         startActivity(intent);
                     }
                 });
    }
}
