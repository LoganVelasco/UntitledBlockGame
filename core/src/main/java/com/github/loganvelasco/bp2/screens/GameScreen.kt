package com.github.loganvelasco.bp2.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.github.loganvelasco.bp2.BlockParty2
import com.github.loganvelasco.bp2.controllers.GameController
import com.github.loganvelasco.bp2.entity.Level
import com.github.loganvelasco.bp2.renderers.GameRenderer
import com.github.loganvelasco.bp2.utils.CustomInputProcessor
import ktx.app.KtxScreen

class GameScreen(private val game: BlockParty2,private val level :Level) : KtxScreen {


    private val controller = GameController(level)

    private val renderer = GameRenderer(controller, game, level )
    private val processor = CustomInputProcessor(controller)

    init {
        Gdx.input.inputProcessor = processor
    }
    override fun render(delta: Float) {

        renderer.render(delta)

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            controller.selectedDirection = "left"
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            controller.selectedDirection = "right"
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            controller.selectedDirection = "up"
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            controller.selectedDirection = "down"
        }

//        controller.update(delta)
    }



    override fun show() {
        // start the playback of the background music when the screen is shown
//        rainMusic.play()
//        spawnRaindrop()
    }

    override fun dispose() {
//        dropImage.dispose()
//        bucketImage.dispose()
//        dropSound.dispose()
//        rainMusic.dispose()
    }

}