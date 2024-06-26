package net.hexcreate.registry;

import at.petrak.hexcasting.api.PatternRegistry;
import at.petrak.hexcasting.api.spell.Action;
import at.petrak.hexcasting.api.spell.math.HexDir;
import at.petrak.hexcasting.api.spell.math.HexPattern;
import kotlin.Triple;
import net.hexcreate.casting.patterns.math.OpSignum;
import net.hexcreate.casting.patterns.spells.OpCongrats;
import net.hexcreate.casting.patterns.spells.OpCrush;
import net.hexcreate.casting.patterns.spells.OpItemType;
import net.hexcreate.casting.patterns.spells.OpWash;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

import static net.hexcreate.Hexcreate.id;

public class HexcreatePatternRegistry {
    public static List<Triple<HexPattern, ResourceLocation, Action>> PATTERNS = new ArrayList<>();
    public static List<Triple<HexPattern, ResourceLocation, Action>> PER_WORLD_PATTERNS = new ArrayList<>();
    // IMPORTANT: be careful to keep the registration calls looking like this, or you'll have to edit the hexdoc pattern regex.
    public static HexPattern CONGRATS = registerPerWorld(HexPattern.fromAngles("eed", HexDir.WEST), "congrats", new OpCongrats());
    public static HexPattern SIGNUM = register(HexPattern.fromAngles("edd", HexDir.NORTH_WEST), "signum", new OpSignum());

    public static HexPattern ITEMTYPE = register(HexPattern.fromAngles("wdeeeee", HexDir.WEST), "itemtype", new OpItemType());

    public static HexPattern CRUSH = register(HexPattern.fromAngles("qqqwwqqqwqqawdedw", HexDir.WEST), "crush", new OpCrush());

    public static HexPattern WASH = register(HexPattern.fromAngles("aqawqadaqdeeewweee", HexDir.SOUTH_EAST), "wash", new OpWash());

    public static void init() {
        try {
            for (Triple<HexPattern, ResourceLocation, Action> patternTriple : PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird());
            }
            for (Triple<HexPattern, ResourceLocation, Action> patternTriple : PER_WORLD_PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird(), true);
            }
        } catch (PatternRegistry.RegisterPatternException e) {
            e.printStackTrace();
        }
    }

    private static HexPattern register(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, ResourceLocation, Action> triple = new Triple<>(pattern, id(name), action);
        PATTERNS.add(triple);
        return pattern;
    }

    private static HexPattern registerPerWorld(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, ResourceLocation, Action> triple = new Triple<>(pattern, id(name), action);
        PER_WORLD_PATTERNS.add(triple);
        return pattern;
    }
}
