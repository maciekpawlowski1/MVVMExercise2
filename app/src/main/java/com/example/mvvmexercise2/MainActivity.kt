package com.example.mvvmexercise2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mvvmexercise2.domain.model.Product
import com.example.mvvmexercise2.ui.theme.MVVMExercise2Theme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMExercise2Theme {
                Column(
                    modifier =
                        Modifier
                            .safeContentPadding()
                            .fillMaxSize()
                            .wrapContentSize(),
                ) {
                    ProductList(
                        products =
                            viewModel.state
                                .collectAsState()
                                .value.products,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ProductList(products: List<Product>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = 8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(
            products,
            key = {
                it.id
            },
        ) { product ->
            ProductItem(
                product = product,
                modifier =
                    Modifier.animateItemPlacement(
                        tween(400),
                    ),
            )
        }
    }
}

@Composable
private fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
        modifier =
            modifier.background(
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp),
            ),
    ) {
        Text(
            text = product.name,
            modifier = Modifier.weight(weight = 1f),
        )
        Text(
            text =
                with(product.price) {
                    "${amount.toPlainString()} $currency"
                },
        )
    }
}
