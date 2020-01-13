package edu.android.starships.rest;

import java.util.*;
import retrofit2.*;
import retrofit2.http.*;

public interface PostService {
    @GET ("starships/")
    Call<StarshipsPost> getStarshipsPost();

    /*
    @GET ("/starships/{id}")
    Call<Post> getPostsById(@Path("id") String id);

     */
}
