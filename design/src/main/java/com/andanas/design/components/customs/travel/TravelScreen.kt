package com.andanas.design.components.customs.travel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andanas.design.R
import com.andanas.design.ui.theme.SuperAppExampleTheme

@Composable
fun DestinationDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(modifier = Modifier.height(260.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_notifications),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                }
                Row {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Share, contentDescription = null, tint = Color.White)
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Text("BALI", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                Text("Indonesia", color = Color.White, fontSize = 16.sp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(20.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text("4.9", fontWeight = FontWeight.Bold)
                    Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        // Tabs
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf("Hotel", "Foods", "Activities").forEachIndexed { index, text ->
                val isSelected = index == 0 // puedes manejar el estado real aquí
                Text(
                    text,
                    modifier = Modifier
                        .background(
                            if (isSelected) Color(0xFFDCE1ED) else Color.Transparent,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    color = if (isSelected) Color.Black else Color.Gray
                )
            }
        }

        // Tarjetas de recomendación
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(2) { index ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .width(160.dp)
                        .padding(end = 16.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = if (index == 0) R.drawable.ic_arrow_back else R.drawable.ic_notifications),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(100.dp)
                                .fillMaxWidth()
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = if (index == 0) "Villa Kayu Lama" else "10+",
                            modifier = Modifier.padding(horizontal = 8.dp),
                            fontWeight = FontWeight.Bold
                        )
                        if (index == 0) {
                            Row(modifier = Modifier.padding(8.dp)) {
                                repeat(5) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = null,
                                        tint = Color(0xFFFFC107),
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Detalles
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("DETAILS", fontWeight = FontWeight.Bold)
            Text(
                "Surrounded by rice fields, Villa Kayu Lama offers a peaceful retreat in Ubud. Guests can take a leisurely swim in the privat... ",
                color = Color.Gray
            )
            Text("Read More", color = Color.Blue, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón continuar
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C4CC)),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text("Continue", color = Color.White)
            Spacer(Modifier.width(8.dp))
            Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DestinationDetailScreenPreview() {
    SuperAppExampleTheme {
        DestinationDetailScreen()
    }
}