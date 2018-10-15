package com.firebase_demo;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

class songsAdapter extends RecyclerView.Adapter<songsViewHolder> {

    private ArrayList<Songs> SongsA;

    songsAdapter( ArrayList<Songs> songs) {
        this.SongsA = songs;

    }

    @NonNull
    @Override
    public songsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.songslist, viewGroup, false);
        return new songsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull songsViewHolder topArtistViewHolder, int i) {
        Songs songs = SongsA.get(i);
        topArtistViewHolder.bind(songs.title +" - "+ songs.year, songs.author);
    }

    @Override
    public int getItemCount() {
        return SongsA.size();
    }
}

class songsViewHolder extends RecyclerView.ViewHolder {
    private TextView textView1, textView2;
    private ImageView imageView;

    songsViewHolder(@NonNull View itemView) {
        super(itemView);

        textView1 = itemView.findViewById(R.id.tvData1);
        textView2 = itemView.findViewById(R.id.tvData2);

    }

    void bind(String text1, String text2) {
        textView1.setText(text1);
        textView2.setText(text2);


    }


}
class Songs {
    String album;
    String author;
    String company;
    String composer;
    String cover;
    String title;
    Long year;
}


