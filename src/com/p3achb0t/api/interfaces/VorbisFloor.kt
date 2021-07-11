package com.p3achb0t.api.interfaces

interface VorbisFloor {
    fun getClassDimensions(): IntArray
    fun getClassMasterbooks(): IntArray
    fun getClassSubClasses(): IntArray
    fun getMultiplier(): Int
    fun getPartitionClassList(): IntArray
    fun getSubclassBooks(): Array<IntArray>
    fun getXList(): IntArray
}
