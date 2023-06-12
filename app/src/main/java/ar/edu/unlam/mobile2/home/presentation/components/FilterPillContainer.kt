package ar.edu.unlam.mobile2.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.core.domain.model.FilterType
import ar.edu.unlam.mobile2.home.presentation.components.FilterPill

@Composable
fun FilterPillContainer(
    filters: List<FilterType>,
    selectedFilter: FilterType,
    modifier: Modifier = Modifier,
    onFilterClick: (FilterType) -> Unit
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filters) {
            FilterPill(type = it, isSelected = selectedFilter == it) {
                onFilterClick(it)
            }
        }
    }
}
