package net.mcreator.crmod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class SlotHelper {
	
	private Entity entity;
	private Container current;
	private Container currentPlayer;
	private Object invobj;
	private Map invobjMap;
	
	/**
	 * Creates an instance of the SlotHelper class. The SlotHelper abstracts code which deals with individual slots.
	 * @param _entity entity given in the block/player/item
	 */
	public SlotHelper(Entity _entity){
		entity = _entity;
		if (entity instanceof ServerPlayerEntity) {
			current = ((ServerPlayerEntity) entity).openContainer;
			
			if (current instanceof Supplier) {
				invobj = ((Supplier) current).get();
				
				if (invobj instanceof Map) {
					invobjMap = (Map) invobj;
				}
			}
		}
		if (entity instanceof PlayerEntity) {
			currentPlayer = ((PlayerEntity) entity).openContainer;
		}
	}
	
	/**
	 * Gets the ItemStack from a slot
	 * @param slotID slot ID defined in the GUI
	 */
	public ItemStack getItemStackInSlot(int slotID) {
		return current != null && invobj != null && invobjMap != null ? ((Slot) invobjMap.get(slotID)).getStack() : ItemStack.EMPTY;
	}
	
	/**
	 * Sets an ItemStack into a given slot; replaces the existing ItemStack
	 * @param slotID slot ID defined in the GUI
	 * @param itemStack ItemStack to place into the slot
	 */
	public void setItemStackInSlot(int slotID, ItemStack itemStack){
		((Slot) invobjMap.get(slotID)).putStack(itemStack);
		currentPlayer.detectAndSendChanges();
	}
	
	/**
	 * Gets the size of the ItemStack in a given slot.
	 * @param slotID slot ID defined in the GUI
	 */
	public int getItemAmountInSlot(int slotID) {
		return getItemStackInSlot(slotID) != ItemStack.EMPTY ? (int) getItemStackInSlot(slotID).getCount() : 0;
	}
	
	/**
	 * Clears the ItemStack in a given slot. Equivalent to replacing the current stack with the empty ItemStack.
	 * @param slotID
	 */
	public void clearItemSlot(int slotID){
		setItemStackInSlot(slotID, ItemStack.EMPTY);
		currentPlayer.detectAndSendChanges();
	}
	
	/**
	 * Increases the size of an ItemStack in a slot by any amount.
	 * @param slotID slot ID defined in the GUI
	 * @param increaseBy amount to increase the current stack size by; can be positive or negative
	 */
	public void increaseItemAmountInSlot(int slotID, int increaseBy) {
		getItemStackInSlot(slotID).setCount(getItemAmountInSlot(slotID) + increaseBy);
		currentPlayer.detectAndSendChanges();
	}
}
