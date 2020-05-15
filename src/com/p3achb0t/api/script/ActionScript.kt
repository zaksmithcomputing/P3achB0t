package com.p3achb0t.api.script

abstract class ActionScript(val tasks: ArrayList<LeafTask> = ArrayList(),var currentJob: String = ""): SuperScript() {
    open suspend fun loop(){
        tasks.forEach {
            if (it.isValidToRun()) {
                currentJob = it.javaClass.name.split(".").last()
                logger.debug("Running: ${it.javaClass.name}")
                if(it is GroupTask){
                    it.children.forEach {child ->
                        if(child.isValidToRun()){
                            logger.debug("Child - Running: ${it.javaClass.name}")
                            child.execute()
                            logger.debug("Child - Completed: ${it.javaClass.name}")
                        }
                    }
                }else{
                    it.execute()
                }
                logger.debug("Completed: ${it.javaClass.name}")
            }
        }
    }

    open fun pause() {}
    open fun resume() {}
}