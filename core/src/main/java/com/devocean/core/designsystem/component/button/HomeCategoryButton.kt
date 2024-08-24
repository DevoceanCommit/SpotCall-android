package com.devocean.core.designsystem.component.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.devocean.core.util.NoRippleTheme

@Composable
fun HomeCategoryButton(
    paddingVertical: Dp,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    text: Int,
    textColor: Color = Color.White
) {
    val interactionSource = remember { MutableInteractionSource() }

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Button(
            contentPadding = PaddingValues(paddingVertical),
            interactionSource = interactionSource,
            enabled = isEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF9623E),
                contentColor = Color.Black
            ),
            shape = CircleShape,
            onClick = { onButtonClick() }
        ) {
            Text(
                text = stringResource(id = text),
                color = textColor
            )
        }
    }
}