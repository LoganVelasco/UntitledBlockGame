package com.github.loganvelasco.bp2.controllers

import com.badlogic.gdx.math.MathUtils
import com.github.loganvelasco.bp2.config.GameConfig
import com.github.loganvelasco.bp2.entity.*
import com.github.loganvelasco.bp2.utils.logger
import kotlin.math.roundToInt


class GameController(val level: Level) {
    companion object{
        @JvmStatic
        private val log = logger<GameController>()
    }

    val tileSize = level.tileSize
    val obstacleSize = level.obstacleSize
    private val verticalSpace = (GameConfig.gameHeight - level.gameY * level.tileSize) / level.gameY
    private val horizontalSpace = (GameConfig.gameWidth - level.gameX * level.tileSize) / level.gameX

    var selectedDirection : String? = null
    var player = Player(level.playerSize)
        private set

    var enemy = Enemy(level.enemySize)
        private set

    var goal = Goal(level.goalSize)
        private set


    fun enterPressed(){
        selectedDirection?.let {
            characterMoveCheck(player, selectedDirection!!)
            selectedDirection = null
        }

    }

//    private fun attemptMovePlayer(selectedDirection: String) {
//        when(selectedDirection){
//            "up" -> {
//                if (isMoveInBounds(player,"up") && isSomethingThere(player.index + 1)) {
//                    level.layout[player.index] = 0
//                    player.index++
//                    level.layout[player.index] = 1
//                    movePlayer(0f, verticalSpace + tileSize)
//                }
//            }
//            "down" -> {
//                if (isMoveInBounds(player,"down") && isSomethingThere(player.index - 1)) {
//                    level.layout[player.index] = 0
//                    player.index--
//                    level.layout[player.index] = 1
//                    movePlayer(0f, -verticalSpace - tileSize)
//                }
//            }
//            "right" -> {
//                if(isMoveInBounds(player,"right") && isSomethingThere(player.index + level.gameY.roundToInt())) {
//                    level.layout[player.index] = 0
//                    player.index = player.index + level.gameY.roundToInt()
//                    level.layout[player.index] = 1
//                    movePlayer(horizontalSpace + tileSize, 0f)
//                }
//            }
//            "left" -> {
//                if(isMoveInBounds(player,"left") && isSomethingThere(player.index - level.gameY.roundToInt())) {
//                    level.layout[player.index] = 0
//                    player.index = player.index - level.gameY.roundToInt()
//                    level.layout[player.index] = 1
//                    movePlayer(-horizontalSpace - tileSize, 0f)
//                }
//            }
//        }
//
//    }

    private fun isSomethingThere(newIndex: Int): Boolean {
        return when(level.layout[newIndex]){
            0 -> true
            1 -> true
            2 -> false
            3 -> true
            4 -> false
            else -> false
        }
    }

    private fun moveCharacter(character: GameObjectBase, x: Float, y: Float){
        character.x = character.x + x
        character.y = character.y + y
        if(character is Player){
            moveEnemy()
            moveEnemy()
        }
    }

    private fun moveEnemy() {
        if(enemy.index % level.gameY == player.index % level.gameY)
            if(enemy.index < player.index)
                characterMoveCheck(enemy, "right")
            else
                characterMoveCheck(enemy, "left")
        else{
            val tempIndex = enemy.index
            if(enemy.index % level.gameY > player.index % level.gameY)
                characterMoveCheck(enemy, "down")
            else
                characterMoveCheck(enemy, "up")
            if (tempIndex == enemy.index){
                if(enemy.index < player.index)
                    characterMoveCheck(enemy, "right")
                else
                    characterMoveCheck(enemy, "left")
            }
        }
    }

