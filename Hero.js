/* Jason Allen 9/11/2019 9:47 PM.

This script defines classes for player characters that will
be found in the game.  Base iteration of the game will have 
a single hero, but the code will allow for multiple if necessary.

Note that toUpperCase() is used when comparing objects to prevent
user typing errors
*/ 
var inventorySize = 10;
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
        this.attackModifier = attackModifier;
        this.defenseModifier = defenseModifier;
        this.weapon = null;
        this.armor = null;
        this.inventory = new Array(inventorySize);
    }
    /* toDo create attack function 
    
    calculated damage will be enemyDefense - (weaponStrength * attackModifier);

    Jason Allen 9/11/2019
    */
    attack(){

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
    use(thisItem){
    
        var inventoryItemIndex = this.searchForItem(thisItem);

        if(inventoryItemIndex == -1)
            this.alertItemNotFound(thisItem);
        else{
            var inventoryItem = this.inventory[inventoryItemIndex];

            if(inventoryItem.isConsumable){ 
                delete this.inventory[inventoryItemIndex];
                this.alertUsedItem(thisItem);
            }
            else{
                this.alertNonConsumable(thisItem);
            }
        }
    }
    /*================================== changeWeapon =====================================
    Similar behavior to 'use' (see above).  Item is not removed from inventory.  Calls 
    searchForItem().  Returns nothing.

    Jason Allen 9/11/2019
    */ 
    changeWeapon(thisItem){
        var inventoryItemIndex = this.searchForItem(thisItem);
        if(inventoryItemIndex == -1)
            this.alertItemNotFound(thisItem);
        else{
            var inventoryItem = this.inventory[inventoryItemIndex];
            
            if(inventoryItem.type != "WEAPON")
                this.alertCannotEquipSlot(inventoryItem.name, "weapon");
            else if(inventoryItem.weaponType != this.allowedWeaponType)
                this.alertCannotEquip(inventoryItem.name, this.heroType)
            else
                this.weapon = inventoryItem;
        }
    }
     /*================================== changeArmor =====================================
    Same as changeWeapon()

    Jason Allen 9/11/2019
    */ 
   changeArmor(thisItem){
    var inventoryItemIndex = this.searchForItem(thisItem);
    if(inventoryItemIndex == -1)
        this.alertItemNotFound(thisItem);
    else{
        var inventoryItem = this.inventory[inventoryItemIndex];
        
        if(inventoryItem.type != "ARMOR")
                this.alertCannotEquipSlot(inventoryItem.name, "armor");
            else if(inventoryItem.weaponType != this.allowedArmorType)
                this.alertCannotEquip(inventoryItem.name, this.heroType)
            else
                this.weapon = inventoryItem;
    }
}
    /*================================== pickup =====================================
    Searches for an empty inventory space and deposits the item there.  Otherwise,
    alert that inventory is full.  Returns nothing.

    Jason Allen 9/11/2019
    */ 
    pickUp(thisItem){ /* toDo: probably needs to search the item database and match by name.  Jason Allen 9/11/2019 */

        for(var i = 0; i < this.inventory.length; i++){

            if(this.inventory[i] == null){
                this.inventory[i] = thisItem;
                return;
            }
        }
        this.alertInventoryFull();

    }
     /*================================== drop =====================================
    Almost identical behavior to use (see above).  Removes item from inventory.
    Calls searchForItem().  Returns nothing.

    Jason Allen 9/11/2019
    */ 
    drop(thisItem){
        var inventoryItemIndex = this.searchForItem(thisItem);

        if(inventoryItemIndex == -1)
            this.alertItemNotFound(thisItem);
        else{
            var inventoryItem = this.inventory[inventoryItemIndex];

            delete this.inventory[inventoryItemIndex];
            this.alertDroppedItem(thisItem);
        }
    }
     /*================================== searchForItem =====================================
    Helper function to search the inventory for a specific item.  Item is searched by string.
    The argument is protected for comparison by first converting into upper case, which was
    also previously done for all elements currently in the inventory array.  Returns the index
    of the item if it is found.  Returns -1 on failure.

    Jason Allen 9/11/2019
    */ 
    searchForItem(thisItem){
        var itemName = thisItem.toUpperCase();
        for(var i = 0; i < this.inventory.length; i++){

            var currentInventoryItem = this.inventory[i];

            if(currentInventoryItem != null && currentInventoryItem.name === itemName){ 
               return i;
            }
        }
        return -1;
    }
    
    alertInventoryFull(){
        console.log("inventory full!\n"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertItemNotFound(thisItem){
        console.log(thisItem + " not found."); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertDroppedItem(thisItem){
        console.log("you dropped a " + thisItem + "\n"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertNonConsumable(thisItem){
        console.log("You tried to use the " + thisItem + ", but nothing happened"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertUsedItem(thisItem){
        console.log("you used a " + thisItem + "\n"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertCannotEquip(thisItem, heroType){
        console.log(thisItem + " cannot be equppied by " + heroType);
    }
    alertCannotEquipSlot(thisItem, slot){
        console.log("you cannot equip " + thisItem + " in the " + slot + " slot");
    }
    debugPrintHeroStats(){
        console.log("hero name is: " + this.name + "\thero HP is: " + this.hitpoints + "\thero weapon is: " + this.weapon.getName() + 
        "\thero aromor is: " + this.armor.getName());
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
        var defaultWarWeapon = new Weapon("Sword", "none", "close", 10, false);
        var defaultWarClothes = new Armor("Clothes", "none", "heavy", 1, false);
        this.pickUp(defaultWarWeapon);
        this.pickUp(defaultWarClothes);
        this.weapon = defaultWarWeapon;
        this.armor = defaultWarClothes;
    }
}
class HeroMage extends Hero{

    constructor(name) {
        super(name);
        this.name = name + " the Mage";
        this.heroType = "MAGE";
        this.allowedWeaponType = "MAGIC";
        this.allowedArmorType = "ROBE";
        var defaultMageWeapon = new Weapon("Wand", "none", "magic", 10, false);
        var defaultMageClothes = new Armor("Clothes", "none", "robe", 1, false);
        this.pickUp(defaultMageWeapon);
        this.pickUp(defaultMageClothes);
        this.weapon = defaultMageWeapon;
        this.armor = defaultMageClothes;
    }
}
class HeroRanger extends Hero{

    constructor(name) {
        super(name);
        this.name = name + " the Ranger";
        this.heroType = "RANGER";
        this.allowedWeaponType = "RANGED";
        this.allowedArmorType = "LIGHT";
        var defaultRangeWeapon = new Weapon("Bow", "none", "ranged", 10, false);
        var defaultRangeClothes = new Armor("Clothes", "none", "light", 1, false);
        this.pickUp(defaultRangeWeapon);
        this.pickUp(defaultRangeClothes);
        this.weapon = defaultRangeWeapon;
        this.armor = defaultRangeClothes;
    }
}