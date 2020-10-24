package com.github.loganvelasco.bp2.renderers

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Disposable
import com.github.loganvelasco.bp2.BlockParty2
import com.github.loganvelasco.bp2.assets.*
import com.github.loganvelasco.bp2.config.GameConfig
import com.github.loganvelasco.bp2.controllers.GameController
import com.github.loganvelasco.bp2.utils.logger
import ktx.graphics.use
import com.github.loganvelasco.bp2.entity.BaseTile
import com.github.loganvelasco.bp2.entity.Level


class GameRenderer(private val controller: GameController,
                   private val game: BlockParty2, private val level: Level) : Disposable {

    companion object{
        @JvmStatic
        private val log = logger<GameRenderer>()
    }
    private val player = controller.player
    private val enemy = controller.enemy
    private val goal = controller.goal
    private val obstacleSize = controller.obstacleSize
    private val playerSize = player.size
    private val enemySize = enemy.size
    private val goalSize = goal.size

    private var baseTiles : ArrayList<BaseTile> = controller.setupLevel()


    private val camera = OrthographicCamera().apply { setToOrtho(false, GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT) }

       private val enemyTexture = game.assetManager[TextureAtlasAssets.Game].findRegion(RegionNames.ENEMY)
       private val playerTexture = game.assetManager[TextureAtlasAssets.Game].findRegion(RegionNames.PLAYER)
       private val backgroundTexture = game.assetManager[TextureAtlasAssets.Game].findRegion(RegionNames.FOREST1)
       private val goalTexture = game.assetManager[TextureAtlasAssets.Game].findRegion(RegionNames.GOAL)
       private val boulderTexture = game.assetManager[TextureAtlasAssets.Game].findRegion(RegionNames.BOULDER)
       private val tileTexture = game.assetManager[TextureAtlasAssets.Game].findRegion(RegionNames.TILE)
//       private val dropSound = game.assetManager[SoundAssets.Drop]
//       private val rainMusic = game.assetManager[MusicAssets.Rain].apply { isLooping = true }

    fun render(delta: Float) {
        // generally good practice to update the camera's matrices once per frame
        game.assetManager.update()
        camera.update()

        // tell the SpriteBatch to render in the coordinate system specified by the camera.
        game.batch.projectionMatrix = camera.combined


        game.batch.use { batch ->
            batch.draw(backgroundTexture, 0f, 0f, GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT)
            baseTiles.forEach {
                batch.draw(tileTexture, it.xPos, it.yPos, controller.tileSize, controller.tileSize)
            }

            batch.draw(playerTexture, player.x , player.y ,playerSize, playerSize)
            batch.draw(enemyTexture, enemy.x , enemy.y, enemySize, enemySize)
            batch.draw(goalTexture, goal.x, goal.y, goalSize, goalSize)

            drawObstacles(batch, baseTiles)
        }
    }

    private fun drawObstacles(batch: SpriteBatch, baseTiles: ArrayList<BaseTile>) {
        level.obstacles.forEach{
            batch.draw(boulderTexture, baseTiles[it].xPos - level.obstacleRatio, baseTiles[it].yPos - level.obstacleRatio, obstacleSize, obstacleSize)
        }
    }



    override fun dispose() {
//        dispose()
    }


}