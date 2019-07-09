package com.example.android_tarot;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class OneCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_card);

        // リソース情報からタロットの絵柄をランダムで取得する
        final TypedArray tarotImagesArray = getResources().obtainTypedArray(R.array.loading_tarot_images);
        int choice = (int) (Math.random() * tarotImagesArray.length());

        ImageView oneCardImage = (ImageView) findViewById(R.id.oneCardImage);
        oneCardImage.setImageResource(tarotImagesArray.getResourceId(choice, R.drawable.cu01));
        tarotImagesArray.recycle();
    }
}
