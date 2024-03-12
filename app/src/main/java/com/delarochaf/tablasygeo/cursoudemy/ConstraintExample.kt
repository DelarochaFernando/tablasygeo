package com.delarochaf.tablasygeo.cursoudemy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ConstraintExample(){
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {
        val (boxRed,boxBlue,boxYellow,boxMagenta,boxBlack) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxRed.top)
                end.linkTo(boxRed.start)

            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Black)
            .constrainAs(boxBlack) {
                top.linkTo(boxRed.bottom)
                end.linkTo(boxRed.start)
            })
    }
}

//@Preview(showSystemUi = true)
@Composable
fun ConstrainExampleGuide(){
    
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {

        val boxRef = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val starGuide = createGuidelineFromStart(0.25f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRef) {
                top.linkTo(topGuide)
                start.linkTo(starGuide)
            })
    }
}

//@Preview(showSystemUi = true)
@Composable
fun ConstraintBarrier(){
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {

        val (boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed,boxGreen)

        Box(modifier = Modifier
            .size(25.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start, margin = 16.dp)
            })

        Box(modifier = Modifier
            .size(235.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxGreen.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(barrier, margin = 32.dp)
            })
    }

}

@Preview(showSystemUi = true)
@Composable
fun ConstraintChain(){
    ConstraintLayout(modifier = Modifier.fillMaxSize().background(Color.Gray)) {

        val (boxRed, boxGreen, boxYellow) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {

            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {

            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {

            })
    }
}