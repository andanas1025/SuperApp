package com.andanas.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andanas.design.R
import com.andanas.design.ui.theme.primaryColor
import com.andanas.design.ui.theme.whiteColor

@Composable
fun AppToolbar(
    title: String = stringResource(R.string.add_address),
    isBackButtonVisible: Boolean = false,
    isNotificationVisible: Boolean = false
) {
    Row(
        modifier = Modifier
            .background(primaryColor)
            .systemBarsPadding()
            .fillMaxWidth()
            .height(70.dp)
            .padding(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(28.dp),
            painter = painterResource(id = if (isBackButtonVisible) R.drawable.ic_arrow_back else R.drawable.ic_inventory_app),
            contentDescription = if (isBackButtonVisible) "back button" else "Icon image",
            tint = whiteColor
        )
        SpaceWidth()
        TextComponent(
            textValue = title,
            modifier = Modifier.wrapContentSize(),
            fontSizeValue = 20.sp,
            textColorValue = whiteColor
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isNotificationVisible) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_notifications),
                contentDescription = "Icon image",
                tint = whiteColor
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun AppToolbarPreview() {
    AppToolbar()
}