package com.github.loganvelasco.bp2.renderers


import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.Disposable
import com.github.loganvelasco.bp2.BlockParty2
import com.github.loganvelasco.bp2.assets.RegionNames
import com.github.loganvelasco.bp2.assets.TextureAtlasAssets
import com.github.loganvelasco.bp2.assets.get
import com.github.loganvelasco.bp2.config.GameConfig
import com.github.loganvelasco.bp2.controllers.MenuController
import com.github.loganvelasco.bp2.entity.LevelTile
import com.github.loganvelasco.bp2.utils.logger
import javafx.scene.layout.BackgroundImage
import ktx.graphics.use


class MenuRenderer(
        private val controller: MenuController,
        private val game: BlockParty2,
        private val tiles: ArrayList<LevelTile>,
        private val backgroundTextureName: String,
        private val tileTextureName: String) : Disposable {

    var backgroundSetup = false
    companion object{
        @JvmStatic
        private val log = logger<MenuRenderer>()
    }
    private var backgroundTexture = game.assetManager[TextureAtlasAssets.Game].findRegion(backgroundTextureName)
    private val tileTexture = game.assetManager[TextureAtlasAssets.Game].findRegion(tileTextureName)

    val tileSize = GameConfig.WORLD_HEIGHT/(tiles.size+2)
    val tileSpace = GameConfig.WORLD_HEIGHT/(tiles.size/2+1)
    private val camera = OrthographicCamera().apply { setToOrtho(false, GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT) }

     fun render(delta: Float) {
        camera.update()
        game.batch.projectionMatrix = camera.combined
        game.assetManager.update()

        game.batch.use {batch ->
            batch.draw(backgroundTexture, 0f, 0f, GameConfig.WORLD_WIDTH, (GameConfig.WORLD_WIDTH /8f)*9f)
//            batch.draw(tileTexture, GameConfig.WORLD_WIDTH/2f-tileSize, tileSpace - tileSize*1.5f, tileSize, tileSize)
//            batch.draw(tileTexture, GameConfig.WORLD_WIDTH/1.25f-tileSize, tileSpace * 2.25f - tileSize, tileSize, tileSize)
//            batch.draw(tileTexture, GameConfig.WORLD_WIDTH/2f-tileSize, tileSpace * 3.5f - tileSize, tileSize, tileSize)
//            batch.draw(tileTexture, GameConfig.WORLD_WIDTH/4f-tileSize, tileSpace * 4.75f - tileSize, tileSize, tileSize)
//            batch.draw(tileTexture, GameConfig.WORLD_WIDTH/2f-tileSize, tileSpace * 6f - tileSize*1.5f, tileSize, tileSize)

            tiles.forEach {
                batch.draw(tileTexture, GameConfig.WORLD_WIDTH * it.xPercent - tileSize, (GameConfig.WORLD_HEIGHT*2) * it.yPercent - tileSize, tileSize, tileSize)
            }

        }


    }

    override fun dispose() {
//        dispose()
    }


}