package io.github.officialpiyush.miyabu

import io.github.cdimascio.dotenv.dotenv
import me.aberrantfox.kjdautils.api.dsl.PrefixDeleteMode
import me.aberrantfox.kjdautils.api.startBot

fun main(args: Array<String>) {
    val env = dotenv();
    env["TOKEN"]?.let {
        startBot(it) {
            configure {
                globalPath = "io.github.officialpiyush.miyabu"
                prefix = ">"
                deleteMode = PrefixDeleteMode.Double
            }
        }
    }
}
