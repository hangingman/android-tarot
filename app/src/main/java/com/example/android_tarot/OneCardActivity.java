package com.example.android_tarot;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OneCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_card);

        // リソース情報からタロットの絵柄をランダムで取得する
        final TypedArray tarotImagesArray = getResources().obtainTypedArray(R.array.loading_tarot_images);
        final String[] tarotNameArray = getResources().getStringArray(R.array.loading_tarot_names);
        final String[] readingPositive = getResources().getStringArray(R.array.tarot_reading_positive);
        final String[] readingReverse = getResources().getStringArray(R.array.tarot_reading_reverse);

        int choice = (int) (Math.random() * tarotImagesArray.length());

        ImageView oneCardImage = (ImageView) findViewById(R.id.oneCardImage);

        // 1/2の確率で逆位置
        // Math.random() returns a value between 0.0 and 1.0
        // so it is heads or tails 50% of the time
        boolean isReverse = false;
        if (Math.random() < 0.5) {
            oneCardImage.setRotation(180);
            isReverse = true;
        }

        oneCardImage.setImageResource(tarotImagesArray.getResourceId(choice, R.drawable.cu01));
        tarotImagesArray.recycle();

        TextView tarotName = (TextView) findViewById(R.id.tarotName);
        tarotName.setText(tarotNameArray[choice]);

        TextView tarotDesc = (TextView) findViewById(R.id.tarotDescTextView);
        if (isReverse) {
            tarotDesc.setText(readingReverse[choice]);
        } else {
            tarotDesc.setText(readingPositive[choice]);
        }
    }
}
