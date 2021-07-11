package com.p3achb0t.api.interfaces

interface PlayerType {
    fun getId(): Int
    fun getIsPrivileged(): Boolean
    fun getIsUser(): Boolean
    fun getModIcon(): Int
}
