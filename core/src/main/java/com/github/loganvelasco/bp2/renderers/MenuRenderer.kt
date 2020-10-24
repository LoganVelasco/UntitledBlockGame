package com.github.loganvelasco.bp2.renderers


import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.Disposable
import com.github.loganvelasco.bp2.BlockParty2
import com.github.loganvelasco.bp2.config.GameConfig
import com.github.loganvelasco.bp2.controllers.MenuController
import com.github.loganvelasco.bp2.utils.logger
import ktx.graphics.use


class MenuRenderer(private val controller: MenuController,
                   private val game: BlockParty2) : Disposable {

    companion object{
        @JvmStatic
        private val log = logger<MenuRenderer>()
    }

    private val camera = OrthographicCamera().apply { setToOrtho(false, GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT) }

     fun render(delta: Float) {
        camera.update()
        game.batch.projectionMatrix = camera.combined

        game.batch.use {
            game.font.draw(it, "Welcome to Block Party 2!!! ", GameConfig.WORLD_WIDTH/2 - 10f, GameConfig.WORLD_HEIGHT/2  + 100f, 300f, 10, false)
            game.font.draw(it, "Tap anywhere to begin!", GameConfig.WORLD_WIDTH/2 - 7f, GameConfig.WORLD_HEIGHT/2)
        }


    }

    override fun dispose() {
//        dispose()
    }


}