package com.github.loganvelasco.bp2

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Logger
import com.github.loganvelasco.bp2.screens.LoadingScreen
import com.github.loganvelasco.bp2.screens.MenuScreen
import ktx.app.KtxGame

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class BlockParty2 : KtxGame<Screen>() {

    val assetManager = AssetManager()
    val batch by lazy { SpriteBatch() }
    // use LibGDX's default Arial font
    val font by lazy { BitmapFont() }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        assetManager.logger.level = Logger.DEBUG
        addScreen(LoadingScreen(this))
        addScreen(MenuScreen(this))
        setScreen<LoadingScreen>()
    }

    override fun dispose() {
        super.dispose()
        assetManager.dispose()
        batch.dispose()
        font.dispose()
    }


}