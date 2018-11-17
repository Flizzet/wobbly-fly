package com.flizzet.assets;

import java.util.ArrayList;

/**
 * Holds paths of all assets for the {@link AssetDescriptors}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class AssetInfo {
	
	/* Constants */
		// Player
	public static final String SWAMP_DRAGONFLY = "dragonflies/swamp_dragonfly.png";
	public static final String BABY_DIAMOND_DRAGONFLY = "dragonflies/baby_diamond_dragonfly.png";
	public static final String BABY_OPAL_DRAGONFLY = "dragonflies/baby_opal_dragonfly.png";
	public static final String BABY_RUBY_DRAGONFLY = "dragonflies/baby_ruby_dragonfly.png";
	public static final String ADULT_DIAMOND_DRAGONFLY = "dragonflies/adult_diamond_dragonfly.png";
	public static final String ADULT_OPAL_DRAGONFLY = "dragonflies/adult_opal_dragonfly.png";
	public static final String ADULT_RUBY_DRAGONFLY = "dragonflies/adult_ruby_dragonfly.png";
	public static final String ALEXANDRITE_DRAGONFLY = "dragonflies/alexandrite_dragonfly.png";
	public static final String CRYSTAL_DRAGONFLY = "dragonflies/crystal_dragonfly.png";
		// Enemies
	public static final String SWAMP_BASS_FISH = "enemies/swamp_bass_fish.png";
	public static final String DIAMOND_FROG = "enemies/frog_enemy.png";
	public static final String OPAL_RAT = "enemies/rat_enemy.png";
	public static final String RUBY_SPIDER = "enemies/spider_enemy.png";
	public static final String SWAMP_HORNET = "enemies/swamp_hornet.png";
	public static final String OPAL_CAVE_CRITTER = "enemies/opal_cave_critter.png";
	public static final String DIAMOND_CAVE_CRITTER = "enemies/diamond_cave_critter.png";
	public static final String RUBY_CAVE_CRITTER = "enemies/ruby_cave_critter.png";
		// Passive creatures
	public static final String SWAMP_HEALING_CRITTER = "passivecreatures/swamp_healingcritter.png";
	public static final String OPAL_HEALING_CRITTER = "passivecreatures/opal_healingcritter.png";
	public static final String DIAMOND_HEALING_CRITTER = "passivecreatures/diamond_healingcritter.png";
	public static final String RUBY_HEALING_CRITTER = "passivecreatures/ruby_healingcritter.png";
		// Effects/Particles
	public static final String VIGNETTE = "effects/vignette.png";
	public static final String WARNING_EXCLAMATION_PARTICLE = "effects/warning_particle.png";
	public static final String HEALING_PARTICLE = "effects/healing_particle.png";
	public static final String CURRENCY_GLOW = "effects/currency_glow.png";
		// Items
	public static final String COIN = "items/coin.png";
	public static final String DIAMOND_CURRENCY = "items/diamond_currency.png";
	public static final String OPAL_CURRENCY = "items/opal_currency.png";
	public static final String RUBY_CURRENCY = "items/ruby_currency.png";
	public static final String SWAMP_CURRENCY = "items/swamp_currency.png";
		// GUI
	public static final String HEALTH_CONTAINER = "gui/ingame/health_container.png";
	public static final String HEALTH_FILL = "gui/ingame/health_fill.png";
	public static final String START_MENU_PLAY_BUTTON = "gui/startmenu/button_play.png";
	public static final String START_MENU_PLAY_BUTTON_PUSHED = "gui/startmenu/button_play_pushed.png";
	public static final String START_MENU_SHOP_BUTTON = "gui/startmenu/button_shop.png";
	public static final String START_MENU_SHOP_BUTTON_PUSHED = "gui/startmenu/button_shop_pushed.png";
	public static final String START_MENU_BACKGROUND = "gui/startmenu/background.png";
	public static final String ACCEPT_BUTTON = "gui/general/button_accept.png";
	public static final String ACCEPT_BUTTON_PUSHED = "gui/general/button_accept_pushed.png";
	public static final String BACK_BUTTON = "gui/general/back_button.png";
	public static final String BACK_BUTTON_PUSHED = "gui/general/back_button_pushed.png";
	public static final String DEATH_MENU_RETRY_BUTTON = "gui/deathmenu/retry_button.png";
	public static final String DEATH_MENU_RETRY_BUTTON_PUSHED = "gui/deathmenu/retry_button_pushed.png";
	public static final String DEATH_MENU_STARTMENU_BUTTON = "gui/deathmenu/startmenu_button.png";
	public static final String DEATH_MENU_STARTMENU_BUTTON_PUSHED = "gui/deathmenu/startmenu_button_pushed.png";
	public static final String START_MENU_LOGO = "gui/startmenu/logo.png";
	public static final String LEVEL_CHOICE_MENU_LEVEL_1_BUTTON = "gui/levelchoicemenu/level_1_button.png";
	public static final String LEVEL_CHOICE_MENU_LEVEL_1_BUTTON_PUSHED = "gui/levelchoicemenu/level_1_button_pushed.png";
	public static final String LEVEL_CHOICE_MENU_LEVEL_2_BUTTON = "gui/levelchoicemenu/level_2_button.png";
	public static final String LEVEL_CHOICE_MENU_LEVEL_2_BUTTON_PUSHED = "gui/levelchoicemenu/level_2_button_pushed.png";
	public static final String LEVEL_CHOICE_MENU_LEVEL_3_BUTTON = "gui/levelchoicemenu/level_3_button.png";
	public static final String LEVEL_CHOICE_MENU_LEVEL_3_BUTTON_PUSHED = "gui/levelchoicemenu/level_3_button_pushed.png";
	public static final String LEVEL_CHOICE_MENU_LEVEL_4_BUTTON = "gui/levelchoicemenu/level_4_button.png";
	public static final String LEVEL_CHOICE_MENU_LEVEL_4_BUTTON_PUSHED = "gui/levelchoicemenu/level_4_button_pushed.png";
	public static final String SHOP_MENU_PREVIEW_DIAMOND_DRAGONFLY = "gui/shopmenu/previews/diamond_dragonfly.png";
	public static final String SHOP_MENU_PREVIEW_OPAL_DRAGONFLY = "gui/shopmenu/previews/opal_dragonfly.png";
	public static final String SHOP_MENU_PREVIEW_RUBY_DRAGONFLY = "gui/shopmenu/previews/ruby_dragonfly.png";
	public static final String SHOP_MENU_PREVIEW_SWAMP_DRAGONFLY = "gui/shopmenu/previews/swamp_dragonfly.png";
	public static final String SHOP_BACK_BUTTON = "gui/shopmenu/back_button.png";
	public static final String SHOP_BUY_BUTTON = "gui/shopmenu/button_buy.png";
	public static final String SHOP_BUY_BUTTON_PUSHED = "gui/shopmenu/button_buy_pushed.png";
	public static final String SHOP_EQUIP_BUTTON = "gui/shopmenu/button_equip.png";
	public static final String SHOP_EQUIP_BUTTON_PUSHED = "gui/shopmenu/button_equip_pushed.png";
	public static final String SHOP_EQUIPPED_BUTTON = "gui/shopmenu/button_equipped.png";
	public static final String ADD_MONEY_BUTTON = "gui/shopmenu/add_money_button.png";
	public static final String ADD_MONEY_BUTTON_PUSHED = "gui/shopmenu/add_money_button_pushed.png";
		// Environments
				// Swamp
	public static final String SWAMP_BACKGROUND = "environments/swamp/swamp_background.png";
	public static final String SWAMP_GROUND = "environments/swamp/swamp_ground.png";
	public static final String SWAMP_SNAKE = "environments/swamp/decoration/layer_1/swamp_snake.png";
	public static final String SWAMP_TURTLE = "environments/swamp/decoration/layer_1/swamp_turtle.png";
	public static final String SWAMP_ALIGATOR = "environments/swamp/decoration/layer_1/swamp_aligator.png";
	public static final String SWAMP_FOLIAGE_1 = "environments/swamp/decoration/layer_2/swamp_foliage_1.png";
	public static final String SWAMP_FOLIAGE_2 = "environments/swamp/decoration/layer_2/swamp_foliage_2.png";
	public static final String SWAMP_FOLIAGE_3 = "environments/swamp/decoration/layer_2/swamp_foliage_3.png";
	public static final String SWAMP_FOLIAGE_4 = "environments/swamp/decoration/layer_2/swamp_foliage_4.png";
	public static final String SWAMP_FOLIAGE_5 = "environments/swamp/decoration/layer_2/swamp_foliage_5.png";
	public static final String SWAMP_FOLIAGE_6 = "environments/swamp/decoration/layer_2/swamp_foliage_6.png";
	public static final String SWAMP_FOLIAGE_7 = "environments/swamp/decoration/layer_2/swamp_foliage_7.png";
	public static final String SWAMP_CATTAILS = "environments/swamp/decoration/layer_3/swamp_cattails.png";
	public static final String SWAMP_CYPRESS_1 = "environments/swamp/decoration/layer_4/swamp_cypress_1.png";
	public static final String SWAMP_CYPRESS_2 = "environments/swamp/decoration/layer_4/swamp_cypress_2.png";
				// Opal
	public static final String OPAL_BACKGROUND = "environments/opal/opal_bg.png";
	public static final String OPAL_GROUND = "environments/opal/opal_ground.png";
	public static final String OPAL_CAVE = "environments/opal/decoration/layer_1/opal_cave.png";
	public static final String OPAL_GEM = "environments/opal/decoration/layer_1/opal_gem.png";
	public static final String OPAL_STALAGMITE_1 = "environments/opal/decoration/layer_2/opal_stalagmite_1.png";
	public static final String OPAL_STALAGMITE_2 = "environments/opal/decoration/layer_2/opal_stalagmite_2.png";
	public static final String OPAL_STALAGMITE_3 = "environments/opal/decoration/layer_2/opal_stalagmite_3.png";
	public static final String OPAL_STALAGMITE_4 = "environments/opal/decoration/layer_2/opal_stalagmite_4.png";
	public static final String OPAL_STALAGMITE_5 = "environments/opal/decoration/layer_2/opal_stalagmite_5.png";
	public static final String OPAL_STALACTITE_1 = "environments/opal/decoration/layer_2/opal_stalactite_1.png";
	public static final String OPAL_STALACTITE_2 = "environments/opal/decoration/layer_2/opal_stalactite_2.png";
	public static final String OPAL_STALACTITE_3 = "environments/opal/decoration/layer_2/opal_stalactite_3.png";
	public static final String OPAL_STALACTITE_4 = "environments/opal/decoration/layer_2/opal_stalactite_4.png";
				// Diamond
	public static final String DIAMOND_BACKGROUND = "environments/diamond/diamond_bg.png";
	public static final String DIAMOND_GROUND = "environments/diamond/diamond_ground.png";
	public static final String DIAMOND_CAVE = "environments/diamond/decoration/layer_1/diamond_cave.png";
	public static final String DIAMOND_GEM = "environments/diamond/decoration/layer_1/diamond_gem.png";
	public static final String DIAMOND_STALAGMITE_1 = "environments/diamond/decoration/layer_2/diamond_stalagmite_1.png";
	public static final String DIAMOND_STALAGMITE_2 = "environments/diamond/decoration/layer_2/diamond_stalagmite_2.png";
	public static final String DIAMOND_STALAGMITE_3 = "environments/diamond/decoration/layer_2/diamond_stalagmite_3.png";
	public static final String DIAMOND_STALAGMITE_4 = "environments/diamond/decoration/layer_2/diamond_stalagmite_4.png";
	public static final String DIAMOND_STALAGMITE_5 = "environments/diamond/decoration/layer_2/diamond_stalagmite_5.png";
	public static final String DIAMOND_STALACTITE_1 = "environments/diamond/decoration/layer_2/diamond_stalactite_1.png";
	public static final String DIAMOND_STALACTITE_2 = "environments/diamond/decoration/layer_2/diamond_stalactite_2.png";
	public static final String DIAMOND_STALACTITE_3 = "environments/diamond/decoration/layer_2/diamond_stalactite_3.png";
	public static final String DIAMOND_STALACTITE_4 = "environments/diamond/decoration/layer_2/diamond_stalactite_4.png";
				// Ruby
	public static final String RUBY_BACKGROUND = "environments/ruby/ruby_bg.png";
	public static final String RUBY_GROUND = "environments/ruby/ruby_ground.png";
	public static final String RUBY_CAVE = "environments/ruby/decoration/layer_1/ruby_cave.png";
	public static final String RUBY_GEM = "environments/ruby/decoration/layer_1/ruby_gem.png";
	public static final String RUBY_STALAGMITE_1 = "environments/ruby/decoration/layer_2/ruby_stalagmite_1.png";
	public static final String RUBY_STALAGMITE_2 = "environments/ruby/decoration/layer_2/ruby_stalagmite_2.png";
	public static final String RUBY_STALAGMITE_3 = "environments/ruby/decoration/layer_2/ruby_stalagmite_3.png";
	public static final String RUBY_STALAGMITE_4 = "environments/ruby/decoration/layer_2/ruby_stalagmite_4.png";
	public static final String RUBY_STALAGMITE_5 = "environments/ruby/decoration/layer_2/ruby_stalagmite_5.png";
	public static final String RUBY_STALACTITE_1 = "environments/ruby/decoration/layer_2/ruby_stalactite_1.png";
	public static final String RUBY_STALACTITE_2 = "environments/ruby/decoration/layer_2/ruby_stalactite_2.png";
	public static final String RUBY_STALACTITE_3 = "environments/ruby/decoration/layer_2/ruby_stalactite_3.png";
	public static final String RUBY_STALACTITE_4 = "environments/ruby/decoration/layer_2/ruby_stalactite_4.png";
		// Obstacles
	public static final String OBSTACLE_COBWEB_1 = "obstacles/cobwebs/cobweb_1.png";
	public static final String OBSTACLE_COBWEB_2 = "obstacles/cobwebs/cobweb_2.png";
	public static final String OBSTACLE_COBWEB_3 = "obstacles/cobwebs/cobweb_3.png";
	public static final String OBSTACLE_OPAL_STALAGMITE_1 = "obstacles/opal_stalagmites/opal_stalagmite_1.png";
	public static final String OBSTACLE_OPAL_STALAGMITE_2 = "obstacles/opal_stalagmites/opal_stalagmite_2.png";
	public static final String OBSTACLE_OPAL_STALAGMITE_3 = "obstacles/opal_stalagmites/opal_stalagmite_3.png";
	public static final String OBSTACLE_DIAMOND_STALAGMITE_1 = "obstacles/diamond_stalagmites/diamond_stalagmite_1.png";
	public static final String OBSTACLE_DIAMOND_STALAGMITE_2 = "obstacles/diamond_stalagmites/diamond_stalagmite_2.png";
	public static final String OBSTACLE_DIAMOND_STALAGMITE_3 = "obstacles/diamond_stalagmites/diamond_stalagmite_3.png";
	public static final String OBSTACLE_RUBY_STALAGMITE_1 = "obstacles/ruby_stalagmites/ruby_stalagmite_1.png";
	public static final String OBSTACLE_RUBY_STALAGMITE_2 = "obstacles/ruby_stalagmites/ruby_stalagmite_2.png";
	public static final String OBSTACLE_RUBY_STALAGMITE_3 = "obstacles/ruby_stalagmites/ruby_stalagmite_3.png";
	/* Lists */
		// Swamp lists
	public static ArrayList<String> SWAMP_GRAPHICS = new ArrayList<String>();
	public static ArrayList<String> SWAMP_DECORATIONS_1 = new ArrayList<String>();
	public static ArrayList<String> SWAMP_DECORATIONS_2 = new ArrayList<String>();
	public static ArrayList<String> SWAMP_DECORATIONS_3 = new ArrayList<String>();
	public static ArrayList<String> SWAMP_DECORATIONS_4 = new ArrayList<String>();
		// Opal lists
	public static ArrayList<String> OPAL_GRAPHICS = new ArrayList<String>();
	public static ArrayList<String> OPAL_DECORATIONS_1 = new ArrayList<String>();
	public static ArrayList<String> OPAL_DECORATIONS_2 = new ArrayList<String>();
		// Diamond lists
	public static ArrayList<String> DIAMOND_GRAPHICS = new ArrayList<String>();
	public static ArrayList<String> DIAMOND_DECORATIONS_1 = new ArrayList<String>();
	public static ArrayList<String> DIAMOND_DECORATIONS_2 = new ArrayList<String>();
		// Ruby lists
	public static ArrayList<String> RUBY_GRAPHICS = new ArrayList<String>();
	public static ArrayList<String> RUBY_DECORATIONS_1 = new ArrayList<String>();
	public static ArrayList<String> RUBY_DECORATIONS_2 = new ArrayList<String>();
		// Obstacles
	public static ArrayList<String> OBSTACLES = new ArrayList<String>();
	
	/** Suppress default constructor for noninstantiability */
	private AssetInfo() {
		throw new AssertionError();
	}

	/** Builds all string ArrayLists */
	public static void setUpArrayLists() {
		/* Swamp files */
			/* SWAMP Layers */
		SWAMP_DECORATIONS_1.add(SWAMP_ALIGATOR);
		SWAMP_DECORATIONS_1.add(SWAMP_SNAKE);
		SWAMP_DECORATIONS_1.add(SWAMP_TURTLE);
		SWAMP_DECORATIONS_2.add(SWAMP_FOLIAGE_1);
		SWAMP_DECORATIONS_2.add(SWAMP_FOLIAGE_2);
		SWAMP_DECORATIONS_2.add(SWAMP_FOLIAGE_3);
		SWAMP_DECORATIONS_2.add(SWAMP_FOLIAGE_4);
		SWAMP_DECORATIONS_2.add(SWAMP_FOLIAGE_5);
		SWAMP_DECORATIONS_2.add(SWAMP_FOLIAGE_6);
		SWAMP_DECORATIONS_2.add(SWAMP_FOLIAGE_7);
		SWAMP_DECORATIONS_3.add(SWAMP_CATTAILS);
		SWAMP_DECORATIONS_4.add(SWAMP_CYPRESS_1);
		SWAMP_DECORATIONS_4.add(SWAMP_CYPRESS_2);
			/* SWAMP Full */
		SWAMP_GRAPHICS.add(SWAMP_BACKGROUND); SWAMP_GRAPHICS.add(SWAMP_GROUND);
		SWAMP_GRAPHICS.addAll(SWAMP_DECORATIONS_1); SWAMP_GRAPHICS.addAll(SWAMP_DECORATIONS_2);
		SWAMP_GRAPHICS.addAll(SWAMP_DECORATIONS_3); SWAMP_GRAPHICS.addAll(SWAMP_DECORATIONS_4);
			/* OPAL Layers */
		OPAL_DECORATIONS_1.add(OPAL_CAVE);
		OPAL_DECORATIONS_1.add(OPAL_GEM);
		OPAL_DECORATIONS_2.add(OPAL_STALAGMITE_1);
		OPAL_DECORATIONS_2.add(OPAL_STALAGMITE_2);
		OPAL_DECORATIONS_2.add(OPAL_STALAGMITE_3);
		OPAL_DECORATIONS_2.add(OPAL_STALAGMITE_4);
		OPAL_DECORATIONS_2.add(OPAL_STALAGMITE_5);
		OPAL_DECORATIONS_2.add(OPAL_STALACTITE_1);
		OPAL_DECORATIONS_2.add(OPAL_STALACTITE_2);
		OPAL_DECORATIONS_2.add(OPAL_STALACTITE_3);
		OPAL_DECORATIONS_2.add(OPAL_STALACTITE_4);
			/* OPAL Full */
		OPAL_GRAPHICS.add(OPAL_BACKGROUND); OPAL_GRAPHICS.add(OPAL_GROUND);
		OPAL_GRAPHICS.addAll(OPAL_DECORATIONS_1); OPAL_GRAPHICS.addAll(OPAL_DECORATIONS_2);
			/* DIAMOND Layers */
		DIAMOND_DECORATIONS_1.add(DIAMOND_CAVE);
		DIAMOND_DECORATIONS_1.add(DIAMOND_GEM);
		DIAMOND_DECORATIONS_2.add(DIAMOND_STALAGMITE_1);
		DIAMOND_DECORATIONS_2.add(DIAMOND_STALAGMITE_2);
		DIAMOND_DECORATIONS_2.add(DIAMOND_STALAGMITE_3);
		DIAMOND_DECORATIONS_2.add(DIAMOND_STALAGMITE_4);
		DIAMOND_DECORATIONS_2.add(DIAMOND_STALAGMITE_5);
		DIAMOND_DECORATIONS_2.add(DIAMOND_STALACTITE_1);
		DIAMOND_DECORATIONS_2.add(DIAMOND_STALACTITE_2);
		DIAMOND_DECORATIONS_2.add(DIAMOND_STALACTITE_3);
		DIAMOND_DECORATIONS_2.add(DIAMOND_STALACTITE_4);
			/* DIAMOND Full */
		DIAMOND_GRAPHICS.add(DIAMOND_BACKGROUND); DIAMOND_GRAPHICS.add(DIAMOND_GROUND);
		DIAMOND_GRAPHICS.addAll(DIAMOND_DECORATIONS_1); DIAMOND_GRAPHICS.addAll(DIAMOND_DECORATIONS_2);
			/* RUBY Layers */
		RUBY_DECORATIONS_1.add(RUBY_CAVE);
		RUBY_DECORATIONS_1.add(RUBY_GEM);
		RUBY_DECORATIONS_2.add(RUBY_STALAGMITE_1);
		RUBY_DECORATIONS_2.add(RUBY_STALAGMITE_2);
		RUBY_DECORATIONS_2.add(RUBY_STALAGMITE_3);
		RUBY_DECORATIONS_2.add(RUBY_STALAGMITE_4);
		RUBY_DECORATIONS_2.add(RUBY_STALAGMITE_5);
		RUBY_DECORATIONS_2.add(RUBY_STALACTITE_1);
		RUBY_DECORATIONS_2.add(RUBY_STALACTITE_2);
		RUBY_DECORATIONS_2.add(RUBY_STALACTITE_3);
		RUBY_DECORATIONS_2.add(RUBY_STALACTITE_4);
			/* RUBY Full */
		RUBY_GRAPHICS.add(RUBY_BACKGROUND); RUBY_GRAPHICS.add(RUBY_GROUND);
		RUBY_GRAPHICS.addAll(RUBY_DECORATIONS_1); RUBY_GRAPHICS.addAll(RUBY_DECORATIONS_2);
		/* Obstacles files */
		OBSTACLES.add(OBSTACLE_COBWEB_1);
		OBSTACLES.add(OBSTACLE_COBWEB_2);
		OBSTACLES.add(OBSTACLE_COBWEB_3);
		OBSTACLES.add(OBSTACLE_OPAL_STALAGMITE_1);
		OBSTACLES.add(OBSTACLE_OPAL_STALAGMITE_2);
		OBSTACLES.add(OBSTACLE_OPAL_STALAGMITE_3);
		OBSTACLES.add(OBSTACLE_DIAMOND_STALAGMITE_1);
		OBSTACLES.add(OBSTACLE_DIAMOND_STALAGMITE_2);
		OBSTACLES.add(OBSTACLE_DIAMOND_STALAGMITE_3);
		OBSTACLES.add(OBSTACLE_RUBY_STALAGMITE_1);
		OBSTACLES.add(OBSTACLE_RUBY_STALAGMITE_2);
		OBSTACLES.add(OBSTACLE_RUBY_STALAGMITE_3);
	}
	
}
