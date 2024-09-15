package ch.keepcalm.udemykmp.article

import ch.keepcalm.udemykmp.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class ArticleViewModel() : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))

    val articleState: StateFlow<ArticleState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {

            val fetchedArticles = fetchArticles()

            delay(500)

            _articlesState.emit(ArticleState(articles = fetchedArticles))
        }
    }

    suspend fun fetchArticles() : List<Article> = mockArticles
/*

    suspend fun getArticlesFromApi() {
        _articlesState.emit(ArticleState(loading = true))
        delay(500)
        _articlesState.emit(ArticleState(articles = mockArticles))
    }
*/

    private val mockArticles = listOf(
        Article(
            title = "Article 1",
            desc = "Description 1",
            date = "2021-09-01",
            imageUrl = "https://picsum.photos/200/300"
        ),
        Article(
            title = "Article 2",
            desc = "Description 2",
            date = "2021-09-02",
            imageUrl = "https://picsum.photos/200/300"
        ),
        Article(
            title = "Article 3",
            desc = "Description 3",
            date = "2021-09-03",
            imageUrl = "https://picsum.photos/200/300"
        ),
    )

}