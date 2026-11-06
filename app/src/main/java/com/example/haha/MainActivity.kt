
package com.example.haha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var profile by remember {
                mutableStateOf(generateProfile(this@MainActivity))
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF202127))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Даркнет генератор профиля",
                    color = Color.White,
                    fontSize = 28.sp
                )

                Spacer(modifier = Modifier.height(40.dp))

                Image(
                    painter = painterResource(profile.avatar),
                    contentDescription = null,
                    modifier = Modifier.size(180.dp)
                )

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = profile.nickname,
                    color = Color.White,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(35.dp))

                Button(
                    onClick = {
                        profile = generateProfile(this@MainActivity)
                    }
                ) {
                    Text("СГЕНЕРИРОВАТЬ")
                }
            }
        }
    }
}
