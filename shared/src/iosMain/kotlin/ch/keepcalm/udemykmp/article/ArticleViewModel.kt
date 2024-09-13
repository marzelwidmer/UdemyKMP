package ch.keepcalm.udemykmp.article

import ch.keepcalm.udemykmp.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class ArticleViewModel() : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState())

    val articleState: StateFlow<ArticleState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(500)
            _articlesState.emit(ArticleState())
        }
    }

}