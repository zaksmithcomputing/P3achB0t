package com.p3achb0t.client

import com.p3achb0t._runestar_interfaces.Client
import com.p3achb0t.api.AbstractScript
import com.p3achb0t.client.loader.ConfigReader
import com.p3achb0t.client.loader.RSAppletStub
import com.p3achb0t.client.configs.Constants
import com.p3achb0t.client.util.JarLoader
import com.p3achb0t.interfaces.IScriptManager
import com.p3achb0t.interfaces.PrintScript
import com.p3achb0t.interfaces.ScriptHook
import com.p3achb0t.interfaces.ScriptManager

import java.applet.Applet
import java.awt.Dimension

enum class ClientState {
    RUNNING, PAUSED, STOPPED
}

class Game(world: Int) {

    private var applet: Applet
    var client: Client
    var scriptHook: IScriptManager

    /**
     * Constructor
     */
    init {
        val configReader = ConfigReader(world)
        val map = configReader.read()

        //println("./${Constants.APPLICATION_CACHE_DIR}/${Constants.INJECTED_JAR_NAME}")
        val clientClazz = JarLoader.load("./${Constants.APPLICATION_CACHE_DIR}/${Constants.INJECTED_JAR_NAME}","client")
        client = clientClazz as Client
        applet = clientClazz as Applet
        scriptHook = clientClazz as IScriptManager

        val appletStub = RSAppletStub(map)
        appletStub.appletContext.setApplet(applet)
        applet.setStub(appletStub)
        appletStub.appletResize(800,600);
        //appletStub.isActive = true
        applet.preferredSize = Dimension(800,600)
        applet.setSize(800,600)// = Dimension(800,600)
        applet.validate()
        applet.init()
        applet.validate()


    }

    fun getApplet() : Applet {
        return applet
    }

    fun setScript() {

    }
}
