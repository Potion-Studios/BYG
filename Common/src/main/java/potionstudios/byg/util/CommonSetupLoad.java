package potionstudios.byg.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public interface CommonSetupLoad {

    List<Supplier<? extends CommonSetupLoad>> ENTRIES = new ArrayList<>();

    void load();
}