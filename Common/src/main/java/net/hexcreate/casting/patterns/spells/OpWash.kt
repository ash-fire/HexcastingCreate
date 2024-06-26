package net.hexcreate.casting.patterns.spells

import at.petrak.hexcasting.api.misc.MediaConstants
import at.petrak.hexcasting.api.spell.*
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.iota.Iota
import com.simibubi.create.AllRecipeTypes
import com.simibubi.create.content.kinetics.fan.processing.SplashingRecipe
import com.simibubi.create.content.kinetics.fan.processing.SplashingRecipe.SplashingWrapper
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import java.util.*


class OpWash : SpellAction {
    /**
     * The number of arguments from the stack that this action requires.
     */
    override val argc = 1
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
        val target = args.getItemEntity(0, argc)
        val numTarget = target.item.count;

        // makes sure that the target player is inside the range
        // the caster is allowed to affect.
        ctx.assertEntityInRange(target)

        return Triple(
            Spell(target),
            cost * numTarget,
            listOf(ParticleSpray.burst(target.position(), 1.0))
        )
    }

    /**
     * This class is responsible for actually making changes to the world. It accepts parameters to
     * define where/what it should affect (for this example the parameter is [player]), and the
     * [cast] method within is responsible for using that data to alter the world.
     */
    private data class Spell(val target: ItemEntity) : RenderedSpell {
        override fun cast(ctx: CastingContext) {
            //val player = ctx.caster;
            val item = target.item;
            //val pos = Vec3.atCenterOf(target);

            // Get all crushing recipes

            // Get all crushing recipes
            var itemStackList:  MutableList<ItemStack> =mutableListOf()
            for (i in 0..item.count){
                val results: MutableList<ItemStack>? =  washResult(item.item, ctx) ;
                if (results != null) {
                    for (result in results) {
                        itemStackList.add(result)
                        //ctx.caster.sendSystemMessage(result.displayName)
                    }
                }
            }

            val results = combineItemStacks(itemStackList)

            for (result in results) {
                //ctx.caster.sendSystemMessage(result.displayName)
                ctx.world.addFreshEntity(ItemEntity(ctx.world, target.x, target.y, target.z, result.copy()))

            }
            target.remove(net.minecraft.world.entity.Entity.RemovalReason.DISCARDED)
        }
        fun washResult(item: Item, ctx: CastingContext): MutableList<ItemStack>? {
            val recipeType: IRecipeTypeInfo = AllRecipeTypes.SPLASHING
            val itemStack = ItemStack(item, 1)
            val splashingWrapper = SplashingWrapper()
            splashingWrapper.setStackInSlot(0, itemStack)
            val recipe: Optional<SplashingRecipe> = ctx.world.recipeManager.getRecipeFor(
                    recipeType.getType(), splashingWrapper,
                    ctx.world)
            if (!recipe.isPresent) return null
            //if (result.isEmpty()) return null
            return recipe.get().rollResults();
        }
        fun combineItemStacks(itemStacks: List<ItemStack>): List<ItemStack> {
            // Group by item type
            val groupedStacks = itemStacks.groupBy { it.item }

            // Combine stacks of the same item type
            val combinedStacks = mutableListOf<ItemStack>()
            for ((item, stacks) in groupedStacks) {
                val totalCount = stacks.sumOf { it.count }
                combinedStacks.add(ItemStack(item, totalCount))
            }

            return combinedStacks
        }

    }

}
