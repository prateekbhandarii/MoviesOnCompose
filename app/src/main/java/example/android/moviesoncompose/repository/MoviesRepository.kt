package example.android.moviesoncompose.repository

import example.android.moviesoncompose.data.Movie
import example.android.moviesoncompose.network.MoviesService
import example.android.moviesoncompose.network.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

interface MoviesRepository {

    suspend fun getTopRatedMovies(): Flow<Result<List<Movie>>>
}

class MoviesRepositoryImpl(
    private val service: MoviesService
) : MoviesRepository {

    override suspend fun getTopRatedMovies(): Flow<Result<List<Movie>>> {
        return flow {
            val topRatedMovies = try {
                service.getTopRatedMovies()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading movies"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Network error"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading movies"))
                return@flow
            }

            emit(Result.Success(topRatedMovies.results))
        }
    }
}