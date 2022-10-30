package uet.oop.bomberman.controllers;

import uet.oop.bomberman.entities.Bomber;

public class ItemInfo {
    private int itemSpeedCount;
    private int itemFlamesCount;
    private int itemBombsCount;

    private boolean isWallPass;
    private boolean isBombPass;
    private boolean isFlamePass;
    private boolean isDetonator;

    public void increaseItemSpeedCount() {
        itemSpeedCount++;
    }

    public void increaseItemFlamesCount() {
        itemFlamesCount++;
    }

    public void increaseItemBombsCount() {
        itemBombsCount++;
    }

    public void setWallPass(boolean wallPass) {
        isWallPass = wallPass;
    }

    public void setBombPass(boolean bombPass) {
        isBombPass = bombPass;
    }

    public void setFlamePass(boolean flamePass) {
        isFlamePass = flamePass;
    }

    public void setDetonator(boolean detonator) {
        isDetonator = detonator;
    }

    public ItemInfo() {
        itemBombsCount = Bomber.BOMBER_BOMB_LIST_SIZE_DEFAULT;
        itemSpeedCount = Bomber.BOMBER_SPEED_DEFAULT;
        itemFlamesCount = Bomber.BOMBER_BOMB_LEVEL_DEFAULT;
        isWallPass = false;
        isBombPass = false;
        isDetonator = false;
    }

    public int getItemBombsCount() {
        return itemBombsCount;
    }

    public int getItemFlamesCount() {
        return itemFlamesCount;
    }

    public int getItemSpeedCount() {
        return itemSpeedCount;
    }

    public boolean isDetonator() {
        return isDetonator;
    }

    public boolean isBombPass() {
        return isBombPass;
    }

    public boolean isFlamePass() {
        return isFlamePass;
    }

    public boolean isWallPass() {
        return isWallPass;
    }
}
