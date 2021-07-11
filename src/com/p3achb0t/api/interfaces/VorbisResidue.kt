package com.p3achb0t.api.interfaces

interface VorbisResidue {
    fun getBegin(): Int
    fun getCascade(): IntArray
    fun getClassbook(): Int
    fun getClassifications(): Int
    fun getEnd(): Int
    fun getPartitionSize(): Int
    fun getType(): Int
}
