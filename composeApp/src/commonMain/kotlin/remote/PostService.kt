package remote

import io.ktor.client.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import model.RequestModel
import model.ResponseModel

interface PostService {
    suspend fun getPosts(requestModel: RequestModel) : HttpResponse
}