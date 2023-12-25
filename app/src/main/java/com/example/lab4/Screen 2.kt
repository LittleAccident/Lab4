package com.example.lab4


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4.ui.theme.Lab4Theme



@Composable
fun Screen2(salary: Double, onReturn: () -> Unit) {
    var showTextResult by remember { mutableStateOf(true) }

    val imageResource = if (!showTextResult) {
        R.drawable.bagofmoney
    } else {
        0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .clickable {
                    showTextResult = !showTextResult
                }
        ) {
            if (showTextResult) {
                Text(
                    text = String.format("%.2f", salary)
                )
            } else {
                val resultText = when {
                    salary <= 1000.0 -> "Junior"
                    salary <= 2000.0 -> "Middle"
                    salary <= 3000.0 -> "Senior"
                    else -> "Oligarch"
                }
                Text(
                    text = resultText
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (!showTextResult) {
            Box(
                modifier = Modifier
                    .clickable {
                        showTextResult = !showTextResult
                    }
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = null,
                    modifier = Modifier.size(72.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onReturn,
            modifier = Modifier
                .height(40.dp)
        ) {
            Text("Return")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen2Preview() {
    Lab4Theme {
        Screen2(salary = 1000.0) {}
    }
}