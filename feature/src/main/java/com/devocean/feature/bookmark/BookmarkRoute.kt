package com.devocean.feature.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.theme.SpotGray
import com.devocean.feature.R
import com.devocean.feature.bookmark.component.BookmarkTopBar
import com.devocean.feature.home.YouTubeData
import com.devocean.core.designsystem.component.item.YoutubeItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun BookmarkRoute(
    navigateUp: () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    val mockDataList = listOf(
        YouTubeData(
            image = painterResource(id = R.drawable.img_youtube_1),
            title = "데보션 영 3기 생생한 발대식 현장",
            category = "IT",
            bookmark = true,
            summary = "한줄요약"
        ),
        YouTubeData(
            image = painterResource(id = R.drawable.img_youtube_2),
            title = "나는 왜 코프링 컨트롤러를 더이상 만들지 않게 되었나?",
            category = "IT",
            bookmark = false,
            summary = "한줄요약"
        )
    )

    BookmarkScreen(
        dataList = mockDataList,
        onBackClick = { navigateUp() }
    )
}

@Composable
fun BookmarkScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    dataList: List<YouTubeData>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BookmarkTopBar(
            onBackClick = { onBackClick() }
        )
        HorizontalDivider(thickness = 2.dp, color = SpotGray)
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(dataList) { item ->
                Box(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    YoutubeItem(
                        image = item.image,
                        title = item.title,
                        category = item.category,
                        summary = item.summary,
                        isBookmark = item.bookmark,
                        spotDate = "spot date: 10/14"
                    )
                }
            }
        }
    }
}