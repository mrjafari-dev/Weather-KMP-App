package model
import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    val icon: String,
    val code: Long,
    val description: String
)
