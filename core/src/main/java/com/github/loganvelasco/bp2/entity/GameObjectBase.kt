package com.github.loganvelasco.bp2.entity

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Intersector

abstract class GameObjectBase {

    var index = -1
    open var layoutCode = 1

    // == public properties ==
    var x: Float = 0f
        set(value) {
            field = value
            updateBounds()
        }

    var y: Float = 0f
        set(value) {
            field = value
            updateBounds()
        }

    var width = 1f
        set(value) {
            field = value
            updateBounds()
        }

    var height = 1f
        set(value) {
            field = value
            updateBounds()
        }

    fun setSize(width: Float, height : Float){
        this.height = height
        this.width = width
    }

    // open to have default, abstract for none
    abstract val bounds : Circle

   open fun isColliding(gameObject: GameObjectBase) = Intersector.overlaps(gameObject.bounds, bounds)

    fun setPosition(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    // == private functions ==
    private fun updateBounds() = bounds.setPosition(x + width/2, y + height/2)

}