package com.davi.dev.gnixia.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import com.davi.dev.gnixia.presentation.theme.GnixiaShapes
import com.davi.dev.gnixia.presentation.theme.GnixiaSpacing
import com.davi.dev.gnixia.presentation.theme.GnixiaTheme
import com.davi.dev.gnixia.presentation.theme.OnSurface
import com.davi.dev.gnixia.presentation.theme.OnSurfaceVariant
import com.davi.dev.gnixia.presentation.theme.SurfaceContainerHighest

/**
 * Minimalist pill-shaped text input field.
 *
 * Design directives applied:
 * - Shape   : [GnixiaShapes.Full] (9999 dp) – pill.
 * - Fill    : [SurfaceContainerHighest] – no border (No-Line Rule).
 * - Text    : [OnSurface] for entered text; [OnSurfaceVariant] for hint.
 * - Cursor  : [OnSurface] to stay visible against the dark fill.
 *
 * @param value Current text value.
 * @param onValueChange Called on every keystroke.
 * @param placeholder Hint text shown when [value] is empty.
 * @param onDone Optional callback invoked when the user confirms input (IME Done).
 */
@Composable
fun GnixiaInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Message…",
    onDone: (() -> Unit)? = null,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium.copy(color = OnSurface),
        cursorBrush = SolidColor(OnSurface),
        keyboardOptions = KeyboardOptions(imeAction = if (onDone != null) ImeAction.Done else ImeAction.Default),
        keyboardActions = KeyboardActions(onDone = { onDone?.invoke() }),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = modifier
                    .height(40.dp)
                    .clip(GnixiaShapes.Full)
                    .background(SurfaceContainerHighest)
                    .padding(horizontal = GnixiaSpacing.InputPadding),
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyMedium,
                        color = OnSurfaceVariant,
                    )
                }
                innerTextField()
            }
        },
    )
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(widthDp = 200, heightDp = 80, backgroundColor = 0xFF131313, showBackground = true)
@Composable
private fun InputFieldPreview() {
    GnixiaTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(GnixiaSpacing.ScreenHorizontalPadding),
        ) {
            GnixiaInputField(
                value = "",
                onValueChange = {},
                placeholder = "Ask anything…",
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
