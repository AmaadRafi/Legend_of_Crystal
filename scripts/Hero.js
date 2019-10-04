/* Jason Allen 9/11/2019 9:47 PM.

This script defines classes for player characters that will
be found in the game.  Base iteration of the game will have 
a single hero, but the code will allow for multiple if necessary.

Note that toUpperCase() is used when comparing objects to prevent
user typing errors
*/ 
var hitpoints = 100;
var attackModifier = 1.0;
var defenseModifier = 1.0;

class Hero {
    constructor(name) {
        this.name = name;
        this.heroType = null;
        this.allowedWeaponType = null;
        this.allowedArmorType = null;
        this.hitpoints = hitpoints;
        this.weapon = null;
        this.armor = null;
        this.actionThisTurn = false;
        this.isInvulnerable = false;
    }
    /* toDo create attack function 
    
    calculated damage will be enemyDefense - (weaponStrength * attackModifier);

    Jason Allen 9/11/2019
    */
    attack(enemy){
        if(!enemy.isInvulnerable)
        enemy.hitpoints -= this.weapon.attackPower;
    }
    /* toDo create takeDamage function 
    
    calculated damage will be damageAmount - (armorValue * defensemodifier);

    Jason Allen 9/11/2019
    */
    takeDamage(){ 

    }
    /*================================== use =====================================
    Uses an item specified by the user.  Item argument must be of type 'string'.
    The inventory array is searched for the item, and it is deleted from the
    inventory if it is consumable.  Calls searchForItem().  Returns nothing.

    Jason Allen 9/11/2019
    */ 
    use(thisItem, inventory){
    
        var inventoryItemIndex = this.searchForItem(thisItem, inventory);

        if(inventoryItemIndex == -1)
            this.alertItemNotFound(thisItem);
        else{
            var inventoryItem = inventory[inventoryItemIndex];

            if(inventoryItem.isConsumable){ 
                delete inventory[inventoryItemIndex];
                this.alertUsedItem(thisItem);
            }
            else{
                this.alertNonConsumable(thisItem);
            }
        }
    }
    /*================================== changeWeapon =====================================
    Similar behavior to 'use' (see above).  Item is removed from inventory and swapped with
    the currently held weapon.  Calls searchForItem().  Returns nothing.

    Jason Allen 9/11/2019
    */ 
    changeWeapon(thisItem, inventory){
        var inventoryItemIndex = this.searchForItem(thisItem, inventory);
        if(inventoryItemIndex == -1)
            this.alertItemNotFound(thisItem);
        else{
            var inventoryItem = inventory[inventoryItemIndex];
            
            if(inventoryItem.type != "WEAPON")
                this.alertCannotEquipSlot(inventoryItem.name, "weapon");
            else if(inventoryItem.weaponType != this.allowedWeaponType)
                this.alertCannotEquip(inventoryItem.name, this.heroType)
            else{
                var oldWeapon = this.weapon;
                this.weapon = inventoryItem;
                inventory[inventoryItemIndex] = oldWeapon;
                this.alertEquippedItem(this.weapon.displayName);
            }
        }
    }
     /*================================== changeArmor =====================================
    Same as changeWeapon()

    Jason Allen 9/11/2019
    */ 
   changeArmor(thisItem, inventory){
    var inventoryItemIndex = this.searchForItem(thisItem, inventory);
    if(inventoryItemIndex == -1)
        this.alertItemNotFound(thisItem);
    else{
        var inventoryItem = inventory[inventoryItemIndex];
        
        if(inventoryItem.type != "ARMOR")
                this.alertCannotEquipSlot(inventoryItem.name, "armor");
            else if(inventoryItem.armorType != this.allowedArmorType)
                this.alertCannotEquip(inventoryItem.name, this.heroType)
            else{
                var oldArmor= this.armor;
                this.armor = inventoryItem;
                inventory[inventoryItemIndex] = oldArmor;
                this.alertEquippedItem(this.armor.displayName);
            }
    }
}
     /*================================== searchForItem =====================================
    Helper function to search the inventory for a specific item.  Item is searched by string.
    The argument is protected for comparison by first converting into upper case, which was
    also previously done for all elements currently in the inventory array.  Returns the index
    of the item if it is found.  Returns -1 on failure.

    Jason Allen 9/11/2019
    */ 
    searchForItem(thisItem, inventory){
        var itemName = thisItem.toUpperCase();
        for(var i = 0; i < inventory.length; i++){

            var currentInventoryItem = inventory[i];

            if(currentInventoryItem != null && currentInventoryItem.name === itemName){ 
               return i;
            }
        }
        return -1;
    }
    alertItemNotFound(thisItem){
        console.log(thisItem + " not found."); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertNonConsumable(thisItem){
        console.log("You tried to use the " + thisItem + ", but nothing happened"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertUsedItem(thisItem){
        console.log("you used a " + thisItem + "\n"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertEquippedItem(thisItem){
        console.log(this.name + " equipped " + thisItem);
    }
    alertCannotEquip(thisItem, heroType){
        console.log(thisItem + " cannot be equppied by " + heroType); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertCannotEquipSlot(thisItem, slot){
        console.log("you cannot equip " + thisItem + " in the " + slot + " slot"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    debugPrintHeroStats(){
        console.log("hero name is: " + this.name + "\thero HP is: " + this.hitpoints + "\thero weapon is: " + this.weapon.name + 
        "\thero aromor is: " + this.armor.name); 
    }
    debugPrintInventory(){
        console.log(this.inventory.join());
    }
}
class HeroWarrior extends Hero{
    
    constructor(name) {
        super(name);
        this.name = name + " the Warrior";
        this.heroType = "WARRIOR";
        this.allowedWeaponType = "CLOSE";
        this.allowedArmorType = "HEAVY";
        var defaultWarWeapon = new Weapon("Sword", "none", "close", 100, false, "images/weapons/Scimitar.png");
        var defaultWarClothes = new Armor("Warrior Clothes", "none", "heavy", 100, false, "");
        this.weapon = defaultWarWeapon;
        this.armor = defaultWarClothes;
    }
    
    /*================================== createFromCache =====================================
    retrieves saved hero data from window.localStorage, and parses it into a new identical
    hero object.  It is necessary to create a new object because JSON does not include
    function definitions when it converts a class to a string via stringify().  For the same
    reason, we must also recreate the weapons and armor the hero is holding.

    Jason Allen 9/14/2019
    */
    static createFromCache(heroData) {
        var heroObject = Object.assign(new HeroWarrior(), JSON.parse(heroData));

        heroObject.weapon = new Weapon(heroObject.weapon.displayName, heroObject.weapon.element, 
            heroObject.weapon.weaponType, heroObject.weapon.attackPower, 
            heroObject.weapon.isConsumable, heroObject.weapon.imageSource);

        heroObject.armor = new Armor(heroObject.armor.displayName, heroObject.armor.element, 
            heroObject.armor.armorType, heroObject.armor.defenseValue, 
            heroObject.armor.isConsumable, heroObject.armor.imageSource);

        return heroObject;
    }
}
class HeroMage extends Hero{

    constructor(name) {
        super(name);
        this.name = name + " the Mage";
        this.heroType = "MAGE";
        this.allowedWeaponType = "MAGIC";
        this.allowedArmorType = "ROBE";
        var defaultMageWeapon = new Weapon("Wand", "none", "magic", 100, false, "images/weapons/Ice_Staff.png");
        var defaultMageClothes = new Armor("Mage Clothes", "none", "robe", 100, false, "");
        this.weapon = defaultMageWeapon;
        this.armor = defaultMageClothes;
    }
    
    /*================================== createFromCache =====================================
    see above

    Jason Allen 9/14/2019
    */
    static createFromCache(heroData) {
        var heroObject = Object.assign(new HeroMage(), JSON.parse(heroData));

        heroObject.weapon = new Weapon(heroObject.weapon.displayName, heroObject.weapon.element, 
            heroObject.weapon.weaponType, heroObject.weapon.attackPower, 
            heroObject.weapon.isConsumable, heroObject.weapon.imageSource);

        heroObject.armor = new Armor(heroObject.armor.displayName, heroObject.armor.element, 
            heroObject.armor.armorType, heroObject.armor.defenseValue, 
            heroObject.armor.isConsumable, heroObject.armor.imageSource);

        return heroObject;
    }
}
class HeroRanger extends Hero{

    constructor(name) {
        super(name);
        this.name = name + " the Ranger";
        this.heroType = "RANGER";
        this.allowedWeaponType = "RANGED";
        this.allowedArmorType = "LIGHT";
        var defaultRangeWeapon = new Weapon("Bow", "none", "ranged", 100, false, "images/weapons/Bow.png");
        var defaultRangeClothes = new Armor("Ranger Clothes", "none", "light", 100, false, "");
        this.weapon = defaultRangeWeapon;
        this.armor = defaultRangeClothes;
    }
    
    /*================================== createFromCache =====================================
    see above

    Jason Allen 9/14/2019
    */
    static createFromCache(heroData) {
        var heroObject = Object.assign(new HeroRanger(), JSON.parse(heroData));

        heroObject.weapon = new Weapon(heroObject.weapon.displayName, heroObject.weapon.element, 
            heroObject.weapon.weaponType, heroObject.weapon.attackPower, 
            heroObject.weapon.isConsumable, heroObject.weapon.imageSource);

        heroObject.armor = new Armor(heroObject.armor.displayName, heroObject.armor.element, 
            heroObject.armor.armorType, heroObject.armor.defenseValue, 
            heroObject.armor.isConsumable, heroObject.armor.imageSource);
            
        return heroObject;
    }
}
class HeroSavior extends Hero{
    constructor(name) {
        super(name);
        this.name = "Sonaht"
        this.heroType = "SAVIOR";
        this.allowedWeaponType = "GAUNLET";
        this.allowedArmorType = "NONE";
        var defaultRangeWeapon = new Weapon("Empty Gauntlet", "none", "gauntlet", 1, false);
        var defaultRangeClothes = new Armor("Clothes", "none", "light", 1, false);
        this.weapon = defaultRangeWeapon;
        this.armor = defaultRangeClothes;
    }
    
    /*================================== createFromCache =====================================
    see above

    Jason Allen 9/14/2019
    */
    static createFromCache(heroData) {
        var heroObject = Object.assign(new HeroRanger(), JSON.parse(heroData));

        heroObject.weapon = new Weapon(heroObject.weapon.displayName, heroObject.weapon.element, 
            heroObject.weapon.weaponType, heroObject.weapon.attackPower, 
            heroObject.weapon.isConsumable, heroObject.weapon.imageSource);

        heroObject.armor = new Armor(heroObject.armor.displayName, heroObject.armor.element, 
            heroObject.armor.armorType, heroObject.armor.defenseValue, 
            heroObject.armor.isConsumable, heroObject.armor.imageSource);

        return heroObject;
    }
}