package com.p3achb0t.api.wrappers

import com.p3achb0t._runestar_interfaces.Model
import com.p3achb0t._runestar_interfaces.Scenery
import com.p3achb0t._runestar_interfaces.Wall
import com.p3achb0t.api.Context
import com.p3achb0t.api.user_inputs.DoActionParams
import com.p3achb0t.api.wrappers.interfaces.Interactable
import com.p3achb0t.api.wrappers.interfaces.Locatable
import com.p3achb0t.api.wrappers.utils.Calculations
import com.p3achb0t.api.wrappers.utils.ObjectPositionInfo
import com.p3achb0t.api.wrappers.utils.getConvexHullFromModel
import com.p3achb0t.api.wrappers.utils.getTrianglesFromModel
import com.p3achb0t.scripts.paint_debug.getObjectComposite
import net.runelite.api.MenuOpcode
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point
import java.awt.Polygon
import java.util.*

class GameObject(
        val sceneryObject: Scenery? = null,
        val wallObject: Wall? = null,
        ctx: Context? = null,
        override var loc_ctx: Context? = ctx
) : Locatable,
        Interactable(ctx) {
    val id: Int
        get() {
            return when {
                sceneryObject != null -> sceneryObject.getTag().shr(17).and(0x7fff).toInt()
                wallObject != null -> wallObject.getTag().shr(17).and(0x7fff).toInt()
                else -> 0
            }
        }
    val name: String
        get() {
            val sceneData = ctx?.client?.getLocType_cached()
            val objectComposite = sceneData?.let { getObjectComposite(it, id) }
            return objectComposite?.getName().toString()
        }
    private val objectPositionInfo: ObjectPositionInfo
        get() {
            return when {
                sceneryObject != null -> ObjectPositionInfo(
                        sceneryObject.getCenterX(),
                        sceneryObject.getCenterY(),
                        sceneryObject.getOrientation()
                )
                wallObject != null -> ObjectPositionInfo(
                        wallObject.getX(),
                        wallObject.getY(),
                        wallObject.getOrientationA()
                )
                else -> ObjectPositionInfo(0, 0, 0)
            }
        }
    val model: Model?
        get() {
            return when {
                sceneryObject != null -> sceneryObject.getEntity() as Model
                wallObject != null -> wallObject.getEntity1() as Model
                else -> null
            }
        }
    override fun isMouseOverObj(): Boolean {
        val mousePoint = Point(ctx?.mouse?.getX() ?: -1, ctx?.mouse?.getY() ?: -1)
        return getConvexHull().contains(mousePoint)
    }
    override fun getNamePoint(): Point {
        val region = getRegionalLocation()
        return ctx?.let { Calculations.worldToScreen(region.x, region.y, sceneryObject?.getHeight() ?: 0, it) } ?: Point(0,0)
    }
    override suspend fun clickOnMiniMap(): Boolean {
        return when {
            sceneryObject != null -> ctx?.mouse?.click(
                    ctx?.let {
                        Calculations.worldToMiniMap(
                                sceneryObject.getCenterX(),
                                sceneryObject.getCenterY(),
                                it
                        )
                    } ?: Point(0,0)
            )?: false
            wallObject != null -> ctx?.mouse?.click(
                    ctx?.let {
                        Calculations.worldToMiniMap(
                                wallObject.getX(),
                                wallObject.getY(),
                                it
                        )
                    }?: Point(0,0)
            )?: false
            else -> false
        }
    }

    override fun getInteractPoint(): Point {
        return getRandomPoint(getConvexHull())
    }

    override fun draw(g: Graphics2D) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun draw(g: Graphics2D, color: Color) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGlobalLocation(): Tile {
        if (ctx?.client != null) {
            return when {
                sceneryObject != null -> Tile(
                        sceneryObject.getCenterX() / 128 + ctx?.client!!.getBaseX(),
                        sceneryObject.getCenterY() / 128 + ctx?.client!!.getBaseY(),
                        sceneryObject.getPlane(),ctx

                )
                wallObject != null -> Tile(
                        wallObject.getX() / 128 + ctx?.client!!.getBaseX(),
                        wallObject.getY() / 128 + ctx?.client!!.getBaseY(),
                        sceneryObject?.getPlane() ?: 0,ctx

                )
                else -> Tile(-1, -1, ctx = ctx)
            }
        }else{
            return Tile()
        }
    }


    override fun isOnScreen(): Boolean {
        return ctx?.let { Calculations.isOnscreen(it,getConvexHull().bounds ) } ?: false
    }

    fun getTriangles(): ArrayList<Polygon> {

        return if (model != null) {
            val positionInfo =
                    objectPositionInfo

            val modelTriangles =
                    getTrianglesFromModel(positionInfo, model!!, ctx!!)

            modelTriangles
        } else {
            ArrayList()
        }
    }


    /**
     * added by sirscript
     * doaction (local location.x + y and id of the gameobject it seems like MenuOpcode.GAME_OBJECT_SECOND_OPTION is the first option usually for the opcode
     * offsetX & offsetY: sometimes the location of the object needs to be offset and there is a way to provide this
     *
     */

    suspend fun doAction(offsetX: Int = 0, offsetY: Int = 0, offsetID: Int = 0) {
        val scenebasex = ctx?.client?.getBaseX()
        val scenebasey = ctx?.client?.getBaseY()
        val localLocation = this.getLocalLocation()
        val X = localLocation.x
        val Y = localLocation.y
        if(scenebasex != null && scenebasey != null) {
            //I am not sure why but doing x.plus is actually doing a minus which usually is the kind of offset that we are looking for
            val doActionParams = DoActionParams(localLocation.x.plus(offsetX), localLocation.y.plus(offsetY), MenuOpcode.GAME_OBJECT_FIRST_OPTION.id, this.id.plus(offsetID), "", "", 0, 0)
            ctx?.mouse?.overrideDoActionParams = true
            ctx?.mouse?.doAction(doActionParams)
        }
    }

    suspend fun doAction2(opcode: MenuOpcode = MenuOpcode.GAME_OBJECT_SECOND_OPTION) {
        val doActionParams = DoActionParams(getLocalLocation().x, getLocalLocation().y, opcode.id, id, "", "", 0 ,0)
        ctx?.mouse?.overrideDoActionParams = true
        ctx?.mouse?.doAction(doActionParams)
    }

    suspend fun doAction3(opcode: MenuOpcode = MenuOpcode.GAME_OBJECT_THIRD_OPTION) {
        val doActionParams = DoActionParams(getLocalLocation().x, getLocalLocation().y, opcode.id, id, "", "", 0 ,0)
        ctx?.mouse?.overrideDoActionParams = true
        ctx?.mouse?.doAction(doActionParams)
    }

    suspend fun doAction4(opcode: MenuOpcode = MenuOpcode.GAME_OBJECT_FOURTH_OPTION) {
        val doActionParams = DoActionParams(getLocalLocation().x, getLocalLocation().y, opcode.id, id, "", "", 0 ,0)
        ctx?.mouse?.overrideDoActionParams = true
        ctx?.mouse?.doAction(doActionParams)
    }

    suspend fun doAction5(opcode: MenuOpcode = MenuOpcode.GAME_OBJECT_FIFTH_OPTION) {
        val doActionParams = DoActionParams(getLocalLocation().x, getLocalLocation().y, opcode.id, id, "", "", 0 ,0)
        ctx?.mouse?.overrideDoActionParams = true
        ctx?.mouse?.doAction(doActionParams)
    }

    suspend fun useItemOn(opcode: MenuOpcode = MenuOpcode.ITEM_USE_ON_GAME_OBJECT, offsetX: Int = 0, offsetY: Int = 0, offsetID: Int = 0) {
        val doActionParams = DoActionParams(getLocalLocation().x.plus(offsetX), getLocalLocation().y.plus(offsetY), opcode.id, id.plus(offsetID), "", "", 0 ,0)
        ctx?.mouse?.overrideDoActionParams = true
        ctx?.mouse?.doAction(doActionParams)
    }

    fun getConvexHull(): Polygon {
        val positionInfo = objectPositionInfo
        return when {
            sceneryObject != null -> getConvexHullFromModel(positionInfo, sceneryObject.getEntity() as Model, ctx!!)
            wallObject != null -> getConvexHullFromModel(positionInfo, wallObject.getEntity1() as Model, ctx!!)
            else -> Polygon()
        }
    }

}
