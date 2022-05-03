package potionstudios.byg.registration;

import potionstudios.byg.common.blockentity.BYGBlockEntities;
import potionstudios.byg.common.container.BYGMenuTypes;
import potionstudios.byg.common.entity.BYGEntities;

public class BYGRegistries {

    public static void loadClasses() {
        BYGMenuTypes.loadClass();
        BYGEntities.loadClass();
        BYGBlockEntities.loadClass();
    }

}
