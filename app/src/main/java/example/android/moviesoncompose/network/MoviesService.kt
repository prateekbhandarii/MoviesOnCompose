package example.android.moviesoncompose.network

import example.android.moviesoncompose.data.Data
import retrofit2.http.GET

interface MoviesService {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/movie/"
        const val API_KEY = "AIzaSyBcXktZ49YjclMPVwLIK9Q1a7-MRvAO3PE"
    }

    @GET("/top_rated")
    suspend fun getTopRatedMovies(): Data
}