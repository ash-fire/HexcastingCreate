package net.hexcreate.casting.patterns.spells

import at.petrak.hexcasting.api.misc.MediaConstants
import at.petrak.hexcasting.api.spell.*
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.iota.Iota
import com.simibubi.create.AllBlockEntityTypes
import com.simibubi.create.AllRecipeTypes
import com.simibubi.create.content.kinetics.crank.HandCrankBlockEntity
import com.simibubi.create.content.kinetics.fan.processing.SplashingRecipe
import com.simibubi.create.content.kinetics.fan.processing.SplashingRecipe.SplashingWrapper
import com.simibubi.create.content.kinetics.press.PressingRecipe
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo
import net.minecraft.core.BlockPos
import net.minecraft.world.SimpleContainer
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.phys.Vec3
import java.util.*


class OpSpin : SpellAction {
    /**
     * The number of arguments from the stack that this action requires.
     */
    override val argc = 3
    val cost = 2 * MediaConstants.DUST_UNIT
    /**
     * The method called when this Action is actually executed. Accepts the [args]
     * that were on the stack (there will be [argc] of them), and the [ctx],
     * which contains things like references to the caster, the ServerLevel,
     * methods to determine whether locations and entities are in ambit, etc.
     * Returns a triple of things. The [RenderedSpell] is responsible for the spell actually
     * doing things in the world, the [Int] is how much media the spell should cost,
     * and the [List] of [ParticleSpray] renders particle effects for the result of the SpellAction.
     *
     * The [execute] method should only contain code to find the targets of the spell and validate
     * them. All the code that actually makes changes to the world (breaking blocks, teleporting things,
     * etc.) should be in the private [Spell] data class below.
     */
    override fun execute(args: List<Iota>, ctx: CastingContext): Triple<RenderedSpell, Int, List<ParticleSpray>> {
        val target = args.getBlockPos(0, argc)
        val backwards = args.getBool(1, argc)
        val time = args.getInt(2, argc)

        // makes sure that the target player is inside the range
        // the caster is allowed to affect.
        ctx.assertVecInRange(target)

        return Triple(
            Spell(target,backwards,time),
            cost  * time,
            listOf(ParticleSpray.burst(Vec3.atCenterOf(target) , 1.0))
        )
    }

    /**
     * This class is responsible for actually making changes to the world. It accepts parameters to
     * define where/what it should affect (for this example the parameter is [player]), and the
     * [cast] method within is responsible for using that data to alter the world.
     */
    private data class Spell(val target: BlockPos, val backward: Boolean, val time: Int) : RenderedSpell {
        override fun cast(ctx: CastingContext) {
            //val player = ctx.caster;
            val blockEntity = ctx.world.getBlockEntity(target)
            if (blockEntity is HandCrankBlockEntity){

                    blockEntity.turn(backward)

            }



        }


    }

}
