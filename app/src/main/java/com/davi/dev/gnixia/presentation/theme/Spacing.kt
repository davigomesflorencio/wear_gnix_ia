package com.davi.dev.gnixia.presentation.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Gnixia spacing scale.
 *
 * Spacing-4 (0.9 rem ≈ 14 dp) is the canonical left/right screen margin on
 * a circular Wear OS display – prevents text clipping at the edges.
 */
object GnixiaSpacing {
    /** 0.2 rem ≈ 3 dp – gap between consecutive messages from the same speaker */
    val Spacing1: Dp = 3.dp

    /** 0.4 rem ≈ 6 dp */
    val Spacing2: Dp = 6.dp

    /** 0.6 rem ≈ 10 dp */
    val Spacing3: Dp = 10.dp

    /** 0.9 rem ≈ 14 dp – primary horizontal screen margin; use religiously */
    val Spacing4: Dp = 14.dp

    /** 1.2 rem ≈ 19 dp */
    val Spacing5: Dp = 19.dp

    /** 1.6 rem ≈ 26 dp */
    val Spacing6: Dp = 26.dp

    /** 2.0 rem ≈ 32 dp */
    val Spacing7: Dp = 32.dp

    /** 2.4 rem ≈ 38 dp */
    val Spacing8: Dp = 38.dp

    // ── Semantic aliases ──────────────────────────────────────────────────────

    /** Left / right margin that keeps text inside the circular bezel */
    val ScreenHorizontalPadding: Dp = Spacing4

    /** Gap between messages from different speakers */
    val MessageGroupSpacing: Dp = Spacing4

    /** Gap between consecutive messages from the same speaker */
    val MessageItemSpacing: Dp = Spacing1

    /** Internal padding inside a chat bubble */
    val BubblePadding: Dp = Spacing3

    /** Internal padding for an input field */
    val InputPadding: Dp = Spacing3

    /** Internal padding for a primary button */
    val ButtonPadding: Dp = Spacing4
}