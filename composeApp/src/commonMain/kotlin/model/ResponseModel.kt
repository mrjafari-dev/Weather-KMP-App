package model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseModel(
    val count: Int,
    val data: List<Data>,
)
