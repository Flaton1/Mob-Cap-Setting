package fr.flaton.mobcapsetting.forge;

import fr.flaton.mobcapsetting.Config;
import fr.flaton.mobcapsetting.MobCapSetting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(MobCapSetting.MOD_ID)
public class MobCapSettingForge {
    public MobCapSettingForge() {
        Config config = new Config(FMLPaths.CONFIGDIR.get());
        config.loadConfig();

        MobCapSetting.init();
    }
}