package net.hexcreate.item;

import at.petrak.hexcasting.api.HexAPI;
import at.petrak.hexcasting.common.items.magic.ItemMediaHolder;
import at.petrak.hexcasting.common.lib.HexSounds;
import at.petrak.hexcasting.common.network.MsgOpenSpellGuiAck;
import at.petrak.hexcasting.xplat.IXplatAbstractions;
import com.simibubi.create.content.equipment.wrench.WrenchItem;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;


public class ItemCreateStaff extends WrenchItem {
    // 0 = normal. 1 = old. 2 = bosnia
    public static final ResourceLocation FUNNY_LEVEL_PREDICATE = new ResourceLocation(HexAPI.MOD_ID, "funny_level");
    //TODO add bool called isStaff and change interaction behavior depending on what is happening
    //TODO add fuction to check is shifting and scrolling and switch the bool's value
    public Boolean isStaff = true;

    public ItemCreateStaff(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (player.isShiftKeyDown()) {
            if (world.isClientSide()) {
                player.playSound(HexSounds.FAIL_PATTERN, 1f, 1f);
            } else if (player instanceof ServerPlayer serverPlayer) {
                IXplatAbstractions.INSTANCE.clearCastingData(serverPlayer);
            }
        }

        if (!world.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            var harness = IXplatAbstractions.INSTANCE.getHarness(serverPlayer, hand);
            var patterns = IXplatAbstractions.INSTANCE.getPatterns(serverPlayer);
            var descs = harness.generateDescs();

            IXplatAbstractions.INSTANCE.sendPacketToPlayer(serverPlayer,
                    new MsgOpenSpellGuiAck(hand, patterns, descs.getFirst(), descs.getSecond(), descs.getThird(),
                            harness.getParenCount()));
        }

        player.awardStat(Stats.ITEM_USED.get(this));
//        player.gameEvent(GameEvent.ITEM_INTERACT_START);

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents,
                                TooltipFlag isAdvanced) {




        tooltipComponents.add(Component.translatable("item.hexcreate.create_staff.tooltip").withStyle(ChatFormatting.YELLOW));
    }

}
