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
	 * @param slotID Slot ID defined in the GUI
	 */
	public ItemStack getItemStackInSlot(int slotID) {
		return current != null && invobj != null && invobjMap != null ? ((Slot) invobjMap.get(slotID)).getStack() : ItemStack.EMPTY;
	}
	public void setItemStackInSlot(int slotID, ItemStack itemStack){
		((Slot) invobjMap.get(slotID)).putStack(itemStack);
		currentPlayer.detectAndSendChanges();
	}
	
	public int getItemAmountInSlot(int slotID) {
		return getItemStackInSlot(slotID) != ItemStack.EMPTY ? (int) getItemStackInSlot(slotID).getCount() : 0;
	}
	public void clearItemSlot(int slotID){
		setItemStackInSlot(slotID, ItemStack.EMPTY);
		currentPlayer.detectAndSendChanges();
	}
	
	public void increaseItemAmountInSlot(int slotID, int increaseBy) {
		getItemStackInSlot(slotID).setCount(getItemAmountInSlot(slotID) + increaseBy);
		currentPlayer.detectAndSendChanges();
	}
	
	public static ItemStack[] groupItemStacks(ItemStack... itemStacks){
		return itemStacks;
	}
}
