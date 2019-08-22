package com.p3achb0t.loader

import com.p3achb0t.ui.GlobalConfigs
import com.p3achb0t.ui.components.Constants
import com.p3achb0t.util.Util
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels
import java.nio.file.Paths

class Loader {

    fun run() : String {
        return downloadGamePack()

    }

    private fun setup() {

    }

    private fun downloadGamePack() : String {
        val isUptoDate = Util.checkClientRevision(Constants.REVISION, 5000)

        if (isUptoDate && isLocal()) {
            return isLocalGamepack()

        } else {
            // clean -> Download TODO clean
            download()
            return isLocalGamepack()
        }
    }

    private fun download() {
        val gamepackName = getLatestGamepackName()
        println("Gamepack not found locally...downloading pack")
        val gamepackURL = URL(Constants.GAME_WORLD_URL + "/" + gamepackName)
        val readableByteChannel = Channels.newChannel(gamepackURL.openStream())
        val fileOutStream = FileOutputStream(Paths.get(Constants.USER_DIR, Constants.APPLICATION_CACHE_DIR, Constants.JARS_DIR, gamepackName).toString())
        val fileChannel = fileOutStream.channel
        fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE)
        println("$gamepackName downloaded!")
        //return Paths.get(Constants.APPLICATION_CACHE_DIR, Constants.JARS_DIR, gamepackName).toString()

    }

    private fun isLocal() : Boolean {
        File(Paths.get(Constants.USER_DIR, Constants.APPLICATION_CACHE_DIR, Constants.JARS_DIR).toString()).walk().forEach {
            if (it.name.toString().contains(".jar")) {
                return true
            }
        }
        return false
    }

    private fun isLocalGamepack() : String {
        File(Paths.get(Constants.USER_DIR, Constants.APPLICATION_CACHE_DIR, Constants.JARS_DIR).toString()).walk().forEach {
            if (it.name.toString().contains(".jar")) {
                return Paths.get(Constants.USER_DIR, Constants.APPLICATION_CACHE_DIR, Constants.JARS_DIR, it.name).toString()
            }
        }
        return ""
    }

    private fun getLatestGamepackName() : String {
        val dom = URL(Constants.GAME_WORLD_URL)
        val connection = dom.openConnection()
        connection.connect()
        val res = connection.inputStream.bufferedReader().readText()
        for (line in res.split("\n")) {
            if (line.contains("archive=")) {
                val strReplace = "g.*.jar"
                val gamePack = getRegSelection(strReplace, line)
                println("Current game pack: " + gamePack)
                return gamePack
            }
        }
        return ""
    }

    private fun getRegSelection(strReplace: String, line: String): String {
        val reg = strReplace.toRegex()
        val res = reg.find(line)?.value
        res.let { return it!! }
    }
}

/*
private var oldschoolPageAddress: String = "http://oldschool83.runescape.com/"
    val gamepackDir = "/gamepacks/"
    fun getGamepack():String{
        if (!Files.exists(Paths.get("./gamepacks"))) {
            Files.createDirectory(Paths.get("./gamepacks"))
        }
        val gamepackName = getLatestGamepackName()
        var gamepackFound = isGamepackDonloadedLocally(gamepackName)
        if(!gamepackFound){
            //Download gamepack
            println("Gamepack not found locally...downloading pack")
            val gamepackURL = URL(oldschoolPageAddress + gamepackName)
            var readableByteChannel = Channels.newChannel(gamepackURL.openStream())
            val path = System.getProperty("user.dir")
            var fileOutStream = FileOutputStream(path + gamepackDir + gamepackName)
            var fileChannel = fileOutStream.channel
            fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE)
            println("$gamepackName downloaded!")
            return path + gamepackDir + gamepackName
        }
        return ""
    }

    fun getLocalGamepack():String{
        val path = System.getProperty("user.dir")
        File(path + gamepackDir).walk().forEach {
            if (it.name.toString().contains(".jar")) {
                return path + gamepackDir + it.name
            }
        }
        return path + gamepackDir
    }

    private fun isGamepackDonloadedLocally(gamepackName: String): Boolean {
        //Check to see if we already have this game pack
        val path = System.getProperty("user.dir")
        var gamepackFound = false
        File(path + gamepackDir).walk().forEach {
            if (it.name.toString() == gamepackName) {
                println(it.name)
                gamepackFound = true
            }
        }
        return gamepackFound
    }

    private fun getLatestGamepackName():String {
        val pageURL = URL(this.oldschoolPageAddress)
        val connection = pageURL.openConnection()
        connection.connect()
        val res = connection.inputStream.bufferedReader().readText()
        for (line in res.split("\n")) {
//            println(line)
            if (line.contains("archive=")) {
                val strReplace = "g.*.jar"
                val gamePack = getRegSelection(strReplace, line)
                println("Current game pack: " + gamePack)
                return gamePack
            }
        }
        return ""
    }

    private fun getRegSelection(strReplace: String, line: String): String {
        val reg = strReplace.toRegex()
        val res = reg.find(line)?.value
        res.let { return it!! }
    }
 */