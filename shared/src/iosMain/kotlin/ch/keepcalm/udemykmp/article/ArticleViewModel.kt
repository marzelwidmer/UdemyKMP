package ch.keepcalm.udemykmp.article

import ch.keepcalm.udemykmp.BaseViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow


class ArticleViewModel() : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState())

    val articleState: StateFlow<ArticleState> get() = _articlesState

}