package com.example.swipevideoapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    TextView textView;

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

        final ViewPager2 videoViewPager = findViewById(R.id.videoViewPager);

        List<VideoItem> videoItemLists = new ArrayList<>();


        VideoItem duck = new VideoItem();
        duck.videoURL = "https://firebasestorage.googleapis.com/v0/b/cs460-5cfa5.appspot.com/o/This%20rubber%20duck%20can%20debug%20your%20code.mp4?alt=media&token=f00d41b8-5c9f-405c-bd30-9f9a18204dce";
        duck.videotitle = "Rubber Duck";
        duck.videoDescription = "talk to the duck";
        duck.videoID = "ID: 0001";
        videoItemLists.add(duck);

        VideoItem bestTikTok = new VideoItem();
        bestTikTok.videoURL = "https://firebasestorage.googleapis.com/v0/b/cs460-5cfa5.appspot.com/o/I%20Dowt%20it.mp4?alt=media&token=22b5fe7e-ffc7-475c-a0f8-d593c2b3ae47";
        bestTikTok.videotitle = "I Dowt it";
        bestTikTok.videoDescription = "Think you can stop what we do?\n" +
                "I doubt it (doubt it)\n" +
                "We got the energy, we'll tell you all about it (about it)\n" +
                "I searched for my spark and I found it (found it)\n" +
                "Everybody in the crowd start bouncing";
        bestTikTok.videoID = "ID: 0002";
        videoItemLists.add(bestTikTok);

        VideoItem ash = new VideoItem();
        ash.videoURL = "https://firebasestorage.googleapis.com/v0/b/cs460-5cfa5.appspot.com/o/Ash%20dropping%20the%20TRUTH%20about%20photography.mp4?alt=media&token=64086b88-d997-488b-bf3a-04a864edfcc8";
        ash.videotitle = "Get yourself a new life";
        ash.videoDescription = "Ash dropping the TRUTH about photography";
        ash.videoID = "ID: 0003";
        videoItemLists.add(ash);

        VideoItem cs = new VideoItem();
        cs.videoURL = "https://firebasestorage.googleapis.com/v0/b/cs460-5cfa5.appspot.com/o/Freshman%20vs%20Senior%20Computer%20Science%20Majors.mp4?alt=media&token=ab4d93e6-f011-4510-bb62-58e07300f8ea";
        cs.videotitle = "CS majors ☝\uFE0F\uD83E\uDD13 freshmen vs senior";
        cs.videoDescription = "still confused on what the master theorem is";
        cs.videoID = "ID: 0004";
        videoItemLists.add(cs);

        VideoItem env = new VideoItem();
        env.videoURL = "https://firebasestorage.googleapis.com/v0/b/cs460-5cfa5.appspot.com/o/You%20ignored%20ignoring%20your%20env%20file%20%23coding%20%23programming%20%23javascript%20%23python.mp4?alt=media&token=71bf0fae-28e8-4036-9e76-9310c26bf0e5";
        env.videotitle = "ignor ignoring your env";
        env.videoDescription = "lol imagine posting your API keys to github";
        env.videoID = "ID: 0005";
        videoItemLists.add(env);

        videoViewPager.setAdapter(new VideoAdapter(videoItemLists));

    }
}