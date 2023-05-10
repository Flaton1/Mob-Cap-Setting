package fr.flaton.mobcapsetting.fabric;

import fr.flaton.mobcapsetting.Config;
import fr.flaton.mobcapsetting.MobCapSetting;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class MobCapSettingFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Config config = new Config(FabricLoader.getInstance().getConfigDir());
        config.loadConfig();

        MobCapSetting.init();
    }
}