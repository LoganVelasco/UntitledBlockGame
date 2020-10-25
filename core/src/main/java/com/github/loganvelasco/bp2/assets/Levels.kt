package com.github.loganvelasco.bp2.assets

import com.github.loganvelasco.bp2.entity.Level
import com.github.loganvelasco.bp2.entity.LevelTile

object WorldData{
    var jungleTiles= arrayListOf(
        LevelTile(.5f, .5f, LevelData.level1),
        LevelTile(.5f, .15f, LevelData.level2),
        LevelTile(.5f, .25f, LevelData.level3),
        LevelTile(.5f, .35f, LevelData.level4),
        LevelTile(.5f, .45f, LevelData.level5),
        LevelTile(.5f, .55f, LevelData.level6),
        LevelTile(.5f, .65f, LevelData.level7),
        LevelTile(.5f, .75f, LevelData.level8),
        LevelTile(.5f, .85f, LevelData.level9),
        LevelTile(.5f, .95f, LevelData.level10)
    )

}

object LevelData {

    var level1 = Level(6f, 3f, intArrayOf(
            0, 2, 0,
            0, 0, 0,
            0, 4, 0,
            0, 1, 0,
            0, 0, 0,
            0, 0, 3
    ))

    var level1Horizontal = Level(6f, 3f, intArrayOf(
            0, 0, 0, 0, 0, 3,
            2, 0, 4, 1, 0, 0,
            0, 0, 0, 0, 0, 0

    ))

    var level2 = Level(6f, 3f, intArrayOf(
            0, 2, 0,
            0, 0, 0,
            0, 4, 0,
            0, 1, 0,
            0, 0, 0,
            0, 0, 3
    ))

    var level3 = Level(8f, 6f, intArrayOf(
            0, 0, 0, 0, 0, 0,
            0, 0, 2, 0, 0, 0,
            0, 0, 4, 0, 0, 0,
            0, 0, 1, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 3, 0, 0,
            0, 0, 0, 0, 0, 0
    ))

    var level4 = Level(8f, 6f, intArrayOf(
            0, 0, 0, 2, 0, 3,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 4, 4, 0, 0, 0,
            0, 4, 0, 0, 0, 0,
            0, 4, 4, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 1, 0, 0
    ))


    var level5 = Level(8f, 6f, intArrayOf(
            0, 0, 0, 0, 0, 3,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 2, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 4, 0, 4, 0, 0,
            1, 0, 0, 0, 4, 0,
            0, 0, 0, 4, 0, 0,
            0, 0, 0, 0, 0, 0
    ))

    var level6 = Level(8f, 6f, intArrayOf(
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 2, 0, 0, 0, 0,
            3, 0, 0, 4, 0, 0,
            0, 0, 0, 0, 4, 0,
            0, 0, 1, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0
    ))

    var level7 = Level(8f, 6f, intArrayOf(
            0, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 4,
            0, 0, 0, 0, 4, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 2, 0, 0, 0, 0,
            3, 0, 0, 0, 0, 0
    ))

    var level8 = Level(8f, 6f, intArrayOf(
            0, 0, 0, 0, 3, 2,
            0, 0, 0, 0, 0, 0,
            0, 4, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 4, 0,
            0, 0, 0, 0, 0, 4,
            0, 0, 0, 0, 0, 0,
            1, 0, 0, 0, 0, 0
    ))
    var level9 = Level(6f, 3f, intArrayOf(
            0, 2, 0,
            0, 0, 0,
            0, 4, 0,
            0, 1, 0,
            0, 0, 0,
            0, 0, 3
    ))

    var level10 = Level(6f, 3f, intArrayOf(
            0, 2, 0,
            0, 0, 0,
            0, 4, 0,
            0, 1, 0,
            0, 0, 0,
            0, 0, 3
    ))


}