package com.github.loganvelasco.bp2.entity

import com.badlogic.gdx.math.Circle
import com.github.loganvelasco.bp2.config.GameConfig

class BaseTile(val type: Int, val xPos: Float, val yPos: Float, val size: Float) : GameObjectBase() {
    companion object {
        // == constants ==

    }

    override val bounds: Circle = Circle(xPos, yPos, size / 2)

}