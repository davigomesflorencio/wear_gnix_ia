package com.davi.dev.gnixia.presentation.theme

import androidx.compose.ui.graphics.Color

// ─── Backgrounds ────────────────────────────────────────────────────────────
val Background = Color(0xFF131313)
val TrueBlack = Color(0xFF000000)

// ─── Primary ─────────────────────────────────────────────────────────────────
val Primary = Color(0xFFADC6FF)          // Soft Electric Blue
val PrimaryDim = Color(0xFF8AABFF)       // primary_fixed_dim – safe for icons on OLED
val PrimaryContainer = Color(0xFF4B8EFF) // High-Energy Blue for CTAs
val OnPrimary = Color(0xFF00154F)
val OnPrimaryContainer = Color(0xFFE8EDFF)

// ─── Secondary ───────────────────────────────────────────────────────────────
val Secondary = Color(0xFF46EAED)        // Teal Accent – AI status
val SecondaryDim = Color(0xFF28C8CB)
val SecondaryContainer = Color(0xFF004F52)
val OnSecondary = Color(0xFF003739)
val OnSecondaryContainer = Color(0xFFB4FEFF)

// ─── Surface Hierarchy (tonal layering, no shadows) ─────────────────────────
val SurfaceContainerLowest = Color(0xFF0E0E0E)  // base layer
val SurfaceContainerLow = Color(0xFF1A1A1A)     // chat message backgrounds
val Surface = Color(0xFF1E1E1E)
val SurfaceContainer = Color(0xFF222222)
val SurfaceContainerHigh = Color(0xFF2A2A2A)    // "lifted" interactive cards
val SurfaceContainerHighest = Color(0xFF353535) // input fields

val SurfaceBright = Color(0xFF363636)           // glassmorphism overlay base

// ─── On-Surface ──────────────────────────────────────────────────────────────
val OnSurface = Color(0xFFE2E2E2)         // never pure white – reduces OLED bloom
val OnSurfaceVariant = Color(0xFFB0B0B0)  // secondary text, placeholder

// ─── Outline ─────────────────────────────────────────────────────────────────
val Outline = Color(0xFF6B7280)
val OutlineVariant = Color(0xFF414755)    // "ghost border" – use at 15 % opacity max

// ─── Error ───────────────────────────────────────────────────────────────────
val Error = Color(0xFFFF8A80)
val OnError = Color(0xFF690005)
val ErrorContainer = Color(0xFF93000A)
val OnErrorContainer = Color(0xFFFFDAD6)

// ─── Tertiary ────────────────────────────────────────────────────────────────
val Tertiary = Color(0xFFD4B8FF)
val TertiaryDim = Color(0xFFB89EE8)
val TertiaryContainer = Color(0xFF4A3370)
val OnTertiary = Color(0xFF261047)
val OnTertiaryContainer = Color(0xFFEFDBFF)

// ─── Semantic aliases (use these in components) ───────────────────────────────
val GlassOverlay = SurfaceBright.copy(alpha = 0.72f)
val AiThinkingGradientStart = Primary.copy(alpha = 0.20f)
val AiThinkingGradientEnd = Secondary.copy(alpha = 0.20f)
val MicrophoneGlow = Primary.copy(alpha = 0.10f)
val GhostBorder = OutlineVariant.copy(alpha = 0.15f)