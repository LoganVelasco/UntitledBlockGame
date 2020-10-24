package com.github.loganvelasco.bp2.entity

import com.badlogic.gdx.math.Circle

class Goal(val size: Float) : GameObjectBase() {

    companion object {
        // == constants ==

        const val MAX_X_SPEED = .15f // world units

    }

    var timeout = 0f
    var jumping = false
    override var  layoutCode = 3

    override val bounds: Circle = Circle(x, y, size/2)



}