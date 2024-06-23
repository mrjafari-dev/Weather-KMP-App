package model
import kotlinx.serialization.Serializable

@Serializable
data class RequestModel(
    var country :String,
    var city :String

)
