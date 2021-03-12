package DukeLeto2.chillager_mod;

import net.fabricmc.api.ModInitializer;
import DukeLeto2.chillager_mod.status.FrozenEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ChillagerMod implements ModInitializer {
	public static final String modid = "chillager_mod";
	public static final StatusEffect FROZEN_EFFECT = new FrozenEffect();
	public static final Identifier frozen_id = new Identifier(modid, "frozen_effect");
	public static String provider (String filename){
		return "#Configuration file for the Chillager mod.\n\n" +
				"#Set chillager spawn weight:\n"+
				"weight=30\n" +
				"#Should unnamed chillagers disappear in the sunlight? y/n\n" +
				"vanishinsunlight=n\n"+
				"#Should unnamed chillagers disappear when not in a cold biome?\n"+
				"vanishinheat=n\n";
	}
	public static SimpleConfig CONFIG = SimpleConfig.of("chillager_mod").provider(ChillagerMod::provider).request();
	@Override
	public void onInitialize() {
		Registry.register(Registry.STATUS_EFFECT, frozen_id, FROZEN_EFFECT);
		ChillagerModItems.register();
		ChillagerModBlocks.register();
		ChillagerModEntities.register();
	}
}
