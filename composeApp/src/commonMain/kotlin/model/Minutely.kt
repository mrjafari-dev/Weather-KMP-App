package model
import kotlinx.serialization.Serializable

@Serializable
data class Minutely(
    val timestamp_utc: String,
    val snow: Long,
    val temp: Double,
    val timestamp_local: String,
    val ts: Long,
    val precip: Long
)
