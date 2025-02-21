package com.example.bttuan4;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView img1 = findViewById(R.id.imageView1);
        img1.setImageResource(R.drawable.kotlin);

        ConstraintLayout bg = findViewById(R.id.main);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg1);
        arrayList.add(R.drawable.bg2);
        arrayList.add(R.drawable.bg3);
        arrayList.add(R.drawable.bg4);

        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));

        ImageButton img2 = findViewById(R.id.imageButton1);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.dart);
                img1.getLayoutParams().width = 550;
                img1.getLayoutParams().height = 550;
                img1.requestLayout(); // Cập nhật lại layout sau khi thay đổi kích thước
            }
        });

        //switch
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ //isChecked = true
                    bg.setBackgroundResource(R.drawable.bg3);
                }else{
                    bg.setBackgroundResource(R.drawable.bg4);
                }
            }
        });

        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox);
        ck1.setOnCheckedChangeListener(new
           CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                   if(isChecked){
                       bg.setBackgroundResource(R.drawable.bg3);
                   }else{
                       bg.setBackgroundResource(R.drawable.bg4);
                   }
               }
           });
    }
}
