package com.example.taskmanagerchecked

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagerchecked.ui.theme.TaskManagerCheckedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textoList = listOf<String>( "All tasks completed","Nice work!");
        setContent {
            TaskManagerCheckedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CheckedPage(TextList = textoList );
                }
            }
        }
    }
}

@Composable
fun CheckedPage(TextList: List< String >, modifier: Modifier = Modifier) {
    val textF : String = TextList[0];
    val textS : String = TextList[1];
    val imageLink : Painter = painterResource(R.drawable.ic_task_completed);
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = imageLink,
            contentDescription = null
        );
        Text(
            text = textF,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(0.dp, 24.dp, 0.dp, 8.dp)
        );
        Text(
            text = textS,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        );
    }
}

@Preview(showBackground = true)
@Composable
fun ChekedViewPreview() {
    val textoList = listOf<String>( "All tasks completed","Nice work!")
    TaskManagerCheckedTheme {
        CheckedPage(TextList = textoList );
    }
}