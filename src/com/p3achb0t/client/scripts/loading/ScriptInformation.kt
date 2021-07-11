package com.p3achb0t.client.scripts.loading

import java.io.File
import java.net.URL
import java.net.URLClassLoader

enum class ScriptType {
    PaintScript,
    ActionScript,
    ServiceScript,
    None
}

class ScriptInformation(val fileName: String, val path: String, val category: String, val name: String, val author: String, val version: String, val type: ScriptType, val main: String, val clazz: Class<*>? = null) {

    fun load(): Any? {
        return if (path.contains(".class")) {
            if (clazz != null) {
                clazz.newInstance()
            } else {
                val loadedClass = Class.forName(main.replace("/", "."), true, this.javaClass.classLoader)
                loadedClass.newInstance()
            }
        } else {
            val file = File(path)
            val urlArray: Array<URL> = Array(1, init = { file.toURI().toURL() })
            val classLoader = URLClassLoader(urlArray)
            classLoader.loadClass(main).newInstance()
        }
    }

    override fun toString(): String {
        return "$fileName [$author, $name, {$category}, main: $main type: $type]"
    }
}