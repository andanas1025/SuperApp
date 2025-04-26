package com.andanas.design.components.customs.booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResultsScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {

        // Barra superior
        TopAppBar(
            title = { Text("Search results", fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
        )

        // Campo de búsqueda
        OutlinedTextField(
            value = "Modern House",
            onValueChange = {},
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Contador y vista toggle
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Found 128 estates", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            IconToggleButton(checked = true, onCheckedChange = {}) {
                Icon(Icons.Default.Star, contentDescription = null)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Lista de propiedades (grid)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(propertyList) { property ->
                PropertyCard(property)
            }
        }
    }
}

@Composable
fun PropertyCard(property: Property) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box {
                Image(
                    painter = painterResource(id = property.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                )
                Text(
                    "\$ ${property.price}/month",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .background(Color(0xCC1E3A3A), shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .padding(8.dp)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Color(0xFFE91E63)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                Text(property.name, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(16.dp)
                    )
                    Text("${property.rating}", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(property.location, fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
    }
}

data class Property(
    val name: String,
    val price: Int,
    val location: String,
    val rating: Double,
    val imageRes: Int
)

val propertyList = listOf(
    Property("Bungalow House", 235, "Jakarta, Indonesia", 4.7, R.drawable.ic_notifications),
    Property("Bridgeland Modern House", 260, "Semarang, Indonesia", 4.9, R.drawable.ic_arrow_back),
    Property("Mill Sper House", 271, "Jakarta, Indonesia", 4.8, R.drawable.ic_inventory_app),
    Property("Flower Heaven Appartment", 370, "Bali, Indonesia", 4.7, R.drawable.ic_inventory_app),
)

@Preview(showBackground = true)
@Composable
fun SearchResultsScreenPreview() {
    SuperAppExampleTheme {
        SearchResultsScreen()
    }
}
