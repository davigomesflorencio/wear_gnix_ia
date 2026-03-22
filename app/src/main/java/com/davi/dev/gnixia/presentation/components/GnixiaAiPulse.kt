package com.davi.dev.gnixia.presentation.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.davi.dev.gnixia.presentation.theme.GnixiaTheme
import com.davi.dev.gnixia.presentation.theme.Primary
import com.davi.dev.gnixia.presentation.theme.Secondary

/**
 * Signature "AI is processing" component – The Ethereal Pulse.
 *
 * A circular element filled with a [Secondary] → [Primary] radial gradient
 * that gently expands and contracts (scale 1.0 → 1.05) using a sine-wave
 * easing to signal that the AI is thinking.
 *
 * @param size Diameter of the pulse circle. Default 48 dp suits most Wear OS screens.
 * @param active When false the animation stops at rest scale (1.0).
 */
@Composable
fun GnixiaAiPulse(
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    active: Boolean = true,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "ai_pulse")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1.0f,
        targetValue = if (active) 1.05f else 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1_200,
                easing = FastOutSlowInEasing, // approximates sine-wave easing
            ),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "pulse_scale",
    )

    val gradient = Brush.radialGradient(
        colors = listOf(Secondary, Primary),
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .scale(scale)
            .clip(CircleShape)
            .background(gradient),
    ){}
}

/**
 * Microphone / voice-input button variant of the pulse.
 *
 * Applies a 4 dp ambient outer glow using [Primary] at 10 % opacity to mimic
 * natural light emission, consistent with the Elevation & Depth directives.
 *
 * Note: true outer glow requires a [androidx.compose.ui.graphics.Paint] shadow
 * layer – here we layer a slightly larger, low-opacity circle behind the main
 * circle to achieve the same visual effect within Compose's model.
 */
@Composable
fun GnixiaMicButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 52.dp,
    active: Boolean = false,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        // Ambient glow layer (Primary @ 10 %)
        Box(
            modifier = Modifier
                .size(size + 8.dp)
                .clip(CircleShape)
                .background(Primary.copy(alpha = 0.10f)),
        )

        // Pulse body
        GnixiaAiPulse(
            size = size,
            active = active,
            modifier = Modifier
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(listOf(Secondary, Primary)),
                ),
        )
    }
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(widthDp = 200, heightDp = 200, backgroundColor = 0xFF131313, showBackground = true)
@Composable
private fun AiPulsePreview() {
    GnixiaTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(200.dp),
        ) {
            GnixiaAiPulse(active = true)
        }
    }
}