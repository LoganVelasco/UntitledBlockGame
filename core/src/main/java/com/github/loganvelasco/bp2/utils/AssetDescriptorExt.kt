package com.github.loganvelasco.bp2.utils

import com.badlogic.gdx.assets.AssetDescriptor

inline fun <reified T: Any> assetDescriptor(fileName: String) = AssetDescriptor<T>(fileName, T::class.java)