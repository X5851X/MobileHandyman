package com.example.mobileprogproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    model[] Model;
    Context content;

    public MainAdapter(model[] Model, Context List) {
        this.Model = Model;
        this.content = List;
    }
    //construct

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_menu, parent, false);
        //menyambungkan sublayout untuk design recycleview
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
        //membuat viewholder dan dikaitkan dengan recycleview pada xml
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final model itemlist = Model[position];
        holder.imageView.setImageResource(itemlist.getImage());
        holder.textView1.setText(itemlist.getName());
        holder.textView2.setText("Rp." + itemlist.getHarga());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(content,Detail.class);
                intent.putExtra("image", itemlist.getImage());
                intent.putExtra("name", itemlist.getName());
                intent.putExtra("price", itemlist.getHarga());
                content.startActivity(intent);
            }
            //agar data yang di inginkan dapat diberikan kepada page selanjutnya
        });
    }


    @Override
    public int getItemCount() {
        return Model.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagephone);
            textView1 = itemView.findViewById(R.id.phonename);
            textView2 = itemView.findViewById(R.id.phoneprice);
        }
    }
}
