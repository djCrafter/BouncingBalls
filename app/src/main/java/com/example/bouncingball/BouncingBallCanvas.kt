package com.example.bouncingball

import android.content.Context
import android.util.AttributeSet
import stanford.androidlib.graphics.GCanvas
import stanford.androidlib.graphics.GColor
import stanford.androidlib.graphics.GOval
import java.util.*

import kotlin.random.Random


class BouncingBallCanvas(context: Context, attrs: AttributeSet) : GCanvas(context, attrs){

    private val SIZE = 100f
    private val RAINDROP_SIZE = 20f
    private val RAINDROP_DY = 4f

    private var ticks = 0

    private var ballList = ArrayList<Ball>()

    override fun init() {
      ballsCreate(40)
    }

    fun ballsCreate(ballCount: Int) {

        for(i in 0..ballCount) {
            var ball = Ball(
                Random.nextInt(0, width - SIZE.toInt()).toFloat(),
                Random.nextInt(0, height - SIZE.toInt()).toFloat(),
                SIZE,
                SIZE,
                Random.nextInt(0, 16).toFloat(),
                Random.nextInt(0, 10).toFloat()
            )

            ball.fillColor = setColor(Random.nextInt(0, 8))

            Thread.sleep(15)

            ballList.add(ball)
        }

        for (ball in ballList) {
            add(ball)
        }
    }


    //tap on PLAY button
    fun play() {
        animate(60) {
           updateRaindrop()

            for (ball in ballList) {
                move(ball)
            }
        }
    }

    //tap on STOP button
    fun stop() {
        animationStop()
    }

    private fun setColor(number: Int) =
     when(number) {
            0 -> GColor.ORANGE
            1 -> GColor.BLACK
            2 -> GColor.BLUE
            3 -> GColor.BROWN
            4 -> GColor.CYAN
            5 -> GColor.GREEN
            6 -> GColor.RED
            7 -> GColor.YELLOW
         else -> GColor.PURPLE
        }

    //Ball moving
    fun move(ball: Ball) {
            ball.moveBy(ball.dx, ball.dy)
            if (ball.rightX >= width || ball.x <= 0) {
                ball.dx = -(ball.dx)
            }
            if (ball.bottomY >= height || ball.y <= 0) {
                ball.dy = -(ball.dy)
            }
        }


    fun makeRainDrop() {
        val x = Random.nextInt(0, (width - RAINDROP_SIZE).toInt())
        val y = 0
        val drop = GOval(x.toFloat(), y.toFloat(), RAINDROP_SIZE, RAINDROP_SIZE)
        drop.fillColor = GColor.GRAY
        add(drop)
    }

    fun updateRaindrop() {
        ticks++
        if (ticks == 30) {
            makeRainDrop()
            ticks = 0
        }


        for (shape in this) {
            //Сheck that it is not a ball.
            if (!(shape is Ball))
                shape.moveBy(0f, RAINDROP_DY)
        }
    }
}


