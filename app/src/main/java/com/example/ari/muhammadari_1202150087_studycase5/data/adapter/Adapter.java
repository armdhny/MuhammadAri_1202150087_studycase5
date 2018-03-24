package com.example.ari.muhammadari_1202150087_studycase5.data.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ari.muhammadari_1202150087_studycase5.R;
import com.example.ari.muhammadari_1202150087_studycase5.data.Data;

import java.util.List;

/**
 * Created by Ari on 24/03/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.holder> {
    //deklarasi variable yang akan digunakan
    private Context cntx;
    private List<Data> list;
    int color;

    //konstruktor
    public Adapter(Context cntx, List<Data> list, int color){
        this.cntx=cntx;
        this.list=list;
        this.color=color;
    }

    //menentukan viewholder untuk recyclerview
    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //membuat view baru
        View view = LayoutInflater.from(cntx).inflate(R.layout.cardviewlist, parent, false);
        holder hldr = new holder(view);
        return hldr;
    }

    //menyetting nilai yang didapatkan pada viewholder
    @Override
    public void onBindViewHolder(holder holder, int position) {
        Data data = list.get(position);
        holder.ToDo.setText(data.getTodo());
        holder.Description.setText(data.getDesc());
        holder.Priority.setText(data.getPrior());
        holder.cardv.setCardBackgroundColor(cntx.getResources().getColor(this.color));
    }

    //mendapatkan jumlah list
    @Override
    public int getItemCount() {
        return list.size();
    }

    //mendapatkan list dari adapter
    public Data getData(int position){
        return list.get(position);
    }

    //untuk menghapus list pada todolist
    public void deleteData(int i){
        //remove item yang terpilih
        list.remove(i);
        //memberi notifikasi item yang di remove
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, list.size());
    }

    class holder extends RecyclerView.ViewHolder{
        //deklarasi variable yang akan digunakan
        public TextView ToDo, Description, Priority;
        public CardView cardv;
        public holder(View itemView){
            super(itemView);

            //mengakses id text view pada layout dan juga cardview
            ToDo = itemView.findViewById(R.id.headline);
            Description = itemView.findViewById(R.id.explanation);
            Priority = itemView.findViewById(R.id.number);
            cardv = itemView.findViewById(R.id.cardlist);
        }
    }
}