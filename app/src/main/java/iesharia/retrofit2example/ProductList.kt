package iesharia.retrofit2example

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import iesharia.retrofit2example.data.ProductDBViewModel
import iesharia.retrofit2example.data.db.productResponseToProduct
import iesharia.retrofit2example.network.ProductResponse

@Composable
fun ProductList(
    title: String,
    productList: List<ProductResponse>,
    icon: ImageVector,
    onClickAction: (product: ProductResponse) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                text = title,
                fontSize = TextUnit(8f, TextUnitType.Em),
                fontWeight = FontWeight.Bold
            )
        }
        if (productList.isEmpty()) {
            item {
                Text(
                    modifier = Modifier.padding(top = 25.dp),
                    text = "Lista vacía",
                    fontSize = TextUnit(8f, TextUnitType.Em)
                )
            }
        } else {
            items(productList) { product ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    ),
                    modifier = Modifier
                        .width(260.dp)
                        .padding(bottom = 25.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = product.title,
                            fontSize = TextUnit(5.5f, TextUnitType.Em),
                            modifier = Modifier.weight(1f)
                        )
                        FilledIconButton(
                            modifier = Modifier.size(15.dp),
                            onClick = { onClickAction(product) },
                        ) {
                            Icon(icon, contentDescription = "Añadir elemento")
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 5.dp, bottom = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            modifier = Modifier.size(160.dp),
                            model = product.thumbnail,
                            contentDescription = "Imagen de ${product.title}"
                        )
                    }
                }
            }
        }
    }
}