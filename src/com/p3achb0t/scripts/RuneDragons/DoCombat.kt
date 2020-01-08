import com.p3achb0t.api.Context
import com.p3achb0t.api.Utils
import com.p3achb0t.api.wrappers.Area
import com.p3achb0t.api.wrappers.Tile
import com.p3achb0t.api.wrappers.tabs.Prayer
import com.p3achb0t.scripts.RuneDragsMain
import com.p3achb0t.scripts.Task
import kotlinx.coroutines.delay
import kotlin.random.Random

class doCombat(val ctx: Context) : Task(ctx.client) {
    override suspend fun isValidToRun(): Boolean {
        val combatArea = Area(
                Tile(1575, 5086, ctx = ctx),
                Tile(1597, 5062, ctx = ctx), ctx = ctx
        )
        return !RuneDragsMain.shouldBank(ctx) && combatArea.containsOrIntersects(ctx.players.getLocal().getGlobalLocation()) && RuneDragsMain.canFightNext(ctx)
    }

    var firsttrip = true
    override suspend fun execute() {
        val loot: IntArray = intArrayOf(2363, 1127, 1079, 1303, 1347, 4087, 4180, 4585, 1149, 892, 21880, 562, 560, 212, 208, 3052, 220, 19580, 9381, 1616, 452, 19582,
                21930, 995, 21918, 22103, 11286, 1333, 536)
        val groundloot = ctx.groundItems.getItempred(loot)
        val combatArea = Area(
                Tile(1575, 5086, ctx = ctx),
                Tile(1597, 5062, ctx = ctx), ctx = ctx
        )


        val antifires = hashSetOf(11951, 11953, 11955, 11957)
        val divinecombats = hashSetOf(23685, 23688, 23691, 23694)
        val prayerpots: IntArray = intArrayOf(143, 141, 139, 2434)
        if (!ctx.prayer.isProtectMageActive()) {
            ctx.prayer.activate(Prayer.Companion.PrayerKind.PROTECT_FROM_MAGIC)
        }
        if (!ctx.prayer.isPietyActive()) {
            ctx.prayer.activate(Prayer.Companion.PrayerKind.PIETY)
        }
        if (Utils.getElapsedSeconds(RuneDragsMain.Antifiretimer.time) > 720 || firsttrip) {
            antifires.forEach {
                if (ctx.inventory.Contains(it)) {
                    println("using antifire")
                    ctx.inventory.getItem(it)?.click()
                    RuneDragsMain.Antifiretimer.reset()
                }
            }
            delay(2000)
        }
        if (Utils.getElapsedSeconds(RuneDragsMain.Divinepottimer.time) > 300 || firsttrip) {
            divinecombats.forEach {
                if (ctx.inventory.Contains(it)) {
                    println("using combats")
                    ctx.inventory.getItem(it)?.click()
                    RuneDragsMain.Divinepottimer.reset()
                    firsttrip = false
                }
            }
            delay(600)
        }
        if (ctx.players.getLocal().getHealth() < 56) {
            ctx.inventory.getItem(385)?.click()
            delay(1500)
        }
        run prayerpots@{
            if (ctx.players.getLocal().getPrayer() < 60) {
                prayerpots.forEach {
                    if (ctx.inventory.Contains(it)) {
                        ctx.inventory.getItem(it)?.click()
                        delay(500)
                    }
                    if (ctx.players.getLocal().getPrayer() >= 60) {
                        return@prayerpots
                    }
                }
            }
        }
        val Barrier = ctx.gameObjects.find("Barrier", sortByDistance = true)
        if (Barrier.size > 0) {
            if (Barrier[0].distanceTo() < 2) {
                combatArea.getCentralTile().clickOnMiniMap()
                delay(Random.nextLong(1500, 2500))
            }
        }
        if (groundloot.isEmpty()) {
            if (ctx.players.getLocal().player.getTargetIndex() == -1 && !ctx.npcs.isTargetted()) {
                println("Getting new target")
                if (ctx.camera.pitch < 60) {
                    ctx.camera.setHighPitch()
                }
                val dragon = ctx.npcs.nearestAttackableNpc("Rune dragon")
                if (dragon.size > 0) {
                    println("npc size > 0")
                    try {
                        if (dragon[0].distanceTo() >= 6) {
                            dragon[0].getGlobalLocation().clickOnMiniMap(dragon[0].npc.getX() - 2, dragon[0].npc.getY() - 2)
                            delay(800)
                        }
                        if (!dragon[0].isOnScreen())
                            dragon[0].turnTo()
                        println("turning to npc")
                        if (dragon[0].isOnScreen())
                            dragon[0].clickNPC(dragon[0])
                        println("attacking npc")
                        Utils.waitFor(2, object : Utils.Condition {
                            override suspend fun accept(): Boolean {
                                delay(100)
                                return ctx.players.getLocal().player.getTargetIndex() != -1
                            }
                        })
                    } catch (e: Exception) {
                        println("Error: NPC " + e.message)
                        e.stackTrace.iterator().forEach {
                            println(it)
                        }
                    }

                }
            }
            if (ctx.players.getLocal().player.getTargetIndex() == -1 && ctx.npcs.isTargetted()) {
                println("being attacked - locating target")
                if (ctx.camera.pitch < 60) {
                    ctx.camera.setHighPitch()
                }
                val dragon = ctx.npcs.getTargetted("Rune dragon")
                if (dragon != null) {
                    try {
                        if (dragon.distanceTo() >= 6) {
                            dragon.getGlobalLocation().clickOnMiniMap(dragon.npc.getX() - 2, dragon.npc.getY() - 2)
                            delay(400)
                        }
                        if (!dragon.isOnScreen())
                            dragon.turnTo()
                        if (dragon.isOnScreen())
                            dragon.clickNPC(dragon)
                        Utils.waitFor(2, object : Utils.Condition {
                            override suspend fun accept(): Boolean {
                                delay(100)
                                return ctx.players.getLocal().player.getTargetIndex() != -1
                            }
                        })
                    } catch (e: Exception) {
                        println("Error: NPC " + e.message)
                        e.stackTrace.iterator().forEach {
                            println(it)
                        }
                    }

                }
            }
        }

        if (!groundloot.isEmpty()) {
            println("item found")
            groundloot.forEach {
                if (ctx.inventory.isFull()) {
                    ctx.inventory.getItem(385)?.click()
                    delay(400)
                }
                if (!ctx.inventory.isFull()) {
                    try {
                        if (!it.isOnScreen()) {
                            if (it.distanceTo() > 5) {
                                it.clickOnMiniMap()
                                delay(800)
                            }
                            it.turnTo()
                            Utils.waitFor(3, object : Utils.Condition {
                                override suspend fun accept(): Boolean {
                                    delay(100)
                                    return it.isOnScreen()
                                }
                            })
                        }
                        if (it.isOnScreen()) {
                            it.interact("Take")
                        }


                    } catch (e: Exception) {
                        println("Error: NPC " + e.message)
                        e.stackTrace.iterator().forEach {
                            println(it)
                        }
                    }
                }
            }
        }
    }
}
