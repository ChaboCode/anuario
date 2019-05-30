package com.lab.sans.anuario;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListInflater extends RecyclerView.Adapter<ListInflater.ViewHolder> {

    private String[] names;
    public static int[] images = new int[]{ R.drawable.foto_0, R.drawable.foto_1,
                                      R.drawable.foto_2, R.drawable.foto_3,
                                      R.drawable.foto_5, R.drawable.foto_4 };
    private int i;

    ListInflater(String[] names){
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        try {
                viewHolder.name.setText(names[i * 2]);
                viewHolder.name2.setText(names[i * 2 + 1]);
                viewHolder.picture.setImageResource(images[i * 2]);
                viewHolder.picture2.setImageResource(images[i * 2 + 1]);
                viewHolder.show_more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = new Intent(v.getContext(), MoreInfoActivity.class).putExtra("local", i * 2);
                        ContextCompat.startActivity(v.getContext(), in, Bundle.EMPTY);
                    }
                });
                viewHolder.show_more2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = new Intent(v.getContext(), MoreInfoActivity.class).putExtra("local", i * 2 + 1);
                        ContextCompat.startActivity(v.getContext(), in, Bundle.EMPTY);
                    }
                });

            } catch (IndexOutOfBoundsException e) {
                viewHolder.name2.setText("Fin del anuario");
            }
        }

    @Override
    public int getItemCount() {
        return (names.length) / 2;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, name2;
        CardView cardView;
        ImageView picture, picture2;
        Button show_more, show_more2;

        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            cardView = itemView.findViewById(R.id.cardView);
            picture = itemView.findViewById(R.id.picture);
            show_more = itemView.findViewById(R.id.show_more);
            name2 = itemView.findViewById(R.id.name2);
            picture2 = itemView.findViewById(R.id.picture2);
            show_more2 = itemView.findViewById(R.id.show_more2);
        }
    }
}
