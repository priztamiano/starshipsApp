package edu.android.starships;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.android.starships.rest.StarshipPost;

public class StarshipsListRecyclerAdapter extends RecyclerView.Adapter<StarshipsListRecyclerAdapter.StarshipViewHolder> {

        private Context context;
        private List<StarshipPost> starships;
        private OnStarShipListener onStarShipListener;

        public StarshipsListRecyclerAdapter(Context context, List<StarshipPost> starships, OnStarShipListener onStarShipListener) {
            this.context = context;
            this.starships = starships;
            this.onStarShipListener = onStarShipListener;
        }

        @Override
        public StarshipsListRecyclerAdapter.StarshipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_item_starship_recycler_view, parent,false);
            return new StarshipViewHolder(view, onStarShipListener);
        }

        @Override
        public void onBindViewHolder(StarshipsListRecyclerAdapter.StarshipViewHolder holder, int position) {
            holder.textViewName.setText(starships.get(position).getName());
            holder.textViewModel.setText(starships.get(position).getModel());
        }

        @Override
        public int getItemCount() {
            if(starships != null){
                return starships.size();
            }
            return 0;
        }

        // INNER CLASS STARSHIPVIEWHOLDER
        public class StarshipViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView textViewName;
            TextView textViewModel;
            OnStarShipListener onStarShipListener;



            public StarshipViewHolder(View itemView, OnStarShipListener onStarShipListener) {
                super(itemView);
                textViewName = (TextView)itemView.findViewById(R.id.textViewNombreItemListado);
                textViewModel = (TextView)itemView.findViewById(R.id.textViewDescripcion);
                this.onStarShipListener = onStarShipListener;
                itemView.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {
                onStarShipListener.onStarshipClick(getAdapterPosition());
            }
        }

        public interface OnStarShipListener {
            void onStarshipClick(int position);
        }

}

