package com.github.loganvelasco.bp2.controllers

import com.badlogic.gdx.Input
import com.badlogic.gdx.math.MathUtils
import com.github.loganvelasco.bp2.assets.LevelData
import com.github.loganvelasco.bp2.assets.RegionNames
import com.github.loganvelasco.bp2.config.GameConfig
import com.github.loganvelasco.bp2.entity.BaseTile
import com.github.loganvelasco.bp2.entity.Level
import com.github.loganvelasco.bp2.entity.LevelTile
import com.github.loganvelasco.bp2.entity.Player
import com.github.loganvelasco.bp2.utils.isKeyPressed
import com.github.loganvelasco.bp2.utils.logger
import javafx.scene.layout.BackgroundImage


class MenuController() {
    companion object{
        @JvmStatic
        private val log = logger<MenuController>()
    }
//    val tileSize = GameConfig.WORLD_HEIGHT/(tileCount+2)
//    val tileSpace = GameConfig.WORLD_HEIGHT/((tileCount/2)+1)
//    batch.draw(backgroundTexture, 0f, 0f, GameConfig.WORLD_WIDTH, (GameConfig.WORLD_WIDTH /8f)*9f)
//    batch.draw(tileTexture, GameConfig.WORLD_WIDTH/2f-tileSize, tileSpace - tileSize*1.5f, tileSize, tileSize)
//    batch.draw(tileTexture, GameConfig.WORLD_WIDTH/1.25f-tileSize, tileSpace * 2.25f - tileSize, tileSize, tileSize)
//    batch.draw(tileTexture, GameConfig.WORLD_WIDTH/2f-tileSize, tileSpace * 3.5f - tileSize, tileSize, tileSize)
//    batch.draw(tileTexture, GameConfig.WORLD_WIDTH/4f-tileSize, tileSpace * 4.75f - tileSize, tileSize, tileSize)
//    batch.draw(tileTexture, GameConfig.WORLD_WIDTH/2f-tileSize, tileSpace * 6f - tileSize*1.5f, tileSize, tileSize)



    fun update(delta: Float) {


    }


}