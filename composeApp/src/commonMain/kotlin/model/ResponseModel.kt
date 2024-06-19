package model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseModel(
    val data: List<Data>,
    val count: Long,
)
