package com.github.loganvelasco.bp2.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.tools.texturepacker.TexturePacker
import com.github.loganvelasco.bp2.BlockParty2

/** Launches the desktop (LWJGL3) application.  */
object Lwjgl3Launcher {
    @JvmStatic
    fun main(args: Array<String>) {

        val sets = TexturePacker.Settings()
         sets.pot = true
        sets.fast = true
        sets.paddingX = 1
        sets.paddingY = 1
        sets.maxHeight = 4096
        sets.maxWidth = 2048
        sets.edgePadding = true
        TexturePacker.process(sets, "assets/images", "assets/", "textures")
//        createApplication()
    }


    private fun createApplication(): Lwjgl3Application {
        return Lwjgl3Application(BlockParty2(), defaultConfiguration)
    }

    private val defaultConfiguration: Lwjgl3ApplicationConfiguration
        private get() {
            val configuration = Lwjgl3ApplicationConfiguration()
            configuration.setTitle("BlockParty2")
            configuration.setWindowedMode(640, 480)
            configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
            return configuration
        }
}