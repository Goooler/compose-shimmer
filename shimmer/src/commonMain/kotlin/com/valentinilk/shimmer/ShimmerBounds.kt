package com.valentinilk.shimmer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Rect

@Composable
internal fun rememberShimmerBounds(
    shimmerBounds: ShimmerBounds,
): Rect? {
    return remember(shimmerBounds) {
        when (shimmerBounds) {
            ShimmerBounds.Window -> Rect(
                0f,
                0f,
                ScreenInfo.width.toFloat(),
                ScreenInfo.height.toFloat()
            )
            ShimmerBounds.Custom -> Rect.Zero
            ShimmerBounds.View -> null
        }
    }
}

sealed interface ShimmerBounds {
    data object Custom : ShimmerBounds
    data object View : ShimmerBounds
    data object Window : ShimmerBounds
}