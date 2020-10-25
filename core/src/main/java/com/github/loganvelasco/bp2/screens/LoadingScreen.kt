package com.github.loganvelasco.bp2.screens

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.github.loganvelasco.bp2.BlockParty2
import com.github.loganvelasco.bp2.config.GameConfig
import ktx.app.KtxScreen
import ktx.app.clearScreen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Color.BLACK
import com.github.loganvelasco.bp2.assets.*
import com.github.loganvelasco.bp2.utils.logger


/** First screen of the application. Displayed after the application is created.  */
class LoadingScreen(val game : BlockParty2): KtxScreen {

    private val SCALE = 2.0f
    val PIXEL_PER_METER = 32f

    private val assetManager = game.assetManager
    private val camera = OrthographicCamera()
    private val viewport = FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera)
    private val renderer = ShapeRenderer()

    private var progress = 0f
    private var waitTime = .75f
    private var changeScreen = false

    companion object{
        @JvmStatic
        private val log = logger<LoadingScreen>()

        private const val PROGRESS_BAR_WIDTH = GameConfig.HUD_WIDTH / 2f
        private const val PROGRESS_BAR_HEIGHT = 60f
    }

    init {
//        MusicAssets.values().forEach { game.assetManager.load(it) }
//        SoundAssets.values().forEach { game.assetManager.load(it) }
        TextureAtlasAssets.values().forEach { game.assetManager.load(it) }
    }

    override fun render(delta: Float) {
        update(delta)
        val color = Color.BLACK
        clearScreen(color.r, color.g, color.b, 1f)
        viewport.apply()
        renderer.projectionMatrix = camera.combined

        renderer.begin(ShapeRenderer.ShapeType.Filled)
        draw()
        renderer.end()

        if(changeScreen){
            game.setScreen<MenuScreen>()
        }
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun hide() {
        dispose()
    }

    override fun dispose() {
        log.debug("dispose")
        renderer.dispose()
    }

    private fun update(delta: Float) {
        progress = assetManager.progress

        if (assetManager.update()) {
            waitTime -= delta

            if (waitTime <= 0) {
                log.debug("assetManager diagnostics = ${assetManager.diagnostics}")
                changeScreen = true
                game.addScreen(MenuScreen(game))

            }
        }
    }

    private fun draw(){
        val progressBarX = (GameConfig.WORLD_WIDTH - PROGRESS_BAR_WIDTH) / 2f

        val progressBarY = (GameConfig.WORLD_HEIGHT- PROGRESS_BAR_HEIGHT) / 2f
        renderer.rect(progressBarX, progressBarY, progress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT)
    }
}