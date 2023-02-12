package `in`.tutorial.retrofit2.model

data class Item(
    val details: Details,
    val status: String,
    val type: String
)

data class Details(
    val active: Boolean,
    val description: String,
    val id: String,
    val name: String,
    val packaging: String
)