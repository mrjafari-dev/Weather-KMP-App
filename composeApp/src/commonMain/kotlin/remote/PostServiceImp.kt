package remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import model.RequestModel
import kotlinx.serialization.json.Json
import model.WeatherResponse

class PostServiceImp(private var client: HttpClient) : PostService {
    override suspend fun getPosts(requestModel: RequestModel, onSuccess: (WeatherResponse) -> Unit, onFail: (String) -> Unit) {
        try {
            val response = client.post(ApiRouts.CityDetails) {
                FormDataContent(Parameters.build {
                    parameter("key", "dacb861900974263ad863809242306")
                    parameter("q", requestModel.city)
                })
            }

            if (response.status.isSuccess()) {
                val responseBody: String = response.bodyAsText()
                println("Success: $responseBody")

                val json = Json { ignoreUnknownKeys = true }
                val jsonToModel = json.decodeFromString<WeatherResponse>(responseBody)

                onSuccess(jsonToModel)
            } else {
                println("WRONG")
                onFail("wrong in parameters")
            }
        } catch (e: Exception) {
            onFail(e.message.toString())
            println("WRONG CATCH ${e.message.toString()}")
        }


    }


}