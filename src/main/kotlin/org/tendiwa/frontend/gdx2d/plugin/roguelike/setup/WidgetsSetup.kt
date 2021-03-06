package org.tendiwa.frontend.gdx2d.plugin.roguelike.setup

import com.badlogic.gdx.scenes.scene2d.ui.Table
import org.tendiwa.backend.existence.aspect
import org.tendiwa.backend.modules.roguelike.aspects.Inventory
import org.tendiwa.frontend.gdx2d.TendiwaGame
import org.tendiwa.frontend.gdx2d.plugin.roguelike.ui.FpsCounter
import org.tendiwa.frontend.gdx2d.plugin.roguelike.ui.InventoryWidget
import org.tendiwa.frontend.gdx2d.resources.images.NamedTextureCache

fun setupUi(game: TendiwaGame, textureCache: NamedTextureCache) {
    game.apply {
        uiStage.addActor(
            Table().apply {
                setFillParent(true)
                bottom().right()
                val inventory = InventoryWidget(
                    game.playerVolition.host.aspect<Inventory>(),
                    game
                )
                add(inventory).height(200f).width(200f).top().center()
                    .pad(20f)
            }
        )
        uiStage.addActor(
            FpsCounter().apply {
                setPosition(40f, 20f)
            }
        )
    }
}
