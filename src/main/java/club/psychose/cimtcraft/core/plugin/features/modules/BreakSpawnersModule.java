/*
 * Copyright © 2022 psychose.club
 * Discord: https://www.psychose.club/discord
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package club.psychose.cimtcraft.core.plugin.features.modules;

import club.psychose.cimtcraft.CimtCraft;
import club.psychose.cimtcraft.core.plugin.features.PluginFeature;
import club.psychose.cimtcraft.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

/**
 * <p>The TimberModule provides the Spawner feature for the Spigot plugin.</p>
 * @author CrashedLife
 */

public final class BreakSpawnersModule extends PluginFeature {
    public BreakSpawnersModule () {
        super("Break Spawners", true);
    }

    @Override
    public void onBlockPlaceEvent (BlockPlaceEvent blockPlaceEvent) {
        ItemStack itemStack = blockPlaceEvent.getItemInHand();

        // Checks if the item that was placed is a spawner and if the ItemMeta is null.
        if (itemStack.getType().equals(Material.SPAWNER)) {
            if (itemStack.getItemMeta() != null) {
                // Gets the PersistentDataContainer.
                PersistentDataContainer persistentDataContainer= itemStack.getItemMeta().getPersistentDataContainer();

                // Searches for the entity tag.
                String entityTag = persistentDataContainer.getOrDefault(new NamespacedKey(CimtCraft.getPlugin(CimtCraft.class), "spawner.entity"), PersistentDataType.STRING, "null");

                // If the entity tag is not null it'll replace the entity in the spawner.
                if (!(entityTag.equals("null"))) {
                    EntityType entityType = Arrays.stream(EntityType.values()).filter(searchEntityType -> searchEntityType.name().equalsIgnoreCase(entityTag)).findFirst().orElse(null);

                    if (entityType != null) {
                        CreatureSpawner creatureSpawner = (CreatureSpawner) blockPlaceEvent.getBlock().getState();
                        creatureSpawner.setSpawnedType(entityType);
                        creatureSpawner.update();
                    }
                }
            }
        }
    }

    @Override
    public void onBlockBreakEvent (BlockBreakEvent blockBreakEvent) {
        Player player = blockBreakEvent.getPlayer();
        ItemStack playerItemStack = player.getInventory().getItemInMainHand();

        // Checks if the player ItemStack is a pickaxe (excluding wood and stone type) and if the ItemMeta is not null.
        if (((playerItemStack.getItemMeta() != null) && (ItemUtils.isItemAnPickaxe(playerItemStack, Material.WOODEN_PICKAXE, Material.STONE_PICKAXE)))) {
            // Checks if the pickaxe has the silk touch enchantment.
            if (playerItemStack.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                // Checks if the broken block is a spawner.
                if (blockBreakEvent.getBlock().getType().equals(Material.SPAWNER)) {
                    CreatureSpawner creatureSpawner = (CreatureSpawner) blockBreakEvent.getBlock().getState();
                    ItemStack spawnerItemStack = new ItemStack(Material.SPAWNER, 1);
                    ItemMeta spawnerItemMeta = spawnerItemStack.getItemMeta();

                    // Checks if the new ItemStack ItemMeta is not null.
                    if (spawnerItemMeta != null) {
                        // Gets the PersistentDataContainer.
                        PersistentDataContainer persistentDataContainer = spawnerItemMeta.getPersistentDataContainer();

                        // Sets the display name.
                        spawnerItemMeta.setDisplayName("§d" + creatureSpawner.getSpawnedType().name() + " - Spawner");

                        // Creates the entity tag.
                        NamespacedKey namespacedKey = new NamespacedKey(CimtCraft.getPlugin(CimtCraft.class), "spawner.entity");

                        // If the entity tag already exists it'll remove it.
                        if (persistentDataContainer.has(namespacedKey, PersistentDataType.STRING))
                            persistentDataContainer.remove(namespacedKey);

                        // Sets the entity tag.
                        persistentDataContainer.set(namespacedKey, PersistentDataType.STRING, creatureSpawner.getSpawnedType().name());

                        // Replaces the ItemMeta.
                        spawnerItemStack.setItemMeta(spawnerItemMeta);

                        // Breaks the block and drops the ItemStack.
                        blockBreakEvent.getBlock().breakNaturally();
                        blockBreakEvent.getBlock().getWorld().dropItemNaturally(blockBreakEvent.getBlock().getLocation(), spawnerItemStack);
                    }
                }
            } else {
                // Drops some experience.
                blockBreakEvent.setExpToDrop(20);
            }
        }
    }
}