package com.flizzet.menus;

import com.flizzet.guicomponent.GuiComponent;

/**
 * Abstract menu class for concrete menus to extend from.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public abstract class Menu extends GuiComponent {

	/** Default instantiable constructor */
	public Menu() {}
	
	/** Meant to build and position all elements of the "Menu" */
	public abstract void buildMenu();

}
