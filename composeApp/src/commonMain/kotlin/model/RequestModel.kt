package model
import kotlinx.serialization.Serializable

@Serializable
data class RequestModel(
    val country :String,
    val city :String

)
