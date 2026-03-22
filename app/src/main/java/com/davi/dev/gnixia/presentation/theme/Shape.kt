package com.davi.dev.gnixia.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * Gnixia shape tokens.
 *
 * The "No-Line" rule means shapes do all the visual heavy-lifting for
 * separating content regions.  Favour large radii on a small circular screen.
 */
object GnixiaShapes {
    /** 0.5 rem ≈ 8 dp – directional corner (bottom-right of user chat bubble) */
    val Small: Shape = RoundedCornerShape(8.dp)

    /** 1.0 rem ≈ 16 dp – default chat bubble / card radius */
    val Default: Shape = RoundedCornerShape(16.dp)

    /** 1.5 rem ≈ 24 dp – elevated cards */
    val Large: Shape = RoundedCornerShape(24.dp)

    /** 9999 dp – pill; used for primary buttons and input fields */
    val Full: Shape = RoundedCornerShape(9999.dp)

    /**
     * Asymmetric shape for the *user* chat bubble:
     * - Default (16 dp) on top-left, top-right, bottom-left
     * - Small  ( 8 dp) on bottom-right → indicates message origin/direction
     */
    val UserBubble: Shape = RoundedCornerShape(
        topStart = 16.dp,
        topEnd = 16.dp,
        bottomStart = 16.dp,
        bottomEnd = 8.dp,
    )

    /**
     * Asymmetric shape for the *AI* chat bubble:
     * - Default (16 dp) on top-right, bottom-left, bottom-right
     * - Small  ( 8 dp) on top-left → indicates incoming direction
     */
    val AiBubble: Shape = RoundedCornerShape(
        topStart = 8.dp,
        topEnd = 16.dp,
        bottomStart = 16.dp,
        bottomEnd = 16.dp,
    )
}