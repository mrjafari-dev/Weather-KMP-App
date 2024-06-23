package remote

import io.ktor.client.*
import io.ktor.client.statement.*
import io.ktor.http.*
import model.RequestModel
import model.WeatherResponse

interface PostService {
    suspend fun getPosts(requestModel: RequestModel , onSuccess:(WeatherResponse)->Unit, onFail:(String)->Unit)
}