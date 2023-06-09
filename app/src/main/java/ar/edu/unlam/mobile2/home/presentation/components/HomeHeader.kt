package ar.edu.unlam.mobile2.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.R

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth().height(90.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logomovie),
            contentDescription = stringResource(R.string.emovie)
        )
        // TODO: The Logo from FIGMA couldn't be exported.
    }
}
