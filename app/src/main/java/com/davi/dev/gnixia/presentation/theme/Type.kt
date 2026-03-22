package com.davi.dev.gnixia.presentation.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.davi.dev.gnixia.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val bodyFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Nunito"),
        fontProvider = provider,
    )
)

val displayFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Nunito"),
        fontProvider = provider,
    )
)

// Default Material 3 typography values
val baseline = androidx.wear.compose.material3.Typography()

/**
 * Gnixia type scale – editorial clarity on a 40 mm circular display.
 *
 * Scale mapping (rem → sp, base 16):
 *   Display-SM  : 2.2500 rem → 36 sp  – single-word AI confirmations / large numbers
 *   Title-LG    : 1.3750 rem → 22 sp  – chat titles, settings categories
 *   Body-MD     : 0.8750 rem → 14 sp  – AI responses; line-height 1.4 × (20 sp)
 *   Label-SM    : 0.6875 rem → 11 sp  – timestamps, micro-metadata; ALL CAPS + 0.05 em tracking
 */
val GnixiaTypography = androidx.wear.compose.material3.Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
)