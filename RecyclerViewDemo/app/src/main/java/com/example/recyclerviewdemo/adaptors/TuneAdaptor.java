package com.example.recyclerviewdemo.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.model.Tune;

import java.util.List;

public class TuneAdaptor extends RecyclerView.Adapter<TuneAdaptor.TuneViewHolder> {
    List<Tune> adapterTuneList;

    int SelectedInd = -1;


    public TuneAdaptor(List<Tune> adapterTuneList) {
        this.adapterTuneList = adapterTuneList;
    }

    @NonNull
    @Override
    public TuneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflatebinding
        // and specify what the parent is and whether attach to root
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        LayoutTuneitemBinding binding = LayoutTuneitemBinding.inflate(inflater, parent, false);


        // uiding binding object and binding.getrroot()
        // create TuneViewHolder object
        TuneViewHolder tuneViewHolder = new TuneViewHolder(binding.getroot(), binding);

        //return tune view holder object
        //was created

        return tuneViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TuneViewHolder holder, int position) {
        //given position in the data, populate holder with that data
        holder.holderBinding.imgView2Tune.setImageResource(adapterTuneList.get(position).getTunePic());

        holder.holderBinding.txtView2Tune.setText(adapterTuneList.get(position).getTuneName());

        if (position == SelectedInd){
            holder.holderBinding.imgViewPlayPause
        }
    }

    @Override
    public int getItemCount() {
        return adapterTuneList.size();
    }

    public class TuneViewHolder extends RecyclerView.ViewHolder{
        LayoutTuneitemBinding holderBinding;
        public TuneViewHolder(@NonNull View itemView){
            super(itemView);
            this.holderBinding = holderBinding;
        }
    }
}
