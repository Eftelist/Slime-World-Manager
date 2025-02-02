package com.grinderwolf.swm.nms.v1_9_R2;

import com.grinderwolf.swm.clsm.CLSMBridge;
import com.grinderwolf.swm.clsm.ClassModifier;
import lombok.RequiredArgsConstructor;
import net.minecraft.server.v1_9_R2.WorldServer;

@RequiredArgsConstructor
public class CraftCLSMBridge implements CLSMBridge {

    private final v1_9_R2SlimeNMS nmsInstance;

    @Override
    public Object[] getDefaultWorlds() {
        WorldServer defaultWorld = nmsInstance.getDefaultWorld();
        WorldServer netherWorld = nmsInstance.getDefaultNetherWorld();
        WorldServer endWorld = nmsInstance.getDefaultEndWorld();

        if (defaultWorld != null || netherWorld != null || endWorld != null) {
            return new WorldServer[] { defaultWorld, netherWorld, endWorld };
        }

        // Returning null will just run the original load world method
        return null;
    }

    public static void initialize(v1_9_R2SlimeNMS instance) {
        ClassModifier.setLoader(new CraftCLSMBridge(instance));
    }
}
