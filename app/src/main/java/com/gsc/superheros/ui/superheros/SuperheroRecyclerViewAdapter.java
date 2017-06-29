package com.gsc.superheros.ui.superheros;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsc.superheros.R;
import com.gsc.superheros.model.Superhero;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


class SuperheroRecyclerViewAdapter extends RecyclerView.Adapter<SuperheroRecyclerViewAdapter.ViewHolder> {

    private List<Superhero> superheros;

    public SuperheroRecyclerViewAdapter(List<Superhero> superheros) {
        this.superheros = superheros;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_superhero, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Superhero superhero = superheros.get(position);
        Picasso.with(holder.image.getContext()).load(superhero.getPhoto()).into(holder.image);
        holder.name.setText(superhero.getName());
    }

    @Override
    public int getItemCount() {
        return superheros.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.superhero_image)
        ImageView image;
        @BindView(R.id.superhero_name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
