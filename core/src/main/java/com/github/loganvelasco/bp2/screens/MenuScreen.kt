package com.github.loganvelasco.bp2.screens

import com.badlogic.gdx.Gdx
import com.github.loganvelasco.bp2.BlockParty2
import com.github.loganvelasco.bp2.assets.LevelData
import com.github.loganvelasco.bp2.assets.RegionNames
import com.github.loganvelasco.bp2.assets.WorldData
import com.github.loganvelasco.bp2.controllers.MenuController
import com.github.loganvelasco.bp2.renderers.MenuRenderer
import com.github.loganvelasco.bp2.utils.logger
import ktx.app.KtxScreen


class MenuScreen (private val game: BlockParty2): KtxScreen {
    companion object {
        @JvmStatic
        private val log = logger<MenuScreen>()
    }

    private val controller: MenuController = MenuController()

    private val renderer = MenuRenderer(controller, game, WorldData.jungleTiles, RegionNames.WORLDMAP_FOREST, RegionNames.TILE)


    override fun show() {
    }

    override fun render(delta: Float) {
        controller.update(delta)
        renderer.render(delta)

        if (Gdx.input.isTouched) {
            game.addScreen(GameScreen(game,  LevelData.level6))
            game.setScreen<GameScreen>()
            game.removeScreen<MenuScreen>()
            dispose()
        }

    }


    override fun hide() {
        // Screens not disposed automatically
        dispose()
    }
}