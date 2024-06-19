package remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import model.RequestModel
import model.ResponseModel

class PostServiceImp(private val client: HttpClient) : PostService {
    override suspend fun getPosts(requestModel: RequestModel): HttpResponse {
        return client.post(ApiRouts.CityDetails){
            FormDataContent(Parameters.build {
                parameter("key", "f24c70ecf7e740b0b51ebf6ff3097ec6")
                parameter("country", requestModel.country)
                parameter("city", requestModel.city)
            })
        }
    }

}