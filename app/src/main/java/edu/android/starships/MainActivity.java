package edu.android.starships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import edu.android.starships.rest.StarshipsPost;
import edu.android.starships.rest.StarshipPost;

import edu.android.starships.rest.PostService;
import edu.android.starships.rest.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements StarshipsListRecyclerAdapter.OnStarShipListener {

    private RecyclerView listRecyclerView;;
    private List<StarshipPost> starships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listRecyclerView = findViewById(R.id.listRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listRecyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        listRecyclerView.addItemDecoration(dividerItemDecoration);

        passStarshipsToAdapter();
        getPosts();
    }

    private void getPosts() {
        PostService postService = RetrofitClient.recuperarRetrofit().create(PostService.class);
        Call<StarshipsPost> call = postService.getStarshipsPost();
        call.enqueue(new Callback<StarshipsPost>() {
            @Override
            public void onResponse(Call<StarshipsPost> call, Response<StarshipsPost> response) {
                starships = response.body().getStarships();
                passStarshipsToAdapter();
            }

            @Override
            public void onFailure(Call<StarshipsPost> call, Throwable t) {

            }
            });
    }

    private void passStarshipsToAdapter() {
        StarshipsListRecyclerAdapter starshipsListRecyclerAdapter = new StarshipsListRecyclerAdapter(this, starships, this);
        listRecyclerView.setAdapter(starshipsListRecyclerAdapter);
    }


    @Override
    public void onStarshipClick(int position) {
        Log.d("Starship ", "onStarshipClick: clicked " + position);

        Intent intent = new Intent(this, StarshipDetailActivity.class);

        intent.putExtra("name", starships.get(position).getName());
        intent.putExtra("model", starships.get(position).getModel());
        intent.putExtra("starship_class", starships.get(position).getStarship_class());
        intent.putExtra("manufacturer", starships.get(position).getManufacturer());
        intent.putExtra("length", starships.get(position).getLength());
        intent.putExtra("crew", starships.get(position).getCrew());
        intent.putExtra("cost_in_credits", starships.get(position).getCost_in_credits());

        startActivity(intent);


    }
}

