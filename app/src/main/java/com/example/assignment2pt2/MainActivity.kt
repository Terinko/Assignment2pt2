package com.example.assignment2pt2

import Country
import CountryList
import android.os.Bundle
import android.widget.GridLayout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2pt2.ui.theme.Assignment2pt2Theme
import com.example.assignment2pt2.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2pt2Theme {
                CountryListScreen()
            }
        }
    }
}

@Composable
fun CountryListScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(CountryList) { country ->
            CountryItem(country)
        }
    }
}

@Composable
fun CountryItem(country: Country) {
    Row{
        Image(painterResource(country.flag), null,
            modifier = Modifier
                .fillMaxHeight()
                .size(50.dp))
        Column (modifier = Modifier.padding(5.dp)){
            Text(text = "Country: ${country.name}", modifier = Modifier.padding(horizontal = 10.dp))
            Text(text = "Currency: ${country.currency}", modifier = Modifier.padding(horizontal = 10.dp)
                ,fontSize = 11.sp)
        }
    }
    HorizontalDivider(thickness = 1.dp, color = Color.Gray)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2pt2Theme {
        CountryListScreen()
    }
}