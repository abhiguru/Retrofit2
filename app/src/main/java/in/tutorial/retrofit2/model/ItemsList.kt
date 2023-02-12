package `in`.tutorial.retrofit2.model

data class ItemsList(
    val current_page: Int,
    val next: Boolean,
    val pages_count: Int,
    val results: List<Result>,
    val status: String,
    val type: String
)

data class Result(
    val active: Boolean,
    val description: String,
    val id: String,
    val name: String,
    val packaging: String
)