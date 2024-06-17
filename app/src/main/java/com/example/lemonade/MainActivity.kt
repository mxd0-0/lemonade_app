package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiScreen(modifier: Modifier = Modifier) {


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PicAndText(modifier: Modifier = Modifier) {


    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = R.drawable.lemon_tree)
            ,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.lemon_tree1))
    }

}

@Preview(showBackground = true)
@Composable
private fun hello() {
    PicAndText(modifier = Modifier.fillMaxSize()
        .wrapContentSize(Alignment.Center))

}

