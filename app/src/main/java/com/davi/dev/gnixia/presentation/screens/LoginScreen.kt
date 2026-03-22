package com.davi.dev.gnixia.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.tooling.preview.devices.WearDevices
import com.davi.dev.gnixia.R
import com.davi.dev.gnixia.presentation.components.GnixiaPrimaryButton
import com.davi.dev.gnixia.presentation.theme.GnixiaTheme

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit
) {
    Scaffold(
        vignette = { Vignette(VignettePosition.TopAndBottom) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Gnix AI",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6A99FF)
            )

            // Lightning Bolt Icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF6A99FF)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(R.drawable.icon),
                    contentDescription = ""
                )
            }

            Text(
                text = "Your cognitive edge, powered by Gemini, right on your wrist.",
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 4.dp)
            )

            GnixiaPrimaryButton(
                text = "Login Google",
                onClick = {},
                modifier = Modifier.fillMaxWidth(.8f),
            )

            Text(
                text = "V2.4.0 HIGH-VOLTAGE",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF888888)
            )

            // Page Indicator
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Canvas(modifier = Modifier.size(8.dp)) {
                    drawCircle(color = Color(0xFF6A99FF), radius = 4.dp.toPx())
                }
                Spacer(modifier = Modifier.width(4.dp))
                Canvas(modifier = Modifier.size(8.dp)) {
                    drawCircle(color = Color(0xFF888888), radius = 4.dp.toPx(), style = Stroke(width = 1.dp.toPx()))
                }
            }
        }
    }
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    GnixiaTheme {
        LoginScreen(onLoginClick = {})
    }
}
