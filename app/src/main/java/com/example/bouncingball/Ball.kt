package com.example.bouncingball

import stanford.androidlib.graphics.GOval

class Ball(x: Float, y: Float, width: Float, height: Float, startDX: Float, startDY: Float) : GOval(x, y, width, height) {

    var dx : Float
    var dy : Float

    init {
        dx = startDX
        dy = startDY
    }
}