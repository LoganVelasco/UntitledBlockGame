package com.github.loganvelasco.bp2.lwjgl3

import com.badlogic.gdx.tools.texturepacker.TexturePacker

object AssetPacker {
    const val DRAW_DEBUG_OUTLINE = false
    const val RAW_ASSETS_PATH = "lwjgl3/assets-raw"
    const val ASSETS_PATH = "android/assets"

}

fun main(args: Array<String>){
    val settings = TexturePacker.Settings().apply {
        debug = AssetPacker.DRAW_DEBUG_OUTLINE
    }

    TexturePacker.process(settings,
            "${AssetPacker.RAW_ASSETS_PATH}/gameplay",
            "${AssetPacker.ASSETS_PATH}/gameplay",
            "gameplay")
}