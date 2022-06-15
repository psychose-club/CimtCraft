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

import club.psychose.cimtcraft.core.plugin.features.PluginFeature;
import club.psychose.cimtcraft.utils.ItemUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

/**
 * <p>The TimberModule provides the Timber feature for the Spigot plugin.</p>
 * @author CrashedLife
 */

public final class TimberModule extends PluginFeature {
    public TimberModule () {
        super("Timber", true);
    }

    @Override
    public void onBlockBreakEvent (BlockBreakEvent blockBreakEvent) {
        Player player = blockBreakEvent.getPlayer();
        ItemStack playerItemStack = player.getInventory().getItemInMainHand();

        // When the player is sneaking, has an axe with efficiency in the hand and the destroyed block is a wood block it'll cut down the tree.
        if (((playerItemStack.getItemMeta() != null) && (player.isSneaking()) && (ItemUtils.isItemAnAxe(playerItemStack)))) {
            if (playerItemStack.getItemMeta().hasEnchant(Enchantment.DIG_SPEED)) {
                if (ItemUtils.isBlockAWoodLog(blockBreakEvent.getBlock())) {
                    boolean unbreakable = ((playerItemStack.getItemMeta().isUnbreakable()) || (player.getGameMode().equals(GameMode.CREATIVE)));
                    this.cutTree(blockBreakEvent.getBlock(), player, playerItemStack, unbreakable);
                }
            }
        }
    }

    /**
     * <p>This method cuts a complete tree down.</p>
     * @param checkBlock From this {@link Block} will be looked for more blocks in the near.
     * @param player The {@link Player} that cuts the tree.
     * @param axeItemStack The axe from the {@link Player}.
     * @param unbreakable Is true when the item should not or can't be destroyed.
     */
    private void cutTree (Block checkBlock, Player player, ItemStack axeItemStack, boolean unbreakable) {
        // Looks for blocks in the near.
        for (BlockFace blockFace : BlockFace.values()) {
            Block relativeBlock = checkBlock.getRelative(blockFace);

            // Checks if the block is a wood log.
            if (ItemUtils.isBlockAWoodLog(relativeBlock)) {
                // Breaks the block and sets the material to air.
                relativeBlock.breakNaturally();
                relativeBlock.setType(Material.AIR);

                // Checks if the axe should be affected from the durability.
                if (!(unbreakable)) {
                    // Should not be null but when it is it'll automatically stop the method.
                    if (axeItemStack.getItemMeta() != null) {
                        // Gets the item damage and the new durability.
                        Damageable damageable = (Damageable) axeItemStack.getItemMeta();
                        int currentDurability = (axeItemStack.getType().getMaxDurability() - damageable.getDamage()) - 1;

                        // When the durability is more than 0 it'll damage the item, if it's not it'll destroy the item.
                        if (currentDurability > 0) {
                            damageable.setDamage(damageable.getDamage() + 1);
                            axeItemStack.setItemMeta(damageable);
                        } else {
                            damageable.setDamage(axeItemStack.getType().getMaxDurability());
                            axeItemStack.setItemMeta(damageable);
                            player.getInventory().setItemInMainHand(null);
                            return;
                        }
                    } else {
                        return;
                    }
                }

                // Destroys the block nearby.
                this.cutTree(relativeBlock, player, axeItemStack, unbreakable);
            }
        }
    }
}
