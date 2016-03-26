package org.tendiwa.frontend.gdx2d.plugin.roguelike.actions

import org.tendiwa.backend.contains
import org.tendiwa.backend.existence.RealThing
import org.tendiwa.backend.existence.aspect
import org.tendiwa.backend.space.aspects.Position
import org.tendiwa.backend.space.move
import org.tendiwa.backend.space.tile
import org.tendiwa.frontend.gdx2d.TendiwaGame
import org.tendiwa.frontend.gdx2d.centerOnTile
import org.tendiwa.frontend.generic.move

class MovePlayerCharacterAction(
    private val game: TendiwaGame,
    private val playerCharacter: RealThing
) : (Int, Int, Int) -> Boolean {
    override fun invoke(dx: Int, dy: Int, dz: Int): Boolean {
        if (dx == 0 && dy == 0) {
            return false
        }
        val currentVoxel = playerCharacter.aspect<Position>().voxel
        val targetVoxel = currentVoxel.move(dx, dy, dz)
        if (!game.reality.space.hull.contains(targetVoxel)) {
            return false
        }
        game.camera.centerOnTile(targetVoxel.tile)
        game.playerVolition.move(
            targetVoxel.x,
            targetVoxel.y,
            targetVoxel.z
        )
        return true
    }
}
