/*
 * PlotSquared, a land and world management plugin for Minecraft.
 * Copyright (C) IntellectualSites <https://intellectualsites.com>
 * Copyright (C) IntellectualSites team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.plotsquared.core.util;

import com.plotsquared.core.configuration.Settings;
import com.plotsquared.core.configuration.caption.TranslatableCaption;
import com.plotsquared.core.permissions.Permission;
import com.plotsquared.core.permissions.PermissionHolder;
import com.plotsquared.core.player.PlotPlayer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * The Permissions class handles checking user permissions.<br>
 * - This will respect * nodes and plots.admin and can be used to check permission ranges (e.g. plots.plot.5)<br>
 * - Checking the PlotPlayer class directly will not take the above into account<br>
 *
 * @deprecated all logic that may once have been in the class lives elsewhere. We also want to do away with statically-accessed
 *         classes
 */
@Deprecated(forRemoval = true, since = "6.9.3")
public class Permissions {

    /**
     * @deprecated all logic that may once have been in the class lives elsewhere. We also want to do away with statically-accessed
     *         classes. Use {@link PlotPlayer#hasPermission(String, boolean)}
     */
    @Deprecated(forRemoval = true, since = "6.9.3")
    public static boolean hasPermission(PlotPlayer<?> player, Permission permission, boolean notify) {
        return hasPermission(player, permission.toString(), notify);
    }

    /**
     * Check if the owner of the profile has a given (global) permission
     *
     * @param caller     permission holder
     * @param permission Permission
     * @return {@code true} if the owner has the given permission, else {@code false}
     * @deprecated all logic that may once have been in the class lives elsewhere. We also want to do away with statically-accessed
     *         classes. Use {@link PermissionHolder#hasPermission(Permission)}
     */
    @Deprecated(forRemoval = true, since = "6.9.3")
    public static boolean hasPermission(final @NonNull PermissionHolder caller, final @NonNull Permission permission) {
        return caller.hasPermission(permission.toString());
    }

    /**
     * Check if the owner of the profile has a given (global) permission. There is no guarantee that per-world permissions will
     * be checked because unmaintained crap plugins like PEX exist.
     *
     * @param caller     permission holder
     * @param permission Permission
     * @return {@code true} if the owner has the given permission, else {@code false}
     * @deprecated all logic that may once have been in the class lives elsewhere. We also want to do away with statically-accessed
     *         classes. Use {@link PermissionHolder#hasPermission(String)}
     */
    @Deprecated(forRemoval = true, since = "6.9.3")
    public static boolean hasPermission(final @NonNull PermissionHolder caller, final @NonNull String permission) {
        return caller.hasPermission(permission);
    }

    /**
     * Check if the owner of the profile has a given (global) keyed permission. Checks both {@code permission.key}
     * and {@code permission.*}
     *
     * @param caller     permission holder
     * @param permission Permission
     * @param key        Permission "key"
     * @return {@code true} if the owner has the given permission, else {@code false}
     * @since 6.0.10
     * @deprecated all logic that may once have been in the class lives elsewhere. We also want to do away with statically-accessed
     *         classes. Use {@link PermissionHolder#hasKeyedPermission(String, String)}
     */
    @Deprecated(forRemoval = true, since = "6.9.3")
    public static boolean hasKeyedPermission(
            final @NonNull PermissionHolder caller, final @NonNull String permission,
            final @NonNull String key
    ) {
        return caller.hasKeyedPermission(permission, key);
    }

    /**
     * Checks if a PlotPlayer has a permission, and optionally send the no permission message if applicable.
     *
     * @param player     permission holder
     * @param permission permission
     * @param notify     if to notify the permission holder
     * @return if permission is had
     * @deprecated all logic that may once have been in the class lives elsewhere. We also want to do away with statically-accessed
     *         classes. Use {@link PlotPlayer#hasPermission(String, boolean)}
     */
    @Deprecated(forRemoval = true, since = "6.9.3")
    public static boolean hasPermission(PlotPlayer<?> player, String permission, boolean notify) {
        if (!hasPermission(player, permission)) {
            if (notify) {
                player.sendMessage(
                        TranslatableCaption.of("permission.no_permission_event"),
                        TagResolver.resolver("node", Tag.inserting(Component.text(permission)))
                );
            }
            return false;
        }
        return true;
    }

    /**
     * @deprecated all logic that may once have been in the class lives elsewhere. We also want to do away with statically-accessed
     *         classes. Use {@link PlotPlayer#hasPermissionRange(Permission, int)}
     */
    @Deprecated(forRemoval = true, since = "6.9.3")
    public static int hasPermissionRange(PlotPlayer<?> player, Permission Permission, int range) {
        return hasPermissionRange(player, Permission.toString(), range);
    }

    /**
     * Check the highest permission a PlotPlayer has within a specified range.<br>
     * - Excessively high values will lag<br>
     * - The default range that is checked is {@link Settings.Limit#MAX_PLOTS}<br>
     *
     * @param player Player to check for
     * @param stub   The permission stub to check e.g. for `plots.plot.#` the stub is `plots.plot`
     * @param range  The range to check
     * @return The highest permission they have within that range
     * @deprecated all logic that may once have been in the class lives elsewhere. We also want to do away with statically-accessed
     *         classes. Use {@link PlotPlayer#hasPermissionRange(String, int)}
     */
    @Deprecated(forRemoval = true, since = "6.9.3")
    public static int hasPermissionRange(PlotPlayer<?> player, String stub, int range) {
        return player.hasPermissionRange(stub, range);
    }

}
