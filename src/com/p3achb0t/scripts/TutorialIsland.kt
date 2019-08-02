package com.p3achb0t.scripts

import com.p3achb0t.Main
import com.p3achb0t.api.Calculations
import com.p3achb0t.api.Utils
import com.p3achb0t.api.user_inputs.Camera
import com.p3achb0t.api.user_inputs.Keyboard
import com.p3achb0t.api.wrappers.*
import com.p3achb0t.api.wrappers.tabs.Equipment
import com.p3achb0t.api.wrappers.tabs.Inventory
import com.p3achb0t.api.wrappers.tabs.Magic
import com.p3achb0t.api.wrappers.tabs.Tabs
import com.p3achb0t.api.wrappers.widgets.WidgetItem
import com.p3achb0t.api.wrappers.widgets.Widgets
import com.p3achb0t.hook_interfaces.Widget
import kotlinx.coroutines.delay
import kotlin.random.Random


private val SHRIMP_ID = 2514
private val LOGS_ID_2511 = 2511

class TutorialIsland {

    companion object {

        val names = arrayListOf(
            "PapaBadass", "randomBJ", "kamalchettiar", "all_negative_", "s0meguy",
            "shouldidivorce", "kisskross", "ccnelson", "w4rf19ht3r", "lili999", "qwerqtwfnhnqufh"
        )

        var isInititilized = false
        val jobs = ArrayList<Job>()
        fun init() {
            jobs.add(PickName())
            jobs.add(SelectCharOutfit())
            jobs.add(ChatWithGielinorGuide())
            jobs.add(OpenOptions())
            jobs.add(FinalChatWithGielinor())
            jobs.add(OpenDoorFromFirstBuilding())
            jobs.add(turnOffRoofsAndSound())
            jobs.add(MoveToFishingSpot())
            jobs.add(TalkToSurvivalExpertFirstTime())
            jobs.add(OpenInvetory())
            jobs.add(CatchSomeShrimp())
            jobs.add(ClickSkillsTab())
            jobs.add(TalkToSurvivalGuideAfterSkillsTab())
            jobs.add(ChopTree())
            jobs.add(LightLog())
            jobs.add(CookShrimp())
            jobs.add(OpenGateAfterFishing())
            jobs.add(MoveToKitchen())
            jobs.add(TalkToMasterChef())
            jobs.add(MakeDough())
            jobs.add(MakeBread())
            jobs.add(ExitKitchen())
            jobs.add(TurnOnRun())
            jobs.add(MoveToNextBuilding())
            jobs.add(TalkToQuestGuide())
            jobs.add(OpenQuestList())
            jobs.add(TalkToQuestGuide2ndTime())
            jobs.add(GoDownToTheCaves())
            jobs.add(WalkAndTalkToSmitingAndMiningGuide())
            jobs.add(MineTin())
            jobs.add(MineCopper())
            jobs.add(SmeltBronze())
            jobs.add(TalkToMiningGuideAboutSmiting())
            jobs.add(MakeBronzeDagger())
            jobs.add(AfterSmithingMovetoGate())
            jobs.add(TalkToCombatInstructor())
            jobs.add(OpenEquipment())
            jobs.add(OpenEquipmentStats())
            jobs.add(EquipBronzeDagger())
            jobs.add(SpeakWithCombatAfterBronzeDaggerEquipt())
            jobs.add(EquipLongSwordAndShield())
            jobs.add(OpenCombatTab())
            jobs.add(GoIntoRatCage())
            jobs.add(MeleeKillRat())
            jobs.add(GoTalkToCombatInstructorFor2ndTime())
            jobs.add(KillRatWithBow())
            jobs.add(ExitCaves())
            jobs.add(UseBank())
            jobs.add(CloseBankAndDoPollBooth())
            jobs.add(DoPollBooth())
            jobs.add(ClosePollAndMoveOutOfBank())
            jobs.add(TalkToAccountManager())
            jobs.add(OpenAccountManager())
            jobs.add(ExitAccountManagerRoom())
            jobs.add(MoveToChapelAndTalkToBrotherBrace())
            jobs.add(OpenPrayerTab())
            jobs.add(OpenFriendsTab())
            jobs.add(ExitChapleHouse())
            jobs.add(GoToWizardHouseAndSpeakWithWizard())
            jobs.add(OpenMagicTab())
            jobs.add(SelectWindStrikeAndAttackChicken())
            jobs.add(ExitTutIsland())
            jobs.add(MainlandLogout())
            isInititilized = true
        }

        suspend fun run() {
            if (!isInititilized) init()
            jobs.forEach {
                val chatBox = WidgetItem(Widgets.find(263, 1))
                if (it.isValidToRun(chatBox)) {
                    println("Running: ${it.javaClass.name}")
                    it.execute()
                    println("Completed: ${it.javaClass.name}")
                }
            }
        }

        fun getPercentComplete(): Double {
            // widget for progress 614,18
            val complete = WidgetItem(Widgets.find(614, 18)).widget?.getWidth()?.toDouble() ?: 0.0
            //widget for total 614, 17
            val total = WidgetItem(Widgets.find(614, 17)).widget?.getWidth()?.toDouble() ?: 0.0

            return (complete / total)
        }

        class PickName : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return Widgets.isWidgetAvaliable(558, 0)
            }

