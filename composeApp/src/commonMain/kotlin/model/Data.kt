package model

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val wind_cdir: String,
    val rh: Long,
    val pod: String,
    val lon: Double,
    val pres: Double,
    val timezone: String,
    val ob_time: String,
    val country_code: String,
    val clouds: Long,
    val ts: Long,
    val solar_rad: Float,
    val state_code: String,
    val city_name: String,
    val wind_spd: Float,
    val slp: Float,
    val wind_cdir_full: String,
    val sunrise: String,
    val app_temp: Float,
    val dni: Double,
    val vis: Float,
    val sources: List<String>,
    val h_angle: Float,
    val dewpt: Double,
    val aqi: Long,
    val dhi: Float,
    val wind_dir: Long,
    val elev_angle: Double,
    val ghi: Float,
    val sunset: String,
    val lat: Float,
    val uv: Float,
    val datetime: String,
    val temp: Float,
    val weather: Weather,
    val station: String
)
