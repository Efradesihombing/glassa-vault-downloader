package com.glassa.vaultdownloader.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun GlassNavigationBar(
    selectedIndex: Int,
    items: List<NavItem>,
    onSelected: (Int) -> Unit
) {
    Box(
        modifier = Modifier
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
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                val selected = index == selectedIndex
                val width by animateDpAsState(targetValue = if (selected) 118.dp else 72.dp)

                Box(
                    modifier = Modifier
                        .width(width)
                        .height(52.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            if (selected) Brush.linearGradient(
                                listOf(
                                    Color(0xFF2A405E),
                                    Color(0xFF1A2B42),
                                    Color(0xFF15263D)
                                )
                            ) else Brush.linearGradient(
                                listOf(
                                    Color.Transparent,
                                    Color.Transparent
                                )
                            )
                        )
                        .clickableWithNoRipple {
                            onSelected(index)
                        }
                        .padding(horizontal = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            tint = if (selected) Color(0xFFEAF6FF) else Color(0xFF9DBDE9)
                        )
                        if (selected) {
                            Text(
                                text = item.label,
                                style = MaterialTheme.typography.labelLarge,
                                color = Color(0xFFEAF6FF)
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

private fun Modifier.clickableWithNoRipple(onClick: () -> Unit): Modifier = this.then(
    androidx.compose.foundation.clickable(onClick = onClick)
)
