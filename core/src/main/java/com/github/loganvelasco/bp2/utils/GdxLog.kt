package com.github.loganvelasco.bp2.utils

import com.badlogic.gdx.utils.Logger

inline fun <reified T: Any> logger() = Logger(T::class.java.simpleName, Logger.DEBUG)