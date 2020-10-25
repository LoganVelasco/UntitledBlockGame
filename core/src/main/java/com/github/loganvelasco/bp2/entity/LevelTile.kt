package com.github.loganvelasco.bp2.entity

import com.badlogic.gdx.math.Circle
import com.github.loganvelasco.bp2.assets.RegionNames
import com.github.loganvelasco.bp2.config.GameConfig

class LevelTile(val xPercent: Float, val yPercent: Float, val level: Level) : GameObjectBase() {

    var movesCompleted = 0
    override val bounds: Circle = Circle(0f, 0f, 0f)

}