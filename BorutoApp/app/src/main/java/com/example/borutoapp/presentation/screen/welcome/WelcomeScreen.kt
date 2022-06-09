package com.example.borutoapp.presentation.screen.welcome

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.borutoapp.R
import com.example.borutoapp.domain.model.OnBoardingPage
import com.example.borutoapp.ui.theme.*
import com.example.borutoapp.util.Constants.ON_BOARDING_PAGE_COUNT
import com.google.accompanist.pager.*


@ExperimentalPagerApi
@Composable
fun WelcomeScreen(navHostController: NavHostController) {

    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.WelcomeScreenBackgroundColor),
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            count = ON_BOARDING_PAGE_COUNT,
            verticalAlignment = Alignment.Top)
            { position ->
                PagerScreen(onBoardingPage = pages[position])
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            activeColor = MaterialTheme.colors.activeIndicatorColor,
            inactiveColor = MaterialTheme.colors.inactiveIndicatorColor,
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            pagerState = pagerState,
            spacing = PAGING_INDICATOR_SPACING
        )

        FinishButton(
            pagerState = pagerState,
            modifier = Modifier.weight(1f)){
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage){
    Column(
        modifier = Modifier
         .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image), 
            contentDescription = stringResource(R.string.on_boarding_image)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )

    }
}

@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center)
    {
        AnimatedVisibility(
            modifier = modifier
                .fillMaxWidth(),
            visible = pagerState.currentPage == 2)
        {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonBackgroundColors,
                    contentColor = Color.White
                )) {
                Text(text = stringResource(R.string.finish))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FirstOnBoardingScreenPreview() {
    Column(
        modifier = Modifier.fillMaxSize()) {
            PagerScreen(onBoardingPage = OnBoardingPage.First)
    }
}

@Preview(showBackground = true)
@Composable
fun SecondOnBoardingScreenPreview() {
    Column(
        modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdOnBoardingScreenPreview() {
    Column(
        modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Third)
    }
}
