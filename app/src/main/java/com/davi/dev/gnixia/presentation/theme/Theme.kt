package com.davi.dev.gnixia.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.wear.compose.material3.ColorScheme
import androidx.wear.compose.material3.MaterialTheme

// ─── Composition locals for design-system extras ─────────────────────────────

val LocalGnixiaSpacing = staticCompositionLocalOf { GnixiaSpacing }
val LocalGnixiaShapes = staticCompositionLocalOf { GnixiaShapes }

// ─── Dark color scheme ────────────────────────────────────────────────────────

private val GnixiaDarkColorScheme = ColorScheme(
    primary = Primary,
    primaryDim = PrimaryDim,
    primaryContainer = PrimaryContainer,
    onPrimary = OnPrimary,
    onPrimaryContainer = OnPrimaryContainer,
    secondary = Secondary,
    secondaryDim = SecondaryDim,
    secondaryContainer = SecondaryContainer,
    onSecondary = OnSecondary,
    onSecondaryContainer = OnSecondaryContainer,
    tertiary = Tertiary,
    tertiaryDim = TertiaryDim,
    tertiaryContainer = TertiaryContainer,
    onTertiary = OnTertiary,
    onTertiaryContainer = OnTertiaryContainer,
//    surfaceDim = SurfaceContainerLowest,
//    surface = Surface,
//    surfaceBright = SurfaceBright,
    surfaceContainer = SurfaceContainer,
    surfaceContainerLow = SurfaceContainerLow,
    surfaceContainerHigh = SurfaceContainerHigh,
    onSurface = OnSurface,
    onSurfaceVariant = OnSurfaceVariant,
    outline = Outline,
    outlineVariant = OutlineVariant,
    background = Background,
    onBackground = OnSurface,
    error = Error,
    onError = OnError,
    errorContainer = ErrorContainer,
    onErrorContainer = OnErrorContainer,
)

// ─── Theme entry-point ────────────────────────────────────────────────────────

/**
 * Gnixia design system theme.
 *
 * Wraps [MaterialTheme] with the Ethereal Pulse color scheme and type scale,
 * and provides [GnixiaSpacing] / [GnixiaShapes] via composition locals.
 *
 * Usage:
 * ```
 * GnixiaTheme {
 *     YourScreen()
 * }
 * ```
 */
@Composable
fun GnixiaTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalGnixiaSpacing provides GnixiaSpacing,
        LocalGnixiaShapes provides GnixiaShapes,
    ) {
        MaterialTheme(
            colorScheme = GnixiaDarkColorScheme,
            typography = GnixiaTypography,
            content = content,
        )
    }
}

// ─── Convenience accessors (mirror MaterialTheme style) ───────────────────────

object GnixiaTheme {
    val spacing: GnixiaSpacing
        @Composable get() = LocalGnixiaSpacing.current

    val shapes: GnixiaShapes
        @Composable get() = LocalGnixiaShapes.current

    val colors: ColorScheme
        @Composable get() = MaterialTheme.colorScheme

    val typography: androidx.wear.compose.material3.Typography
        @Composable get() = MaterialTheme.typography
}