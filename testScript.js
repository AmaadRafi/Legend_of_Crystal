/* Jason Allen 9/11/2019 9:47 PM.

This script is currently used to prototype different
functionalities of the player and inventory systems.
May later be used to serve as a database of all 
objects in the game.
*/ 

var team = createTeam("Jay", "Amaad", "Shabir");

var sword = new Weapon("Sword", "fire", "close", 150, false);
var greatSword = new Weapon("Great Sword", "none", "close", 250, false);
var dagger = new Weapon("Dagger", "none", "close", 100, false);
var bow = new Weapon("Bow", "none", "ranged", 100, false);
var gun = new Weapon("Gun", "none", "ranged", 200, false);
var staff = new Weapon("Staff", "none", "magic", 300, false);
var wand = new Weapon("Wand", "none", "magic", 200, false);

var iceArmor = new Armor("Ice Armor", "ice", "heavy", 1, false);

var potion = new Item("Potion", "consumable", true);
potion.setConsumeMessage("You used a " + potion.displayName);
var largePotion = new Item("Large Potion", "consumable", true);
largePotion.setConsumeMessage("You used a " + potion.displayName);

var weaponDatabase = [sword, greatSword, dagger, bow, gun];

for(var i = 0; i < weaponDatabase.length; i++){

   team[0].pickUp(weaponDatabase[i]);
   team[1].pickUp(weaponDatabase[i]);
   team[2].pickUp(weaponDatabase[i]);
}

team[0].pickUp(potion);
team[0].pickUp(largePotion);

team[0].debugPrintHeroStats();
team[0].debugPrintInventory();
team[1].debugPrintHeroStats();
team[1].debugPrintInventory();
team[2].debugPrintHeroStats();
team[2].debugPrintInventory();

team[0].pickUp(iceArmor);

team[0].changeWeapon("Gun");
team[0].changeArmor("Ice Armor");

team[0].debugPrintHeroStats();

team[0].changeWeapon("Potion");
team[0].debugPrintHeroStats();

team[0].changeWeapon("Great Sword");
team[0].debugPrintHeroStats();

team[0].drop("dagger");
team[0].use("knife");
team[0].use("potion");
team[0].debugPrintInventory();