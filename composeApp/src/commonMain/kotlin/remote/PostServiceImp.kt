package remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import model.RequestModel
import model.ResponseModel
import kotlinx.serialization.json.Json

class PostServiceImp(private var client: HttpClient) : PostService {
    override suspend fun getPosts(requestModel: RequestModel, onSuccess: (ResponseModel) -> Unit, onFail: (String) -> Unit) {
        try {
            val response = client.post(ApiRouts.CityDetails){
                FormDataContent(Parameters.build {
                    parameter("key", "f24c70ecf7e740b0b51ebf6ff3097ec6os")
                    parameter("country", requestModel.country)
                    parameter("city", requestModel.city)
                })
            }
            if (response.status.isSuccess()){
                println("Success".plus(response.body<ResponseModel>().toString()) )
                val json = Json { ignoreUnknownKeys = true }
                val jsonToModel  = json.decodeFromString<ResponseModel>(response.body())
                onSuccess(jsonToModel)
            }else{
                onFail("wrong in parameters")
            }
        }catch (e:Exception){
            onFail(e.message.toString())
        }


    }


}