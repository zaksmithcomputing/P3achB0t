package com.p3achb0t.api.interfaces

interface FriendLoginUpdate : Link {
    fun getTime(): Int
    fun getUsername(): Username
    fun getWorld(): Short
}
