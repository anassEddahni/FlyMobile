package com.example.dit.viewpagerswipe;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static com.example.dit.viewpagerswipe.ConvertBitmap.getImage;

public class FullScreenActivity extends AppCompatActivity {
    ImageView imageView;
    byte [] monBit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        imageView = (ImageView) findViewById(R.id.image_full_screen);
        Bundle extras = getIntent().getExtras();
        monBit = extras.getByteArray("Bitmap");
        Bitmap bmp =  getImage( monBit);
        imageView.setImageBitmap(bmp);
    }
}
