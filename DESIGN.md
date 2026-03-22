# Design System Document: The Kinetic Intelligence Interface

## 1. Overview & Creative North Star: "The Ethereal Pulse"
The Creative North Star for this design system is **The Ethereal Pulse**. 

In the constrained, circular environment of Wear OS, we move away from static, boxy layouts. Instead, we treat the AI interface as a living, breathing entity. The design system rejects "template" aesthetics by prioritizing high-contrast editorial typography and fluid, organic depth. We leverage the pure OLED black not just for battery efficiency, but as an infinite void where information floats, layered through "glass" surfaces and soft, electric glows. 

The goal is an interface that feels less like a tool and more like an extension of the user’s own cognition—sharp, instantaneous, and premium.

---

## 2. Colors: High-Voltage Contrast
We utilize a palette that mimics the high-end look of a premium laboratory instrument. 

### The Palette
*   **Background:** `#131313` (Core Surface) / `#000000` (True Black for OLED optimization).
*   **Primary:** `primary: #adc6ff` (Soft Electric Blue).
*   **Primary Container:** `primary_container: #4b8eff` (High-Energy Blue for CTAs).
*   **Secondary:** `secondary: #46eaed` (Teal Accent for AI Status).
*   **Neutral Tiers:** `surface_container_lowest: #0e0e0e` to `surface_container_highest: #353535`.

### Key Directives
*   **The "No-Line" Rule:** 1px solid borders are strictly prohibited. Sectioning must be achieved through tonal shifts. For example, a chat bubble using `surface_container_low` sits directly on a `surface` background.
*   **Surface Hierarchy & Nesting:** On a watch face, depth is everything. Use `surface_container_low` for the main list background and `surface_container_high` for individual interactive cards to create a "lifted" effect.
*   **The Glass & Gradient Rule:** For the "AI is thinking" state, use a linear gradient from `primary` to `secondary` with a 20% opacity. Apply a `backdrop-blur` to create a "frosted glass" look that feels sophisticated and lightweight.
*   **Signature Textures:** Main Action Buttons (CTAs) should use a subtle vertical gradient from `primary_container` to `primary` to give the component "soul" and a tactile, convex feel on a small screen.

---

## 3. Typography: Editorial Clarity
We use **Inter** to provide a modern, neutral, and highly legible experience on small circular displays.

*   **Display-SM (2.25rem):** Used for single-word AI confirmations or large numeric data.
*   **Title-LG (1.375rem):** The primary heading for chat titles or settings categories.
*   **Body-MD (0.875rem):** The workhorse for AI chat responses. We prioritize line height (1.4x) to ensure readability during movement.
*   **Label-SM (0.6875rem):** Used for timestamps and micro-metadata.

**Editorial Hierarchy:** To break the "standard" look, use `Label-SM` in all-caps with 0.05rem letter spacing for category headers, paired immediately with `Headline-SM` for the content. This contrast between micro-labels and bold headlines creates an authoritative, magazine-like structure on a 40mm screen.

---

## 4. Elevation & Depth: Tonal Layering
Traditional shadows are often lost on small OLED screens. We use light, not shadow, to define space.

*   **The Layering Principle:** Stack `surface_container_lowest` (#0e0e0e) as the base. Floating chat bubbles or buttons use `surface_container_high` (#2a2a2a). The contrast ratio between these two provides enough "visual pop" without needing heavy outlines.
*   **Ambient Glows:** Instead of drop shadows, use a 4px outer glow using `primary` at 10% opacity for the active "AI Microphone" button. This mimics natural light emission.
*   **The "Ghost Border" Fallback:** If high-density information requires separation, use `outline_variant` (#414755) at **15% opacity**. It should be felt, not seen.
*   **Glassmorphism:** Overlays (like volume or scroll indicators) must use a semi-transparent `surface_bright` with a heavy blur. This prevents the UI from feeling "clipped" by the circular screen edges.

---

## 5. Components: Fluid Primitives

### Buttons
*   **Primary:** Large, `rounded-full` (9999px). Uses `primary_container` background with `on_primary_container` text.
*   **Tertiary/Ghost:** No background. Use `primary` text color. High-contrast typography drives the interaction here.

### Chat Cards & Lists
*   **Forbid Dividers:** Never use a horizontal line to separate chat messages. 
*   **Vertical Rhythm:** Use `Spacing-4` (0.9rem) between different speakers and `Spacing-1` (0.2rem) between consecutive messages from the same speaker.
*   **Asymmetry:** User messages are `surface_container_low` with a `DEFAULT` (1rem) corner radius, but the bottom-right corner is `sm` (0.5rem) to indicate directionality/origin.

### AI Pulse (Signature Component)
*   A custom circular component using a `secondary` to `primary` gradient. It should gently expand and contract (scale 1.0 to 1.05) using a sine-wave easing to indicate the AI is processing.

### Input Fields
*   Minimalist "pill" shape. Background: `surface_container_highest`. Text: `on_surface_variant`. No border.

---

## 6. Do’s and Don’ts

### Do:
*   **Do** use the Spacing Scale religiously. Consistent 0.9rem (Spacing-4) margins on the left/right of the circular screen prevent "text clipping."
*   **Do** use `primary_fixed_dim` for icons to ensure they don't vibrate against the pure black background.
*   **Do** embrace the curve. Align text center-heavy for short snippets, but left-align for long AI responses to maintain a strong "ragged right" editorial look.

### Don’t:
*   **Don’t** use pure white (#FFFFFF) for body text; use `on_surface` (#e2e2e2) to reduce eye strain and "blooming" on OLED.
*   **Don’t** use standard Material 3 shadows. They look muddy on small screens. Stick to tonal layering.
*   **Don’t** crowd the interface. If a screen has more than three interactive elements, move the secondary actions to a vertical scroll or a "More" (...) overflow.