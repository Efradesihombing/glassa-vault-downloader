package com.glassa.vaultdownloader.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GlassNavigationBar(
    selectedIndex: Int,
    items: List<NavItem>,
    onSelected: (Int) -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 16.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0x66121F35),
                        Color(0x66131A2E),
                        Color(0x66132137)
                    )
                )
            )
            .padding(8.dp)
    ) {
        val slotWidth: Dp = maxWidth / items.size
        val indicatorWidth = slotWidth - 8.dp
        val indicatorInset = 4.dp

        val animatedOffset by animateDpAsState(
            targetValue = (selectedIndex * slotWidth) + indicatorInset,
            animationSpec = tween(durationMillis = 220),
            label = "nav-indicator-offset"
        )

        Box(
            modifier = Modifier
                .offset(x = animatedOffset)
                .width(indicatorWidth)
                .height(52.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    Brush.linearGradient(
                        listOf(
                            Color(0xFF2A405E),
                            Color(0xFF1A2B42),
                            Color(0xFF15263D)
                        )
                    )
                )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                val selected = index == selectedIndex
                val labelAlpha by animateFloatAsState(
                    targetValue = if (selected) 1f else 0f,
                    animationSpec = tween(durationMillis = 180),
                    label = "nav-label-alpha"
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable { onSelected(index) }
                        .padding(horizontal = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            tint = if (selected) Color(0xFFEAF6FF) else Color(0xFF9DBDE9)
                        )

                        Box(
                            modifier = Modifier.width(42.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item.label,
                                style = MaterialTheme.typography.labelLarge,
                                color = Color(0xFFEAF6FF),
                                modifier = Modifier.alpha(labelAlpha)
                            )
                        }
                    }
                }
            }
        }
    }
}

data class NavItem(
    val label: String,
    val icon: ImageVector
)
