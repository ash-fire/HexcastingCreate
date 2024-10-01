package net.hexcreate.casting.patterns.math

import at.petrak.hexcasting.api.spell.ConstMediaAction
import at.petrak.hexcasting.api.spell.asActionResult
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.getBlockPos
import at.petrak.hexcasting.api.spell.getDouble
import at.petrak.hexcasting.api.spell.iota.Iota
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity
import kotlin.math.sign

class OpCapacity : ConstMediaAction {
    /**
     * The number of arguments from the stack that this action requires.
     */
    override val argc = 1

    /**
     * The method called when this Action is actually executed. Accepts the [args]
     * that were on the stack (there will be [argc] of them), and the [ctx],
     * which contains things like references to the caster, the ServerLevel,
     * methods to determine whether locations and entities are in ambit, etc.
     * Returns the list of iotas that should be added back to the stack as the
     * result of this action executing.
     */
    override fun execute(args: List<Iota>, ctx: CastingContext): List<Iota> {
        val blockentity = ctx.world.getBlockEntity(args.getBlockPos(0, argc))
        if (blockentity is BracketedKineticBlockEntity){
            return blockentity.calculateAddedStressCapacity().asActionResult
        }
        return null.asActionResult;
    }
}