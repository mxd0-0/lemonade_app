package com.example.lemonade

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeApp()

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var currentStep by remember {
        mutableIntStateOf(1)
    }
    var squeeznumber by remember {
        mutableIntStateOf(0)
    }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    ImageAndText(
                        text = stringResource(R.string.lemon_tree1),
                        photo = painterResource(R.drawable.lemon_tree),
                        onImageClick = {
                            squeeznumber = (2..4).random()

                            currentStep = 2
                        }

                    )
                }

                2 -> {
                    ImageAndText(
                        text = stringResource(id = R.string.squeeze_it),
                        photo = painterResource(id = R.drawable.lemon_squeeze),
                        onImageClick = {
                            if (squeeznumber == 0) {
                                currentStep = 3
                            }
                        }

                    )
                }

                3 -> {
                    ImageAndText(text = stringResource(id = R.string.drink_it),
                        photo = painterResource(
                            id = R.drawable.lemon_drink
                        ),
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }

                4 -> {
                    ImageAndText(text = stringResource(id = R.string.Start_again),
                        photo = painterResource(
                            id = R.drawable.lemon_restart
                        ),
                        onImageClick = { currentStep = 1 })
                }

            }


        }
    }
}

@Composable
fun ImageAndText(
    text: String, photo: Painter,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Button(onClick = onImageClick) {


            Image(
                painter = photo,
                contentDescription = stringResource(R.string.lemon_tree1),
                modifier = Modifier.wrapContentSize()
            )
        }
        Spacer(
            modifier = Modifier.height(
                32
                    .dp
            )
        )
        Text(text = text, fontSize = 18.sp)

    }

}

@Preview(showSystemUi = true)
@Composable
private fun Ll() {
    LemonadeApp()
}



