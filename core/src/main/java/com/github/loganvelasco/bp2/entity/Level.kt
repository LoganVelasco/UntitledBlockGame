package com.github.loganvelasco.bp2.entity

import com.github.loganvelasco.bp2.config.GameConfig

class Level(val gameX: Float, val gameY: Float, val layout: IntArray) {
    val tileSize = (GameConfig.gameHeight * GameConfig.tileRatio) / ((gameX + gameY) / 3f)
    val playerRatio = tileSize /  GameConfig.playerRatio
    val enemyRatio = tileSize /  GameConfig.enemyRatio
    val goalRatio = tileSize/ GameConfig.goalRatio
    val obstacleRatio = tileSize/ GameConfig.obstacleRatio
    val playerSize = tileSize * GameConfig.playerSize
    val enemySize = tileSize *  GameConfig.enemySize
    val goalSize = tileSize * GameConfig.goalSize
    val obstacleSize = tileSize * GameConfig.obstacleSize
    val obstacles = layout.mapIndexed{index, element ->
        if(element == 4) index else null
    }.filterNotNull()



}