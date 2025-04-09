package com.andanas.wealthy.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andanas.design.components.TextComponent
import com.andanas.design.ui.theme.primaryColor
import com.andanas.design.ui.theme.whiteColor
import com.andanas.wealthy.domain.model.Coin

@Composable
fun CoinListItem(coin: Coin) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(106.dp)
            .padding(top = 18.dp, start = 18.dp, end = 18.dp)
            .border(1.dp, primaryColor, RoundedCornerShape(10.dp)),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(whiteColor)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextComponent(
                modifier = Modifier.weight(8f),
                textValue = "${coin.rank} ${coin.name} ${coin.symbol}}",
                fontSizeValue = 18.sp
            )
            TextComponent(
                modifier = Modifier.wrapContentSize(),
                textValue = if (coin.isActive) "active" else "inactive",
                textColorValue = if (coin.isActive) Color.Green else Color.Gray
            )
        }
    }
}