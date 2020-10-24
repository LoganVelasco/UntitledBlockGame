package com.github.loganvelasco.bp2.utils

import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.github.loganvelasco.bp2.controllers.GameController
import com.logan.obstacleavoid.utils.debug.DebugCameraController

class CustomInputProcessor(private val controller: GameController) : InputProcessor {


    override fun keyDown(keycode: Int): Boolean {
        return false;
    }

    override fun keyUp(keycode: Int): Boolean {
        if (keycode == Input.Keys.ENTER) {
            controller.enterPressed()
        }

        return false;
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        return false
    }

    override fun scrolled(amount: Int): Boolean {
        return false
    }

}