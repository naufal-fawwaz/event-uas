package com.andriawan.event_tix.models;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author naufalfawwaz
 */
public class Menu {
    String icon;
    String title;
    MenuType menuType;

    public Menu(String icon, String title, MenuType menuType) {
        this.icon = icon;
        this.title = title;
        this.menuType = menuType;
    }

    public Menu() {
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public Icon toIcon() {
        return new ImageIcon(this.getClass().getResource("/com/andriawan/event_tix/icons/" + icon + ".png"));
    }
}
