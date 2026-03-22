package com.davi.dev.gnixia.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import com.davi.dev.gnixia.presentation.theme.GnixiaShapes
import com.davi.dev.gnixia.presentation.theme.GnixiaSpacing
import com.davi.dev.gnixia.presentation.theme.GnixiaTheme
import com.davi.dev.gnixia.presentation.theme.SurfaceContainerHigh
import com.davi.dev.gnixia.presentation.theme.SurfaceContainerLow

/**
 * Chat bubble for the **user's** messages.
 *
 * Rules applied:
 * - Background: [SurfaceContainerLow] on [Surface] – tonal lift, no border.
 * - Asymmetric shape: default radius everywhere except bottom-right which is
 *   [GnixiaShapes.Small] (8 dp) to indicate message origin/direction.
 * - Text left-aligned for longer content (editorial "ragged right" look).
 * - No horizontal dividers between consecutive bubbles.
 */
@Composable
fun UserChatBubble(
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(GnixiaShapes.UserBubble)
            .background(SurfaceContainerLow)
            .padding(GnixiaSpacing.BubblePadding),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Start,
        )
    }
}

/**
 * Chat bubble for **AI** messages.
 *
 * Rules applied:
 * - Background: [SurfaceContainerHigh] – slightly "lifted" vs [SurfaceContainerLow],
 *   creating tonal depth without any border (No-Line Rule).
 * - Asymmetric shape: top-left corner is [GnixiaShapes.Small] (8 dp) to
 *   indicate incoming direction.
 * - Text left-aligned for readability during movement.
 */
@Composable
fun AiChatBubble(
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(GnixiaShapes.AiBubble)
            .background(SurfaceContainerHigh)
            .padding(GnixiaSpacing.BubblePadding),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Start,
        )
    }
}

/**
 * Timestamp / micro-metadata label.
 * Rendered in all-caps with tracking (0.05 em) per the editorial hierarchy.
 */
@Composable
fun ChatTimestamp(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text.uppercase(),
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier,
    )
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(widthDp = 200, heightDp = 200, backgroundColor = 0xFF1E1E1E, showBackground = true)
@Composable
private fun ChatBubblesPreview() {
    GnixiaTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = GnixiaSpacing.ScreenHorizontalPadding),
            verticalArrangement = Arrangement.spacedBy(GnixiaSpacing.MessageGroupSpacing),
        ) {
            // AI message group
            AiChatBubble(
                text = "How can I help you today?",
                modifier = Modifier.align(Alignment.Start),
            )

            // User message group (two consecutive – small gap between them)
            Column(
                modifier = Modifier.align(Alignment.End),
                verticalArrangement = Arrangement.spacedBy(GnixiaSpacing.MessageItemSpacing),
            ) {
                UserChatBubble(text = "What's the weather?")
                UserChatBubble(text = "In São Paulo.")
            }

            ChatTimestamp(
                text = "12:04 pm",
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
        }
    }
}