package DukeLeto2.chillager_mod;

import DukeLeto2.chillager_mod.mobs.ChillagerEntity;
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
				"vanishinheat=n\n" +
				"#Should Chillagers be hostile to each other by default?\n" +
				"harmotherchillagers=y\n" +
				"#By default, chillagers differ from their behavior in Minecraft Dungeons\n"+
				"#in that they shoot magical snowballs rather than merely attacking with\n" +
				"#blocks of frozen ice. Change this setting to make their behavior conform to\n" +
				"#Minecraft Dungeons' behavior.\n" +
				"attackwithsnowballs=y";
	}
	public static SimpleConfig CONFIG = SimpleConfig.of("chillager_mod").provider(ChillagerMod::provider).request();
	@Override
	public void onInitialize() {
		this.initializeConfigs();
		Registry.register(Registry.STATUS_EFFECT, frozen_id, FROZEN_EFFECT);
		ChillagerModItems.register();
		ChillagerModBlocks.register();
		ChillagerModEntities.register();
	}

	private void initializeConfigs () {
		String s = ChillagerMod.CONFIG.getOrDefault("vanishinsunlight", "n");
		if (s == "y")
			ChillagerEntity.vanishinsunlight = true;
		else
			ChillagerEntity.vanishinsunlight = false;
		s = ChillagerMod.CONFIG.getOrDefault("vanishinheat", "n");
		if (s == "y")
			ChillagerEntity.vanishinheat = true;
		else
			ChillagerEntity.vanishinheat = false;
		s = ChillagerMod.CONFIG.getOrDefault("harmotherchillagers", "y");
		if (s == "y")
			ChillagerEntity.harmotherchillagers = true;
		else
			ChillagerEntity.harmotherchillagers = false;
		s = ChillagerMod.CONFIG.getOrDefault("attackwithsnowballs", "y");
		if (s == "y")
			ChillagerEntity.attackwithsnowballs = true;
		else
			ChillagerEntity.attackwithsnowballs = false;
	}
}
