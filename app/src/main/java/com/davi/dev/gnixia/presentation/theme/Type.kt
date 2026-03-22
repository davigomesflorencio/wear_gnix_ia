package com.davi.dev.gnixia.presentation.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.Typography

// Font: Inter (add res/font/inter_*.ttf and replace FontFamily.SansSerif below)
// e.g.: val Inter = FontFamily(Font(R.font.inter_regular), Font(R.font.inter_bold, FontWeight.Bold))
private val Inter = FontFamily.SansSerif

/**
 * Gnixia type scale – editorial clarity on a 40 mm circular display.
 *
 * Scale mapping (rem → sp, base 16):
 *   Display-SM  : 2.2500 rem → 36 sp  – single-word AI confirmations / large numbers
 *   Title-LG    : 1.3750 rem → 22 sp  – chat titles, settings categories
 *   Body-MD     : 0.8750 rem → 14 sp  – AI responses; line-height 1.4 × (20 sp)
 *   Label-SM    : 0.6875 rem → 11 sp  – timestamps, micro-metadata; ALL CAPS + 0.05 em tracking
 */
val GnixiaTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        letterSpacing = (-0.02).em,
    ),
    displayMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        letterSpacing = (-0.02).em,
    ),
    // Display-SM – AI confirmations, large numerics
    displaySmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        letterSpacing = (-0.01).em,
    ),
    // Title-LG – chat titles, settings categories
    titleLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        letterSpacing = (-0.005).em,
    ),
    titleMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        letterSpacing = 0.em,
    ),
    titleSmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.em,
    ),
    // Body-MD – AI responses (line-height 1.4 × = 20 sp)
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 22.4.sp,
        letterSpacing = 0.em,
    ),
    bodyMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 19.6.sp, // 14 × 1.4
        letterSpacing = 0.em,
    ),
    bodySmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.8.sp,
        letterSpacing = 0.em,
    ),
    labelLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        letterSpacing = 0.05.em,
    ),
    labelMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.05.em,
    ),
    // Label-SM – timestamps, meta; use with .uppercase() in composables
    labelSmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        letterSpacing = 0.05.em,
    ),
)