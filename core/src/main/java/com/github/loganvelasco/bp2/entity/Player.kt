package com.github.loganvelasco.bp2.entity

import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle


class Player(var size: Float) : GameObjectBase() {

    override var layoutCode = 1
    var timeout = 0f
    var jumping = false


    override val bounds: Circle = Circle(x, y, size/2)



}