    private fun characterMoveCheck(character: GameObjectBase, selectedDirection: String) {
        when(selectedDirection){
            "up" -> {
                if (isMoveInBounds(character,"up") && isSomethingThere(character.index + 1)) {
                    level.layout[character.index] = 0
                    character.index++
                    level.layout[character.index] = character.layoutCode
                    moveCharacter(character, 0f, verticalSpace + tileSize)
                }
            }
            "down" -> {
                if (isMoveInBounds(character,"down") && isSomethingThere(character.index - 1)) {
                    level.layout[character.index] = 0
                    character.index--
                    level.layout[character.index] = character.layoutCode
                    moveCharacter(character, 0f, -verticalSpace - tileSize)
                }
            }
            "right" -> {
                if(isMoveInBounds(character,"right") && isSomethingThere(character.index + level.gameY.roundToInt())) {
                    level.layout[character.index] = 0
                    character.index = character.index + level.gameY.roundToInt()
                    level.layout[character.index] = character.layoutCode
                    moveCharacter(character, horizontalSpace + tileSize, 0f)
                }
            }
            "left" -> {
                if(isMoveInBounds(character,"left") && isSomethingThere(character.index - level.gameY.roundToInt())) {
                    level.layout[character.index] = 0
                    character.index = character.index - level.gameY.roundToInt()
                    level.layout[character.index] = character.layoutCode
                    moveCharacter(character, -horizontalSpace - tileSize, 0f)
                }
            }
        }
    }

    private fun isMoveInBounds(character: GameObjectBase, direction: String): Boolean {
        when(direction){
            "up" -> {
                val outOfXBounds = (character.y + verticalSpace + tileSize) >= GameConfig.gameStartY + GameConfig.gameHeight
                return !outOfXBounds
            }
            "down" -> {
                val outOfXBounds = (character.y - verticalSpace - tileSize) <= GameConfig.gameStartY
                return !outOfXBounds
            }
            "right" -> {
                val outOfYBounds =  (character.x + horizontalSpace + tileSize) >= GameConfig.gameStartX + GameConfig.gameWidth
                return !outOfYBounds
            }
            "left" -> {
                val outOfYBounds = (character.x - horizontalSpace - tileSize) <= GameConfig.gameStartX
                return !outOfYBounds
            }
        }
        return false
    }

    // always see player in camera
    private fun blockPlayerFromLeavingTheWorld(newX: Float):Boolean{
        // has to do - player.HALF_SIZE else would stop where center hit bounds
        return MathUtils.clamp(newX, 0f, GameConfig.WORLD_WIDTH - player.size) != newX
    }

    fun setupLevel(): ArrayList<BaseTile> {

        var x = horizontalSpace / 2
        var y = verticalSpace / 2
        val tiles = arrayListOf<BaseTile>()

        val totalHorizontalSpace = level.tileSize + horizontalSpace
        val totalVerticalSpace = level.tileSize + verticalSpace

        var temp = 0
        var temp2 = 0
        var index = 0

        while (temp++ < level.gameX) {
            while (temp2++ < level.gameY) {
                if(index < level.layout.size && level.layout[index] != -1) {

                    if(level.layout[index] == 1) {
                        player.x = GameConfig.gameStartX + x -level.playerRatio
                        player.y = GameConfig.gameStartY + y - level.playerRatio
                        player.index = index
                    }
                    if(level.layout[index] == 2) {
                        enemy.x = GameConfig.gameStartX + x - level.enemyRatio
                        enemy.y = GameConfig.gameStartY + y - level.enemyRatio
                        enemy.index = index
                    }
                    if(level.layout[index] == 3) {
                        goal.x = GameConfig.gameStartX + x - level.goalRatio
                        goal.y = GameConfig.gameStartY + y - level.goalRatio
                        goal.index = index
                    }
                    tiles.add(BaseTile(level.layout[index++], GameConfig.gameStartX + x, GameConfig.gameStartY + y, level.tileSize))
                }
                y += totalVerticalSpace
            }
            y = verticalSpace / 2
            temp2 = 0
            x += totalHorizontalSpace
        }
        return tiles
    }

}