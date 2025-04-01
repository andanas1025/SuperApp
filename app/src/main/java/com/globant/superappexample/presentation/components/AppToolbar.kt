package com.globant.superappexample.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.superappexample.R
import com.globant.superappexample.presentation.ui.theme.SuperAppExampleTheme
import com.globant.superappexample.presentation.ui.theme.primaryColor
import com.globant.superappexample.presentation.ui.theme.whiteColor

@Composable
fun AppToolbar() {
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
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.ic_inventory_app),
            contentDescription = "Icon image",
            tint = whiteColor
        )

        SpaceWidth()

        TextComponent(
            textValue = stringResource(R.string.add_address),
            modifier = Modifier.wrapContentSize(),
            fontSizeValue = 20.sp,
            textColorValue = whiteColor
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.ic_inventory_app),
            contentDescription = "Icon image",
            tint = whiteColor
        )
    }
}

@Preview(showBackground = false)
@Composable
fun AppToolbarPreview() {
    AppToolbar()
}