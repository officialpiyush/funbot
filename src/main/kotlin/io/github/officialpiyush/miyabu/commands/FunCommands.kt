package io.github.officialpiyush.miyabu.commands

import kong.unirest.Unirest
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import net.dv8tion.jda.api.EmbedBuilder
import kotlin.reflect.typeOf

@CommandSet("fun-commands")
fun createFunCommandSet() = commands {
    command("joke") {
        description = "Returns a random joke"
        execute {
            val response = Unirest.get("https://apis.duncte123.me/meme")
                .asJson()
                .body
                .`object`
                .getJSONObject("data")



            val em = EmbedBuilder()
            em.setTitle(response.getString("title").toString(), response.getString("url").toString())
            em.setImage(response.getString("image").toString())

            it.respond(em.build());
        }
    }
}