            override suspend fun execute() {
                println("Picking name")
                //Name widget to click into and type a name 558,7
                val nameEntry = WidgetItem(Widgets.find(558, 7))
                nameEntry.click()
                delay(Random.nextLong(2200, 5550))

                Keyboard.sendKeys(names.random(), sendReturn = true)
                delay(Random.nextLong(2200, 5550))

                // If not a valid name then random name in the follow selections 558,(14,15,16)
                // Once picked It should say available in 558,12
                val validName = WidgetItem(Widgets.find(558, 12))
                if (validName.widget?.getText()?.toLowerCase()?.contains("great!")!!) {
                    println("Found Valid name!")
                } else {
                    val rand = Random.nextInt(14, 16)
                    val selectRandomName = WidgetItem(Widgets.find(558, rand))
                    selectRandomName.click()
                    delay(Random.nextLong(2200, 5550))
                }
                //Pick set name in 558,18
                val pickName = WidgetItem(Widgets.find(558, 18))
                pickName.click()
                delay(Random.nextLong(2200, 5550))
                Utils.waitFor(4, object : Utils.Condition {
                    override suspend fun accept(): Boolean {
                        delay(100)
                        return !Widgets.isWidgetAvaliable(558, 0)
                    }
                })
                println("Picking name complete")


            }

        }

        class SelectCharOutfit : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return Widgets.isWidgetAvaliable(269, 0)
            }

            override suspend fun execute() {
                val randomNumberOfChanges = Random.nextInt(4, 35)
                println("Making $randomNumberOfChanges of changes")
                for (i in 0..randomNumberOfChanges) {
                    val column = Random.nextInt(1, 5)
                    val widgetIndex = Widget.WidgetIndex("269", "0")
                    when (column) {
                        1 -> widgetIndex.childID = (106..112).random().toString()
                        2 -> widgetIndex.childID = (113..119).random().toString()
                        3 -> widgetIndex.childID = arrayListOf(125, 124, 123, 122, 105).random().toString()
                        4 -> widgetIndex.childID = arrayListOf(131, 130, 129, 127, 121).random().toString()
                    }
                    for (i in 0..Random.nextInt(5)) {
                        WidgetItem(Widgets.find(widgetIndex.parentID.toInt(), widgetIndex.childID.toInt())).click()
                        delay(Random.nextLong(250, 650))
                    }
                }
                //Randomly pick if you are going to be afemale
                if (Random.nextBoolean()) {
                    println("Picking Female")
                    WidgetItem(Widgets.find(269, 139)).click()
                    delay(Random.nextLong(250, 650))
                } else {
                    println("Leaving male")
                }
                //select accept
                WidgetItem(Widgets.find(269, 99)).click()
                delay(Random.nextLong(1250, 2650))
                println("Completed Character outfit")
            }

        }

        class ChatWithGielinorGuide : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Before you begin, have a read"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                println("Time to interact with Gielinor Guide")
                val gielinorGuide = NPCs.findNpc("Gielinor Guide")[0]
                gielinorGuide.interact("Talk-to")
                Utils.waitFor(5, object : Utils.Condition {
                    override suspend fun accept(): Boolean {
                        delay(100)
                        return Dialog.isDialogUp()
                    }
                })
                Dialog.continueDialog()
                Dialog.selectRandomOption()
                delay(Random.nextLong(1250, 1650))
                Dialog.continueDialog()
                println("Interact with Gielinor Guide Complete")
            }

        }

        class OpenOptions : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return Tabs.isTabFlashing(Tabs.Tab_Types.Options)
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.Options)
                delay(Random.nextLong(1250, 1650))
            }

        }

        class turnOffRoofsAndSound : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return Players.getLocal().getGlobalLocation().x == 3098
                        && Players.getLocal().getGlobalLocation().y == 3107
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.Options)
                delay(Random.nextLong(500, 1500))
                //Display settings(261,1)child 1
                WidgetItem(Widgets.find(261, 1)?.getChildren()?.get(1)).click()
                delay(Random.nextLong(500, 1500))
                //Advanced options(261,35
                WidgetItem(Widgets.find(261, 35)).click()
                delay(Random.nextLong(500, 1500))
                //Turn off roofs(60,14). Texture Id when on is 762
                Widgets.waitTillWidgetNotNull(60, 14)
                val roofToggle = Widgets.find(60, 14)
                if (roofToggle?.getTextureId() == 761) {
                    WidgetItem(Widgets.find(60, 14)).click()
                    delay(Random.nextLong(500, 1500))
                }
                //Close out of Advanced options widget(60,2) child index 3
                WidgetItem(Widgets.find(60, 2)?.getChildren()?.get(3)).click()

                //Turn off music
                //Open audio section
                WidgetItem(Widgets.find(261, 1)?.getChildren()?.get(3)).click()
                delay(Random.nextLong(300, 700))
                WidgetItem(Widgets.find(261, 43)).click()
                delay(Random.nextLong(300, 700))
                WidgetItem(Widgets.find(261, 51)).click()
                delay(Random.nextLong(300, 700))
                WidgetItem(Widgets.find(261, 57)).click()

            }

        }

        class FinalChatWithGielinor : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "On the side"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                println("Time to interact with Gielinor Guide")
                val gielinorGuide = NPCs.findNpc("Gielinor Guide")[0]
                gielinorGuide.interact("Talk-to")
                Utils.waitFor(5, object : Utils.Condition {
                    override suspend fun accept(): Boolean {
                        delay(100)
                        return Dialog.isDialogUp()
                    }
                })
                Dialog.continueDialog()
                println("Finished final chat with Gielinor")
            }

        }

        class OpenDoorFromFirstBuilding : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "time to meet your first instructor"
                return dialogWidget.containsText(text)

            }

            override suspend fun execute() {
                println("START: Opening door and walking to fishing spot")
                // Get doors, find one at location(3098,3107), and open it
                val gameObjects = GameObjects.find(9398)
                val doorLocation = Tile(3098, 3107)
                gameObjects.forEach {
                    if (it.getGlobalLocation().x == doorLocation.x && it.getGlobalLocation().y == doorLocation.y) {
                        if (!it.isOnScreen()) it.turnTo()
                        it.interact("Open")
                        //Wait till here Tile(3098,3107)
                        Utils.waitFor(4, object : Utils.Condition {
                            override suspend fun accept(): Boolean {
                                delay(100)
                                return Players.getLocal().getGlobalLocation() == Tile(3098, 3107)
                            }
                        })
                    }
                }
            }

        }

        class MoveToFishingSpot : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Follow the path to find the next instructor"
                val chatBox = WidgetItem(Widgets.find(263, 1))
                val doorLocation = Tile(3098, 3107)
                val playerGlobalLoc = Players.getLocal().getGlobalLocation()

                return chatBox.containsText(text) && (playerGlobalLoc.x == doorLocation.x && playerGlobalLoc.y == doorLocation.y)
            }

            override suspend fun execute() {
                val path = arrayListOf(Tile(3098, 3107), Tile(3103, 3103), Tile(3102, 3095))
                Walking.walkPath(path)
                println("COMPLETE : Opening door and walking to fishing spot")
            }
        }

        class TalkToSurvivalExpertFirstTime : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val survivalExpert = NPCs.findNpc(8503)
                val text = "Follow the path to find the next instructor"
                val chatBox = WidgetItem(Widgets.find(263, 1))
                return chatBox.containsText(text) && survivalExpert.size > 0 && survivalExpert[0].isOnScreen()
            }

            override suspend fun execute() {
                val survivalExpert = NPCs.findNpc(8503)
                survivalExpert[0].talkTo()
                // WAit till the continue is avaliable
                Utils.waitFor(4, object : Utils.Condition {
                    override suspend fun accept(): Boolean {
                        delay(100)
                        return Players.getLocal().isIdle()
                    }
                })

                Dialog.continueDialog()
            }

        }

        class OpenInvetory : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("To view the item you've been given, you'll")
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.Inventory)
            }

        }

        class CatchSomeShrimp : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "catch some shrimp"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                catchShrimp()

                if (Tabs.isTabFlashing(Tabs.Tab_Types.Skills)) {
                    Tabs.openTab(Tabs.Tab_Types.Skills)
                }
            }
        }

        private suspend fun catchShrimp() {
            val shrimps = NPCs.findNpc(3317)
            shrimps[0].turnTo()
            shrimps[0].interact("Net")
            // Wait till shrimp is in Inventory
            Utils.waitFor(10, object : Utils.Condition {
                override suspend fun accept(): Boolean {
                    delay(100)
                    return Inventory.getCount(SHRIMP_ID) > 0
                }
            })
        }

        class ClickSkillsTab : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "on the flashing bar graph icon near the inventory"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.Skills)
            }
        }

        class TalkToSurvivalGuideAfterSkillsTab : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "this menu you can view your skills."
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                val survivalExpert = NPCs.findNpc(8503)
                survivalExpert[0].talkTo()
                // WAit till the continue is avaliable
                Utils.waitFor(4, object : Utils.Condition {
                    override suspend fun accept(): Boolean {
                        delay(100)
                        return Dialog.isDialogUp()
                    }
                })

                Dialog.continueDialog()

            }

        }

        class ChopTree : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "time to cook your shrimp. However, you require"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                chopTree()

                Dialog.continueDialog()


            }

        }

        private suspend fun chopTree() {
            val trees = GameObjects.find(9730, sortByDistance = true)
            // Should be more than 4, lets pick a random one between 1 and 4
            trees[Random.nextInt(0, 3)].interact("Chop")

            // Wait till we get a log in the invetory.
            Utils.waitFor(4, object : Utils.Condition {
                override suspend fun accept(): Boolean {
                    delay(100)
                    return Inventory.getCount(LOGS_ID_2511) > 0
                }
            })
        }

        class LightLog : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "that you have some logs, it's time"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                // Use tinderbox(590) with logs(2511)
                lightFire()
            }

        }

        private suspend fun lightFire() {
            Inventory.open()
            Inventory.getItem(590)?.click()
            Inventory.getItem(LOGS_ID_2511)?.click()
            delay(Random.nextLong(2500, 4500))
            //Wait till hes not doing anything which should mean fire has been made
            Utils.waitFor(4, object : Utils.Condition {
                override suspend fun accept(): Boolean {
                    delay(100)
                    return Players.getLocal().player.getAnimation() == -1
                }
            })
        }

        class CookShrimp : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Now it's time to get cooking."
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                // Check to make sure we have shrimp, If not go fish for them
                if (Inventory.getCount(SHRIMP_ID) == 0) {
                    catchShrimp()
                }

                var fires = GameObjects.find(26185, sortByDistance = true)
                //No fire & no logs
                if (fires.size == 0 && Inventory.getCount(LOGS_ID_2511) == 0) {
                    chopTree()
                }

                //If no fire && have logs, light a fire
                fires = GameObjects.find(26185, sortByDistance = true)
                if (fires.size == 0 && Inventory.getCount(LOGS_ID_2511) > 0) {
                    lightFire()
                }

                // Check if there is a fire cook the shrimp
                fires = GameObjects.find(26185, sortByDistance = true)
                if (fires.size > 0) {
                    Inventory.open()
                    Inventory.getItem(SHRIMP_ID)?.click()
                    // The fire is an animated object so it thows a NPE when trying to interacte with model.
                    if (fires[0].gameObject != null) {
                        val point = Calculations.worldToScreen(
                            fires[0].gameObject!!.getX(),
                            fires[0].gameObject!!.getY(),
                            0
                        )
                        Interact.interact(point, "Use")
                    }

                    //Wait till idle
                    Utils.waitFor(4, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return Players.getLocal().player.getAnimation() == -1
                        }
                    })
                    Dialog.continueDialog()
                }
            }
        }

        class OpenGateAfterFishing : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Well done, you've just cooked your first meal!"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                println("START: Going to open gate")
                // Open gate at 3090,3092
                val gateTile = Tile(3090, 3092, 0)
                println("Onscreen? ${gateTile.isOnScreen()}")
                if (gateTile.distanceTo() > 5) {
                    gateTile.clickOnMiniMap()
                    Utils.waitFor(10, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return gateTile.distanceTo() < 5
                        }
                    })
                }

                //Open gate at 9708 or 9470
                val gateIDs = arrayOf(9708, 9470)
                val gates = GameObjects.find(gateIDs.random(), sortByDistance = true)
                if (gates.size > 0) {
                    gates[0].turnTo()
                    gates[0].interact("Open")
                }
                println("Complete: Going to open gate")
            }

        }

        class MoveToKitchen : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Follow the path until you get to the door with the yellow arrow above it."
                val percentComplete = getPercentComplete()
                return dialogWidget.containsText(text) && percentComplete == .196875
            }

            override suspend fun execute() {
                val tile = Tile(3079, 3084, 0)
                if (tile.distanceTo() > 5) {
                    tile.clickOnMiniMap()
                    Utils.waitFor(10, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return tile.distanceTo() < 5
                        }
                    })
                }

                val gameObjects = GameObjects.find(9709, sortByDistance = true)
                if (gameObjects.size > 0) {
                    gameObjects[0].interact("Open")
                }
            }
        }

        class TalkToMasterChef : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Talk to the chef indicated"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                NPCs.findNpc(3305)[0].talkTo()

                delay(Random.nextLong(3000, 5000))

                Dialog.continueDialog()
            }
        }

        class MakeDough : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "This is the base for many meals"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                // Mix water(1929) and flower(2516)
                Inventory.getItem(1929)?.click()
                Inventory.getItem(2516)?.click()
                delay(Random.nextLong(1250, 1650))
                Dialog.continueDialog()


            }

        }

        class MakeBread : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Now you have made the dough,"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                //dough is 2307
                //Range is 9736
                Inventory.open()
                val range = GameObjects.find(9736)[0]
                Camera.turnTo(range)
                //TODO - Need to improve ineract when menu is full
                range.interact("Cook Range")
                // Wait till bread in inventory
                Utils.waitFor(4, object : Utils.Condition {
                    override suspend fun accept(): Boolean {
                        delay(100)
                        return Dialog.isDialogUp()
                    }
                })
                delay(Random.nextLong(1250, 1650))
                Dialog.continueDialog()

            }

        }

        class ExitKitchen : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "You've baked your first loaf of bread"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                //Location 3073,3090

                val tileNearDoor = Tile(3073, 3090)
                if (tileNearDoor.distanceTo() > 4) {
                    tileNearDoor.clickOnMiniMap()
                    Utils.waitFor(4, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return tileNearDoor.distanceTo() < 4
                        }
                    })
                }

                Camera.turnWest()

                //DOOR 9710
                val door = GameObjects.find(9710)
                if (door.size > 0) {
                    door[0].interact("Open Door")
                }
            }

        }

        class TurnOnRun : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "When navigating the world, you can either run or walk"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                Run.activateRun()
            }

        }

        class MoveToNextBuilding : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Follow the path to the next guide"
                return dialogWidget.containsText(text) && getPercentComplete() == .296875
            }

            override suspend fun execute() {
                val walkingPath = arrayListOf(
                    Tile(3073, 3103), Tile(3074, 3117),
                    Tile(3079, 3127), Tile(3086, 3127)
                )
                Walking.walkPath(walkingPath)
                //Open Door(9716)
                Camera.setHighPitch()
                Camera.turnSouth()
                val doors = GameObjects.find("Door", sortByDistance = true)
                if (doors.size > 0) {
                    doors[0].interact("Open Door")
                }


            }

        }

        class TalkToQuestGuide : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "It's time to learn about quests!"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                val questGuide = NPCs.findNpc("Quest Guide")
                if (questGuide.size > 0) {
                    if (!questGuide[0].isOnScreen()) Camera.turnTo(questGuide[0])
                    questGuide[0].interact("Talk-to Quest Guide")
                    Utils.waitFor(3, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return Players.getLocal().isIdle()
                        }
                    })
                    Dialog.continueDialog()
                }
            }
        }

        class OpenQuestList : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Click on the flashing icon to the left of your inventory."
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.QuestList)
            }

        }

        class TalkToQuestGuide2ndTime : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "This is your quest journal."
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                val questGuide = NPCs.findNpc("Quest Guide")
                if (questGuide.size > 0) {
                    if (!questGuide[0].isOnScreen()) Camera.turnTo(questGuide[0])
                    questGuide[0].interact("Talk-to Quest Guide")
                    Utils.waitFor(3, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return Players.getLocal().isIdle()
                        }
                    })
                    Dialog.continueDialog()
                }
            }
        }

        class GoDownToTheCaves : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "It's time to enter some caves"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                Camera.setHighPitch()
                // Go down ladder
                val ladder = GameObjects.find("Ladder")
                if (ladder.size > 0) {
                    Camera.turnTo(ladder[0])
                    ladder[0].interact("Climb-down Ladder")
                    delay(Random.nextLong(3500, 6400))
                }
            }

        }

        class WalkAndTalkToSmitingAndMiningGuide : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Next let's get you a weapon,"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                val walkingPath = arrayListOf(Tile(3079, 9512), Tile(3081, 9504))
                Walking.walkPath(walkingPath)
                val miningGuide = NPCs.findNpc("Mining Instructor")
                if (miningGuide.size > 0) {
                    Camera.setHighPitch()
                    if (!miningGuide[0].isOnScreen()) miningGuide[0].turnTo()
                    miningGuide[0].talkTo()
                    delay(Random.nextLong(1250, 3650))
                    Dialog.continueDialog()

                }
            }

        }

        class MineTin : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "It's quite simple really. To mine a rock, all you need"
                return dialogWidget.containsText(text)
                        || dialogWidget.containsText("Now that you have some copper ore,")
            }

            override suspend fun execute() {
                //walk to tile(3076,9505
                //Mine rocks
                val miningspot = Tile(3076, 9505, 0)
                miningspot.clickOnMiniMap()
                Players.getLocal().waitTillIdle()
                Camera.setHighPitch()
                mineRock()
            }
        }

        private suspend fun mineRock() {
            val rocks = GameObjects.find("Rocks", sortByDistance = true)
            if (rocks.size > 0) {
                val oldInventoryCount = Inventory.getCount()
                rocks[0].interact("Mine")
                Utils.waitFor(8, object : Utils.Condition {
                    override suspend fun accept(): Boolean {
                        delay(100)
                        return oldInventoryCount != Inventory.getCount()
                    }
                })
            }
            Dialog.continueDialog()
        }

        class MineCopper : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                val text = "Now that you have some tin ore"
                return dialogWidget.containsText(text)
            }

            override suspend fun execute() {
                val miningspot = Tile(3085, 9502, 0)
                if (miningspot.distanceTo() > 5) {
                    miningspot.clickOnMiniMap()
                    delay(Random.nextLong(3500, 5500))
                }
                Camera.setHighPitch()
                mineRock()
            }

        }

        class SmeltBronze : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You now have some tin ore and some copper ore.")
            }

            override suspend fun execute() {
                val miningspot = Tile(3079, 9498, 0)
                if (miningspot.distanceTo() > 3) {

                    miningspot.clickOnMiniMap()
                    Utils.waitFor(4, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return miningspot.distanceTo() < 3
                        }
                    })
                }

                val furnace = GameObjects.find("Furnace")[0]
                if (!furnace.isOnScreen()) furnace.turnTo()
                furnace.click()
            }

        }

        class TalkToMiningGuideAboutSmiting : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You've made a bronze bar!")
            }

            override suspend fun execute() {

                val miningGuide = NPCs.findNpc("Mining Instructor")
                if (miningGuide.size > 0) {
                    miningGuide[0].turnTo()
                    if (!miningGuide[0].isOnScreen()) {
                        Tile(3081, 9504).clickOnMiniMap()
                    }
                    miningGuide[0].talkTo()
                    delay(Random.nextLong(1250, 3650))
                    Dialog.continueDialog()

                }
            }

        }

        class MakeBronzeDagger : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("To smith you'll need a hammer") || dialogWidget.containsText("Use an anvil to open") || dialogWidget.containsText(
                    "Now you have the smithing"
                )
            }

            override suspend fun execute() {
                //Find Anvil
                val anvil = GameObjects.find("Anvil", sortByDistance = true)
                if (anvil.size > 0) {

                    val index = (0..1).random()
                    anvil[index].turnTo()
                    Inventory.open()
                    anvil[index].click()
                    Players.getLocal().waitTillIdle()
                    //Wait for smiting widgets
                    Widgets.waitTillWidgetNotNull(312, 2)

                    val oldInventoryCount = Inventory.getCount()
                    val daggerSmitingPage = WidgetItem(Widgets.find(312, 2)?.getChildren()?.get(2))
                    if (daggerSmitingPage.widget != null) {
                        daggerSmitingPage.click()

                        Utils.waitFor(4, object : Utils.Condition {
                            override suspend fun accept(): Boolean {
                                delay(100)
                                return oldInventoryCount != Inventory.getCount()
                            }
                        })
                    }


                }
            }

        }

        class AfterSmithingMovetoGate : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Congratulations, you've made your first weapon")
            }

            override suspend fun execute() {
                val walkingPath = arrayListOf(Tile(3086, 9505), Tile(3091, 9503))
                Walking.walkPath(walkingPath)
                val gate = GameObjects.find("Gate", sortByDistance = true)
                if (gate.size > 0) {
                    Camera.setHighPitch()
                    Camera.turnEast()
                    gate[0].interact("Open")
                    delay(Random.nextLong(3500, 5500))
                }

            }

        }

        class TalkToCombatInstructor : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("In this area you will find out about melee and ranged combat.")
            }

            override suspend fun execute() {
                Camera.setHighPitch()
                // Move to combat insturctor
                val tileNearCombatInstructor = Tile(3107, 9509)
                if (tileNearCombatInstructor.distanceTo() > 5) {
                    tileNearCombatInstructor.clickOnMiniMap()
                    val local = Players.getLocal()
                    Utils.waitFor(4, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return tileNearCombatInstructor.distanceTo() < 5 && local.player.getAnimation() == -1
                        }
                    })
                }

                //Talk with combat instructor
                val combatInstructor = NPCs.findNpc("Combat Instructor")
                combatInstructor[0].talkTo()
                Dialog.continueDialog()

            }

        }

        class OpenEquipment : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You now have access to a new")
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.Equiptment)
            }

        }

        class OpenEquipmentStats : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("This is your worn inventory.")
            }

            override suspend fun execute() {
                Equipment.open()
                Equipment.clickButton(Equipment.Companion.Slot.EquiptmentStats)
                delay(Random.nextLong(1500, 2637))
            }

        }

        class EquipBronzeDagger : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You can see what items you are")
            }

            override suspend fun execute() {
                Inventory.getItem(1205)?.click()
                delay(Random.nextLong(2500, 4000))
                WidgetItem(Widgets.find(84, 4)).click() // Close out of Equoptment status
            }

        }

        class SpeakWithCombatAfterBronzeDaggerEquipt : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You're now holding your dagger")
            }

            override suspend fun execute() {
                Camera.setHighPitch()
                //Talk with combat instructor
                val combatInstructor = NPCs.findNpc("Combat Instructor")
                combatInstructor[0].talkTo()
                Dialog.continueDialog()

            }

        }

        class EquipLongSwordAndShield : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("To unequip an item, go to your")
            }

            override suspend fun execute() {
                Inventory.getItem(1277)?.click()
                delay(Random.nextLong(1500, 2500))
                Inventory.getItem(1171)?.click()
                delay(Random.nextLong(1500, 2500))
            }

        }

        class OpenCombatTab : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Click on the flashing crossed")
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.Combat)
            }

        }

        class GoIntoRatCage : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("This is your combat interface. From here,")
            }

            override suspend fun execute() {
                Camera.setHighPitch()
                //Walk over to tile
                val tileNearGate = Tile(3111, 9519)
                if (tileNearGate.distanceTo() > 5) {
                    tileNearGate.clickOnMiniMap()
                    Utils.waitFor(4, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return tileNearGate.distanceTo() < 5
                        }
                    })
                }

                //Enter cage
                val gates = GameObjects.find("Gate", sortByDistance = true)
                if (gates.size > 0) {
                    Camera.turnWest()
                    gates[0].interact("Open")
                    Utils.waitFor(2, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return Players.getLocal().isIdle()
                        }
                    })
                }

            }

        }

        class MeleeKillRat : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("It's time to slay some rats!")
            }

            override suspend fun execute() {
                Camera.setHighPitch()
                val rats = NPCs.findNpc("Giant rat")
                if (rats.size > 0) {
                    val randomIndex = (0..5).random()
                    rats[randomIndex].interact("Attack")
                    Utils.waitFor(20, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return Players.getLocal().isIdle()
                        }
                    })
                }
            }

        }

        val ratCageArea = Area(
            Tile(3109, 9521), Tile(3110, 9519),
            Tile(3110, 9518), Tile(3109, 9516), Tile(3109, 9515),
            Tile(3108, 9514), Tile(3107, 9514), Tile(3106, 9513),
            Tile(3106, 9512), Tile(3105, 9511), Tile(3103, 9512),
            Tile(3100, 9512), Tile(3099, 9514), Tile(3098, 9515),
            Tile(3097, 9517), Tile(3098, 9519), Tile(3099, 9521),
            Tile(3100, 9522), Tile(3101, 9522), Tile(3102, 9525),
            Tile(3104, 9524), Tile(3106, 9522), Tile(3108, 9522),
            Tile(3109, 9521)
        )
        class GoTalkToCombatInstructorFor2ndTime : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Pass through the gate and talk to the combat")
            }

            override suspend fun execute() {
                Camera.setHighPitch()
                Camera.turnEast()
                // Check to see if we are still in the rat cage
                if (ratCageArea.containsOrIntersects(Players.getLocal().getGlobalLocation())) {
                    val gates = GameObjects.find("Gate", sortByDistance = true)
                    if (gates.size > 0) {
                        if (!gates[0].isOnScreen()) {
                            gates[0].clickOnMiniMap()
                            Players.getLocal().waitTillIdle()
                        }
                        gates[0].interact("Open")
                        Players.getLocal().waitTillIdle()
                    }
                }

                if (!ratCageArea.containsOrIntersects(Players.getLocal().getGlobalLocation())) {
                    val combatInstructor = NPCs.findNpc("Combat Instructor")
                    if (combatInstructor[0].distanceTo() > 5) {
                        combatInstructor[0].clickOnMiniMap()
                        combatInstructor[0].waitTillNearObject()
                    }

                    combatInstructor[0].talkTo()
                    Dialog.continueDialog()
                }
            }

        }

        class KillRatWithBow : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Now you have a bow and some arrows.")
            }

            override suspend fun execute() {
                Inventory.open()
                Inventory.getItem(841)?.click()
                delay(Random.nextLong(1500, 2500))
                Inventory.getItem(882)?.click()
                delay(Random.nextLong(1500, 2500))

                val rats = NPCs.findNpc("Giant rat")
                if (rats.size > 0) {
                    val randomIndex = (0..3).random()
                    rats[randomIndex].turnTo()
                    rats[randomIndex].interact("Attack")
                    delay(Random.nextLong(1000, 1500))
                    Players.getLocal().waitTillIdle()
                }
            }

        }

        class ExitCaves : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You have completed the tasks here")
            }

            override suspend fun execute() {
                Camera.setHighPitch()
                val tileNearLadder = Tile(3110, 9526)
                if (tileNearLadder.distanceTo() > 3) {
                    tileNearLadder.clickOnMiniMap()
                    Utils.waitFor(4, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return tileNearLadder.distanceTo() < 3
                        }
                    })

                }

                val ladder = GameObjects.find("Ladder", sortByDistance = true)
                if (ladder.size > 0) {
                    ladder[0].interact("Climb")
                    Players.getLocal().waitTillIdle()
                }
            }

        }

        class UseBank : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Follow the path and you will come to the front of the building")
            }

            override suspend fun execute() {
                val tileNearBank = Tile(3122, 3123)
                if (tileNearBank.distanceTo() > 5) {
                    tileNearBank.clickOnMiniMap()
                    Utils.waitFor(10, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return tileNearBank.distanceTo() < 3
                        }
                    })

                }

                val bankBooth = GameObjects.find("Bank booth", sortByDistance = true)
                if (bankBooth.size > 0) {
                    bankBooth[0].interact("Use")
                }

            }

        }

        class CloseBankAndDoPollBooth : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("This is your bank.")
            }

            override suspend fun execute() {
                Bank.close()
                OpenPollBooth()
            }

        }

        private suspend fun OpenPollBooth() {
            val pollBooth = GameObjects.find(26815)
            pollBooth[0].turnTo()
            val pollTile = Tile(3119, 3121, Main.clientData.getPlane())
            if (pollTile.distanceTo() > 3)
                Tile(3120, 3121, Main.clientData.getPlane()).clickOnMiniMap()

            pollTile.click()
            delay(Random.nextLong(1500, 2500))
            Dialog.continueDialog()
        }

        class DoPollBooth : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Now it's time for a quick look at polls")
            }

            override suspend fun execute() {
                //TODO figure out how to access moving objects OR need to find a more center tile point
                OpenPollBooth()
                Dialog.continueDialog()
                //If poll widget open, Close out of polling booth widget (310,2) child index 3
                closePollWidget()

            }

        }

        private suspend fun closePollWidget() {
            try {
                var pollWidget = Widgets.find(345, 0)
                if (pollWidget != null) {
                    val pollExitWidget = WidgetItem(Widgets.find(345, 2)?.getChildren()?.get(3))
                    pollExitWidget.click()
                }
                pollWidget = Widgets.find(310, 0)
                if (pollWidget != null) {
                    val pollExitWidget = WidgetItem(Widgets.find(310, 2)?.getChildren()?.get(3))
                    pollExitWidget.click()
                }

            } catch (e: Exception) {
                println("ERROR: Somthing happened when trying to find the poll widget")
            }
        }

        class ClosePollAndMoveOutOfBank : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Polls are run periodically to let the Old School")
            }

            override suspend fun execute() {
                closePollWidget()
                //Open Door(9721) at location(3125,3124)
                val doors = GameObjects.find(9721, sortByDistance = true)
                if (doors.isNotEmpty()) {
                    doors.forEach {
                        if (it.getGlobalLocation().x == 3125 && it.getGlobalLocation().y == 3124) {
                            it.turnTo()
                            it.interact("Open")
                            Utils.waitFor(6, object : Utils.Condition {
                                override suspend fun accept(): Boolean {
                                    delay(100)
                                    return Players.getLocal().isIdle() && Players.getLocal().getGlobalLocation().x == 3125
                                }
                            })
                        }
                    }
                }
            }

        }

        class TalkToAccountManager : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("The guide here will tell you all about your account.") ||
                        dialogWidget.containsText("This is your Account Management menu")
            }

            override suspend fun execute() {
                val accountManager = NPCs.findNpc("Account Guide")
                if (accountManager.isNotEmpty()) {
                    Camera.setHighPitch()
                    accountManager[0].talkTo()
                    delay(Random.nextLong(2500, 4500))
                    Dialog.continueDialog()
                }
            }

        }

        class OpenAccountManager : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Click on the flashing icon to open your Account Management")
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.AccountManagement)
            }

        }

        class ExitAccountManagerRoom : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Continue through the next door.")
            }

            override suspend fun execute() {
                val doors = GameObjects.find(9722, sortByDistance = true)
                if (doors.isNotEmpty()) {
                    doors.forEach {
                        if (it.getGlobalLocation().x == 3130 && it.getGlobalLocation().y == 3124) {
                            Camera.turnEast()
                            Camera.setHighPitch()
                            it.interact("Open")
                        }
                    }
                }
            }

        }

        class MoveToChapelAndTalkToBrotherBrace : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Follow the path to the chapel")
                        || dialogWidget.containsText("Talk with Brother Brace")
                        || dialogWidget.containsText("These two lists can be very helpful for keeping track")
            }

            override suspend fun execute() {
                var brotherBrace = NPCs.findNpc("Brother Brace")
                val pathToChapel = arrayListOf(Tile(3132, 3115), Tile(3130, 3107), Tile(3124, 3106))
                if ((brotherBrace.isNotEmpty() && brotherBrace[0].distanceTo() > 13) || brotherBrace.isEmpty())
                    Walking.walkPath(pathToChapel)
                Camera.setHighPitch()
                brotherBrace = NPCs.findNpc("Brother Brace")
                if (brotherBrace.size > 0) {
                    if (!brotherBrace[0].isOnScreen())
                        brotherBrace[0].turnTo()
                    brotherBrace[0].talkTo()
                    Players.getLocal().waitTillIdle()
                    Dialog.continueDialog()
                }
            }

        }

        class OpenPrayerTab : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Click on the flashing icon to open the Prayer menu.")
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.Prayer)
            }

        }

        class OpenFriendsTab : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You should now see another new icon. Click on the flashing face")
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.FriendsList)
            }

        }

        class ExitChapleHouse : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You're almost finished on tutorial island")
            }

            override suspend fun execute() {
                val doors = GameObjects.find(9723, sortByDistance = true)
                if (doors.isNotEmpty()) {
                    doors.forEach {
                        if (it.getGlobalLocation().x == 3122 && it.getGlobalLocation().y == 3102) {
                            Camera.turnSouth()
                            Camera.setHighPitch()
                            it.interact("Open")
                            delay(Random.nextLong(1500, 2500))
                            Players.getLocal().waitTillIdle()
                        }
                    }
                }
            }

        }

        class GoToWizardHouseAndSpeakWithWizard : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Follow the path to the wizard")
                        || dialogWidget.containsText("This is your magic interface")
            }

            override suspend fun execute() {
                val pathToWizardHouse = arrayListOf(
                    Tile(3128, 3090), Tile(3138, 3087),
                    Tile(3140, 3087)
                )
                if (pathToWizardHouse[2].distanceTo() > 6) {
                    Walking.walkPath(pathToWizardHouse)
                }
                val magicInstructor = NPCs.findNpc("Magic Instructor")
                if (magicInstructor.isNotEmpty()) {
                    magicInstructor[0].turnTo()
                    magicInstructor[0].talkTo()
                    Players.getLocal().waitTillIdle()
                    Dialog.continueDialog()

                }
            }

        }

        class OpenMagicTab : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Open up the magic interface")
            }

            override suspend fun execute() {
                Tabs.openTab(Tabs.Tab_Types.Magic)
            }

        }

        class SelectWindStrikeAndAttackChicken : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You now have some runes.")
            }

            override suspend fun execute() {
                Magic.cast(Magic.Companion.Spells.Wind_Strike)
                //Attack chicken
                val chickens = NPCs.findNpc("Chicken")
                if (chickens.isNotEmpty()) {
                    val randChick = Random.nextInt(0, chickens.size - 1)
                    chickens[randChick].turnTo()
                    chickens[randChick].interact("Cast")
                    Utils.waitFor(15, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return Players.getLocal().isIdle() && chickens[randChick].isIdle()
                        }
                    })

                }
            }

        }

        class ExitTutIsland : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("You're nearly finished with the tutorial")
            }

            override suspend fun execute() {
                val magicInstructor = NPCs.findNpc("Magic Instructor")
                if (magicInstructor.isNotEmpty()) {
                    if (!magicInstructor[0].isOnScreen()) magicInstructor[0].turnTo()
                    magicInstructor[0].talkTo()
                    Players.getLocal().waitTillIdle()
                    Dialog.continueDialog()
                    Dialog.selectionOption("Yes")
                    Dialog.continueDialog()
                    Dialog.selectionOption("No")
                    Dialog.continueDialog()

                }
            }

        }

        class MainlandLogout : Job() {
            override suspend fun isValidToRun(dialogWidget: WidgetItem): Boolean {
                return dialogWidget.containsText("Welcome to Lumbridge!")
            }

            override suspend fun execute() {
                //Run few different paths and then logout
                val pathNorth = arrayListOf(
                    Tile(3234, 3225), Tile(3224, 3237),
                    Tile(3218, 3250), Tile(3214, 3262)
                )
                val pathEast = arrayListOf(
                    Tile(3240, 3225), Tile(3256, 3227),
                    Tile(3258, 3233), Tile(3257, 3245), Tile(3251, 3257)
                )
                val pathSouth = arrayListOf(
                    Tile(3235, 3204), Tile(3243, 3193),
                    Tile(3241, 3181), Tile(3231, 3175), Tile(3238, 3163)
                )
                val pathWest = arrayListOf(
                    Tile(3223, 3219), Tile(3213, 3210),
                    Tile(3206, 3210)
                )
                if (Random.nextBoolean()) {
                    val investigationPaths = arrayListOf(pathNorth, pathSouth, pathEast)
                    val path = investigationPaths.random()
                    //Walk the path and then come back
                    Walking.walkPath(path)
                    Walking.walkPath(path, reverse = true)
                    Logout.logout()
                } else {
                    Walking.walkPath(pathWest)
                    Logout.logout()
                }

            }

        }




    }
}