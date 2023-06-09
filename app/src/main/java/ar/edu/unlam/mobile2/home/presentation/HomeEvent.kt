package ar.edu.unlam.mobile2.home.presentation

import ar.edu.unlam.mobile2.core.domain.model.FilterType

sealed class HomeEvent {
    data class ChangeFilter(val filterType: FilterType) : HomeEvent()
}
