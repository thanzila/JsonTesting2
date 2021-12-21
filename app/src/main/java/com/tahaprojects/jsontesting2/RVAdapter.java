package com.tahaprojects.jsontesting2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    List<MyData>myDataList=new ArrayList<>();
    Context context;
   // private Object Context;



    public RVAdapter(List<MyData> myDataList,Context context) {
        this.myDataList = myDataList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvId.setText(myDataList.get(position).toString());
        holder.tvtitle.setText(myDataList.get(position).toString());
        Glide.with(context).asBitmap().load("https://thumbs.dreamstime.com/b/camping-girl-character-camping-girl-character-illustration-138449418.jpg").into(holder.imgVw);

    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvId,tvtitle,tvData;
        private ImageView imgVw;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tvId);
            tvtitle=itemView.findViewById(R.id.tvtitle);
            tvData=itemView.findViewById(R.id.tvLLData);
            imgVw=itemView.findViewById(R.id.imgVw);
        }
    }
}
