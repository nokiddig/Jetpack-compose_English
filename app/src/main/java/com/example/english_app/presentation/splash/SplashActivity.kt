package com.example.english_app.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.english_app.R
import com.example.english_app.presentation.login.view.LoginActivity
import com.example.english_app.ui.theme.English_appTheme
import kotlinx.coroutines.delay
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            English_appTheme {
                SplashScreen()
            }
        }
    }

    @Composable
    fun SplashScreen() {
        val alpha = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true, block = {
            alpha.animateTo(
                1f,
                animationSpec = tween(2000)
            )
            delay(1000)
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        })

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.sp_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(top = 205.dp)
                    .height(34.04.dp)
                    .width(320.dp)
            )
            Text(
                text = "Welcome", style = TextStyle(
                    fontWeight = FontWeight(700),
                    fontSize = 24.sp,
                    lineHeight = 32.69.sp,
                    letterSpacing = 0.15 / 100 * 24.sp,
                    color = Color(android.graphics.Color.parseColor("#575855"))
                )
            )
            Image(
                painter = painterResource(id = R.drawable.group88), contentDescription = null,
                modifier = Modifier
                    .width(336.03.dp)
                    .height(91.dp)
            )
            Image(
                modifier = Modifier
                    .width(399.dp)
                    .height(266.dp),
                painter = painterResource(id = R.drawable.model2_1),
                contentDescription = null
            )
        }

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (topLeftCi, topRightCi, botLeftCi, botRightCi) = createRefs()
            Image(painter = painterResource(id = R.drawable.ellipse44), contentDescription = null,
                Modifier
                    .width(182.dp - 35.dp)
                    .height(182.dp - 40.dp)
                    .constrainAs(topLeftCi) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    })
            Image(painter = painterResource(id = R.drawable.ellipse45), contentDescription = null,
                Modifier
                    .width(38.dp)
                    .height(131.dp - 59.dp)
                    .constrainAs(topRightCi) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    })
            Image(painter = painterResource(id = R.drawable.ellipse46), contentDescription = null,
                Modifier
                    .width(163.dp - 95.dp)
                    .height(163.dp)
                    .constrainAs(botLeftCi) {
                        top.linkTo(anchor = parent.top, margin = 673.dp)
                        start.linkTo(parent.start)
                    })
            Image(painter = painterResource(id = R.drawable.ellipse47), contentDescription = null,
                Modifier
                    .width(163.dp - 95.dp)
                    .height(163.dp - 95.dp)
                    .constrainAs(botRightCi) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    })
        }
    }
}
