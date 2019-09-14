/* Jason Allen 9/11/2019 9:47 PM.

This script is currently used to prototype different
functionalities of the player and inventory systems.
May later be used to serve as a database of all 
objects in the game.
*/ 
var warriorObject = HeroWarrior.getFromCache(window.localStorage.getItem('warrior'));
var mageObject = HeroMage.getFromCache(window.localStorage.getItem('mage'));
var rangerObject = HeroRanger.getFromCache(window.localStorage.getItem('ranger'));
var inventoryObject = Inventory.getFromCache(window.localStorage.getItem('Inventory'));
var party = new Party(warriorObject, mageObject, rangerObject, inventoryObject.inventory);

var sword = new Weapon("Sword", "fire", "close", 150, false);
var greatSword = new Weapon("Great Sword", "none", "close", 250, false);
var dagger = new Weapon("Dagger", "none", "close", 100, false);
var bow = new Weapon("Bow", "none", "ranged", 100, false);
var gun = new Weapon("Gun", "none", "ranged", 200, false);
var staff = new Weapon("Staff", "none", "magic", 300, false);
var wand = new Weapon("Wand", "none", "magic", 200, false);

var iceArmor = new Armor("Ice Armor", "ice", "heavy", 1, false);
var waterRobe = new Armor("Water Robe", "water", "robe", 30, false);

var potion = new Item("Potion", "consumable", true);
potion.setConsumeMessage("You used a " + potion.displayName);
var largePotion = new Item("Large Potion", "consumable", true);
largePotion.setConsumeMessage("You used a " + potion.displayName);

var weaponDatabase = [sword, greatSword, dagger, bow, gun];

for(var i = 0; i < weaponDatabase.length; i++){

   inventoryObject.pickUp(weaponDatabase[i]);
}

inventoryObject.pickUp(potion);
inventoryObject.pickUp(largePotion);

party.warrior.debugPrintHeroStats();
inventoryObject.debugPrintInventory();
party.mage.debugPrintHeroStats();
inventoryObject.debugPrintInventory();
party.ranger.debugPrintHeroStats();

inventoryObject.pickUp(iceArmor);
inventoryObject.pickUp(waterRobe);
inventoryObject.debugPrintInventory();

party.changeWeapon("warrior", "gun");
party.changeArmor("warrior", "ice armor");
party.changeArmor("Ranger", "Water Robe");
party.changeArmor("mage", "Water Robe");

party.mage.debugPrintHeroStats();

party.changeWeapon("warrior", "potion");
party.warrior.debugPrintHeroStats();

party.changeWeapon("warrior", "great sword");
party.warrior.debugPrintHeroStats();

inventoryObject.drop("dagger", inventoryObject.inventory);
party.use("warrior", "knife");
party.use("warrior", "potion");
inventoryObject.debugPrintInventory();