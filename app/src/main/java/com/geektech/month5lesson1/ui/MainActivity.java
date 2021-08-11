package com.geektech.month5lesson1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.util.Log;

import com.geektech.month5lesson1.R;
import com.geektech.month5lesson1.domain.CustomContent;
import com.geektech.month5lesson1.ui.adapters.EmojiAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.EmojiViewHolder.Listener {

    private RecyclerView recyclerView;
    private EmojiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new EmojiAdapter(this);
        recyclerView = findViewById(R.id.rv_cards);
        recyclerView.setAdapter(adapter);

        CustomContent customContent = new CustomContent(1, "card1", 15.0);
        CustomContent customContent1 = new CustomContent(1, "card1", 15.0);
        boolean isMatch = customContent.equals(customContent1);
        Log.d("TAG", "onCreate: " + isMatch);
    }

    @Override
    public void choose() {
        adapter.notifyDataSetChanged();
    }
}