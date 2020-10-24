package com.github.loganvelasco.bp2.config

import com.badlogic.gdx.Gdx

object GameConfig {

    const val WIDTH = 480f // pixels - desktop only
    const val HEIGHT = 800f // pixels - desktop only

    val WORLD_WIDTH = Gdx.graphics.width + 0f// world units
    val WORLD_HEIGHT = Gdx.graphics.height  + 0f// world units

    val gameBorderHeight = (WORLD_HEIGHT * (1f/9f))
    val gameBorderWidth = (WORLD_WIDTH / 8f)

    val tileRatio = 3f / 7f

    val playerRatio =  8
    val enemyRatio = 8
    val goalRatio = 9
    val obstacleRatio = 8
    val playerSize =  1.25f
    val enemySize =  1.25f
    val goalSize =  1.45f
    val obstacleSize = 1.5f

    val gameWidth = WORLD_WIDTH - gameBorderWidth*2
    val gameHeight = WORLD_HEIGHT - gameBorderHeight*2

    val gameStartX =  gameBorderWidth
    val gameEndX =  gameBorderWidth + gameWidth
    val gameStartY = gameBorderHeight
    val gameEndY = gameBorderHeight + gameHeight

    const val HUD_WIDTH = 800f // world units 1:1 ppu
    const val HUD_HEIGHT = 480f // world units 1:1 ppu

    val WORLD_CENTER_X = WORLD_WIDTH / 2f
    val WORLD_CENTER_Y = WORLD_HEIGHT / 2f
}