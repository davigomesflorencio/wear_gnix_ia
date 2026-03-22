package com.davi.dev.gnixia.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import com.davi.dev.gnixia.presentation.theme.GnixiaShapes
import com.davi.dev.gnixia.presentation.theme.GnixiaSpacing
import com.davi.dev.gnixia.presentation.theme.GnixiaTheme
import com.davi.dev.gnixia.presentation.theme.OnPrimaryContainer
import com.davi.dev.gnixia.presentation.theme.Primary
import com.davi.dev.gnixia.presentation.theme.PrimaryContainer

/**
 * Primary CTA button – rounded-full pill with a vertical gradient from
 * [PrimaryContainer] (top) to [Primary] (bottom) that gives the component
 * a tactile, convex feel on a small screen.
 */
@Composable
fun GnixiaPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(PrimaryContainer, Primary),
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(48.dp)
            .clip(GnixiaShapes.Full)
            .background(if (enabled) gradient else Brush.verticalGradient(listOf(Color(0xFF2A2A2A), Color(0xFF222222))))
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = GnixiaSpacing.ButtonPadding),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = if (enabled) OnPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

/**
 * Ghost / tertiary button – no background, uses [Primary] text color.
 * High-contrast typography drives the interaction on small displays.
 */
@Composable
fun GnixiaGhostButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(48.dp)
            .clip(GnixiaShapes.Full)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = GnixiaSpacing.ButtonPadding),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = if (enabled) Primary else MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

// ─── Previews ─────────────────────────────────────────────────────────────────

@Preview(widthDp = 200, heightDp = 120, backgroundColor = 0xFF131313, showBackground = true)
@Composable
private fun ButtonsPreview() {
    GnixiaTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(GnixiaSpacing.ScreenHorizontalPadding),
        ) {
            androidx.compose.foundation.layout.Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp),
            ) {
                GnixiaPrimaryButton(
                    text = "Ask AI",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                )
                GnixiaGhostButton(
                    text = "Cancel",
                    onClick = {},
                )
            }
        }
    }
}