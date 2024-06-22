package model
import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    val code: Int,
    val icon: String,
    val description: String
)
