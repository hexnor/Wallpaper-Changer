package com.example.rake.wallpaperchanger;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Integer img[]={R.raw.i1,R.raw.i2,R.raw.i3,R.raw.i4,R.raw.i5,R.raw.i6,R.raw.i7,R.raw.i8,R.raw.i9,R.raw.i10};
    ImageView imageView;
    static int position;
    WallpaperManager wallpaperManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        position=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
        wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
        imageView.setImageResource(img[position]);
    }

    @Override
    public void onClick(View v) {
        position=set(position);
        try {imageView.setImageResource(img[position]);
            wallpaperManager.setResource(img[position]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public int set(int position)
    {if(position==9)
        position=-1;
        position++;
        return position;
    }
}
