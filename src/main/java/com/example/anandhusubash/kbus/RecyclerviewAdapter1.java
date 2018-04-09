package com.example.anandhusubash.kbus;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nandhu on 14-03-2018.
 */

public class RecyclerviewAdapter1 extends RecyclerView.Adapter<RecyclerviewAdapter1.MyViewHolder> {

    List<Matcheslist> matcheslists;
    private Context context;
    private LayoutInflater inflater;
    public RelativeLayout linear;
    public String imageopen;
    RecyclerView recyclerView;

    public RecyclerviewAdapter1(Context context, List<Matcheslist> bus, RecyclerView recyclerView) {
        this.context = context;
        this.matcheslists = bus;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.recyclerView=recyclerView;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.single_layout, parent, false);
        return new MyViewHolder(rootView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Matcheslist list = matcheslists.get(position);
        holder.bus.setText("Name : "+list.getBus());
        holder.time.setText("Time : "+list.getTime());
        holder.number.setText("Number : "+list.getNumber());
        holder.via.setText("Via : "+list.getVia());
      /*  holder.title.setText("" + list.getTitle());
            holder.desc.setText("" + list.getAuthor());


        holder.author.setText("" + list.getTime());
        imageopen = list.getImage();*/
            //Picasso.with(context).load(imageopen).into(holder.profileMain);
            //holder.profileMain.setImageURI(Uri.parse(imageopen));


    }

    @Override
    public int getItemCount() {
        return matcheslists.size();

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView bus, time, destination,number,via;
        private ImageView profileMain;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            bus = (TextView) itemView.findViewById(R.id.bus);
            time = (TextView) itemView.findViewById(R.id.time);

            via = (TextView) itemView.findViewById(R.id.via);
            number= (TextView) itemView.findViewById(R.id.number);
            cardView= (CardView) itemView.findViewById(R.id.card_view);
            //itemView.setOnClickListener(this);
            //cardView.setOnClickListener(this);
        }


    }
}

