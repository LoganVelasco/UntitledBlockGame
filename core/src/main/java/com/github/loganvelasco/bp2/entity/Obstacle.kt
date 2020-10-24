package com.github.loganvelasco.bp2.entity

import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle


class Obstacle(size: Float) : GameObjectBase() {



    var timeout = 0f
    var jumping = false
    var size = 32f
    override var  layoutCode = 4

    override val bounds: Circle = Circle(x, y, size/2)



}