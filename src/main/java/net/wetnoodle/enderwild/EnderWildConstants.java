package net.wetnoodle.enderwild;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnderWildConstants {
    public static final String MOD_ID = "enderwild";
    public static final String MOD_NAME = "Wilder Enderscapes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    /**
     * Used for features that may be unstable and crash in public builds.
     * <p>
     * It's smart to use this for at least registries.
     */
    public static boolean UNSTABLE_LOGGING = FabricLoader.getInstance().isDevelopmentEnvironment();


    @NotNull
    public static ResourceLocation id(@NotNull String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    // LOGGING
    public static void log(String message) {
        LOGGER.info(message);
    }

    public static void log(String message, boolean shouldLog) {
        if (shouldLog) {
            log(message);
        }
    }

    /**
     * Used for features that may be unstable and crash in public builds.
     * <p>
     * It's smart to use this for at least registries.
     */
    public static void logUnstable(String message) {
        log(message, UNSTABLE_LOGGING);
    }

    public static void logWithModId(String message) {
        LOGGER.info("{} " + MOD_ID, message);
    }

    public static void logWithModId(String message, boolean shouldLog) {
        if (shouldLog) {
            logWithModId(message);
        }
    }

    /**
     * Used for features that may be unstable and crash in public builds.
     * <p>
     * It's smart to use this for at least registries.
     */
    public static void logUnstableWithModID(String message) {
        logWithModId(message, UNSTABLE_LOGGING);
    }

    public static void logWithModName(String message) {
        LOGGER.info("{} " + MOD_NAME, message);
    }

    public static void logWithModName(String message, boolean shouldLog) {
        if (shouldLog) {
            logWithModName(message);
        }
    }

    /**
     * Used for features that may be unstable and crash in public builds.
     * <p>
     * It's smart to use this for at least registries.
     */
    public static void logUnstableWithModName(String message) {
        logWithModName(message, UNSTABLE_LOGGING);
    }

}
