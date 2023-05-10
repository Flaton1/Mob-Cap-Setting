package fr.flaton.mobcapsetting;

import net.minecraft.world.entity.MobCategory;

import java.lang.reflect.Field;

public class MobCapSetting
{
	public static final String MOD_ID = "mobcapsetting";

	public static void init() {
		try {
			Field mobCap = MobCategory.class.getDeclaredField("max");
			mobCap.setAccessible(true);

			mobCap.setInt(MobCategory.MONSTER, Config.monster);
			mobCap.setInt(MobCategory.CREATURE, Config.creature);
			mobCap.setInt(MobCategory.AMBIENT, Config.ambient);
			mobCap.setInt(MobCategory.AXOLOTLS, Config.axolotls);
			mobCap.setInt(MobCategory.UNDERGROUND_WATER_CREATURE, Config.underground_water_creature);
			mobCap.setInt(MobCategory.WATER_CREATURE, Config.water_creature);
			mobCap.setInt(MobCategory.WATER_AMBIENT, Config.water_ambient);

		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}