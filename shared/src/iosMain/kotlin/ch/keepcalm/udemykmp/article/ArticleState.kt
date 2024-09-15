package ch.keepcalm.udemykmp.article

data class ArticleState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)