/* Item Database
*/ 

/* Warrior */
var sword = new Weapon("Sword", "none", "close", 100, false);
var fireSword = new Weapon("Fire Sword", "fire", "close", 100, false);
var iceSword = new Weapon("Ice Sword", "ice", "close", 100, false);
var waterSword = new Weapon("Water Sword", "water", "close", 100, false);
var earthSword = new Weapon("Earth Sword", "earth", "close", 100, false);
var greatSword = new Weapon("Great Sword", "none", "close", 100, false);

var fireArmor = new Armor("Fire Armor", "fire", "heavy", 100, false);
var iceArmor = new Armor("Ice Armor", "ice", "heavy", 100, false);
var waterArmor = new Armor("Water Armor", "water", "heavy", 100, false);
var earthArmor = new Armor("Earth Armor", "earth", "heavy", 100, false);

/* Ranger */
var bow = new Weapon("Bow", "none", "ranged", 100, false);
var gun = new Weapon("Gun", "none", "ranged", 100, false);

/* Mage */
var staff = new Weapon("Staff", "none", "magic", 100, false);
var wand = new Weapon("Wand", "none", "magic", 100, false);

var fireRobe = new Armor("Fire Robe", "fire", "robe", 100, false);
var iceRobe = new Armor("Ice Robe", "ice", "robe", 100, false);
var waterRobe = new Armor("Water Robe", "water", "robe", 100, false);
var earthRobe = new Armor("Earth Robe", "earth", "robe", 100, false);

/* Items */

var potion = new Item("Potion", "consumable", true);
potion.setConsumeMessage("You used a " + potion.displayName);
var largePotion = new Item("Large Potion", "consumable", true);
largePotion.setConsumeMessage("You used a " + largePotion.displayName);
var elixir = new Item("Elixir", "consumable", true);
elixir.setConsumeMessage("You used a " + elixir.displayName);

/* Basic Weapons/Armor
 * Amaad Rafi 
 * 9/15/19
 */

// WARRIOR
var schimitar = new Weapon("SCHIMITAR", "NONE", "CLOSE", 150, false);
var heavy_sword = new Weapon("HEAVY SWORD", "NONE", "CLOSE", 200, false);

// MAGE
var ice_staff = new Weapon("ICE STAFF", "ICE", "RANGED", 200, false);
var fire_staff = new Weapon("FIRE STAFF", "FIRE", "RANGED", 300, false);

// ARCHER
var bow = new Weapon("BOW", "NONE", "RANGED", 250, false);
var crossbow = new Weapon("CROSSBOW", "NONE", "RANGED", 300, false);

// BRAWLER - earth bender for now, but we can add more elements (think Thanos w/ gauntlet + stones(elements))
var gauntlet = new Weapon("GAUNTLET", "EARTH", "MELEE", 200, false);

// ARMOR - let's keep it simple, I don't think we need elements for armor
var cloth_armor = new Armor("CLOTH ARMOR", "NONE", "LIGHT", 10, false);
var chain_vest = new Armor("CHAIN VEST", "NONE", "HEAVY", 25, false);
var robe = new Armor("ROBE", "NONE", "LIGHT", 10, false);