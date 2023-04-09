package com.example.project8_2c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView listView;
    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum=0;
    File[] imageFiles;
    String imageFname;
    int imageSize;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Simple Image Viewer");

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        myPicture = findViewById(R.id.myPictureView);
        listView = findViewById(R.id.listView);

        imageFiles= new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        imageFname = imageFiles[curNum].toString();
        myPicture.imagePath = imageFname;

        imageSize = imageFiles.length;

        listView.setText((curNum+1) + "/" + imageSize);

        Log.d("ImageFiles", Arrays.toString(imageFiles));
        Log.d("ImagePath", imageFname);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                curNum --;

                if(curNum < 0)
                    curNum = imageSize - 1;

                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                listView.setText((curNum+1) + "/" + imageSize);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view) {
                curNum++;

                if (curNum >= imageSize)
                    curNum = 0;

                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                listView.setText((curNum + 1) + "/" + imageSize);

            }
        });
    }
}
