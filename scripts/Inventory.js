/* Jason Allen 9/14/2019 10:47 PM.

This script defines the inventory and defines 
methods for the player to interact with it
*/ 

var inventorySize = 30;

class Inventory{

    constructor(){

        this.inventory = new Array(inventorySize);
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
                this.alertItemPickedUp(thisItem.displayName);
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
    /*================================== createFromCache =====================================
    retrieves saved inventory data from window.localStorage, and parses it into a new identical
    inventory object.  It is necessary to create a new object because JSON does not include
    function definitions when it converts a class to a string via stringify().  It also isn't
    capable of storing arrays of objects, so we must also recreate every item

    Jason Allen 9/14/2019
    */
    static createFromCache(inventoryData) {
        
        var InventoryObject = Object.assign(new Inventory(), JSON.parse(inventoryData));

        for(var i = 0; i < inventorySize; i++){

            var indexData = InventoryObject.inventory[i];
         
            if(indexData != null){
                if(indexData.type == "CONSUMABLE")
                    InventoryObject.inventory[i] = new Item(InventoryObject.inventory[i].displayName, 
                        InventoryObject.inventory[i].type, InventoryObject.inventory[i].isConsumable, 
                        InventoryObject.inventory[i].imageSource);
                else if(indexData.type == "WEAPON")
                    InventoryObject.inventory[i] = new Weapon(InventoryObject.inventory[i].displayName, 
                        InventoryObject.inventory[i].element, InventoryObject.inventory[i].weaponType, 
                        InventoryObject.inventory[i].attackPower, InventoryObject.inventory[i].isConsumable, 
                        InventoryObject.inventory[i].imageSource);
                else if(indexData.type == "ARMOR")
                    InventoryObject.inventory[i] = new Armor(InventoryObject.inventory[i].displayName, 
                        InventoryObject.inventory[i].element, InventoryObject.inventory[i].armorType, 
                        InventoryObject.inventory[i].defenseValue, InventoryObject.inventory[i].isConsumable,
                        InventoryObject.inventory[i].imageSource);
            }
         }

        return InventoryObject;
    }
    buildInventoryDisplay(){
    
        var background = document.getElementById("background");
        var inventoryScreen = document.getElementById("inventory");

        if(inventoryScreen == null){
            background.innerHTML +=  "<div id='inventory' class='inventoryOverlay'></div>";
            inventoryScreen = document.getElementById("inventory");
        }
        else{
            inventoryScreen.innerHTML = "";
        }
        var firstImagePosition = 1;
        var rowPosition = 2;
        for(var i = 0; i < inventorySize; i++){

            if(i > 0 && i % 10 == 0){
                rowPosition += 15;
                firstImagePosition = 1;
            }
            try {
                var imageSource = this.inventory[i].imageSource;
                var thisItemName = this.inventory[i].name;
            } catch (error) {
                imageSource = "";
                thisItemName = "empty";
            }
            inventoryScreen.innerHTML += "<div class='treasureBoxVerySmall'"+" style='top: "+rowPosition+"%; left: "
            +firstImagePosition+"%;'>"+"<img class='inventoryImage' src="+imageSource+"></div><div class='marquee' style='top: "
            +(rowPosition + 10)+"%; left: "+firstImagePosition+"%;'><b>"+thisItemName+"</b></div>";
            firstImagePosition += 9;
        }
        inventoryScreen.style.display = "block";
    }
    showInventory(){
        var inventoryScreen = document.getElementById("inventory");

        if(inventoryScreen == null){
            this.buildInventoryDisplay();
            inventoryScreen = document.getElementById("inventory");
        }
        inventoryScreen.style.display = "block";
    }
    hideInventory(){
        
        var inventoryScreen = document.getElementById("inventory").style.display = "none";
    }
    alertInventoryFull(){
        console.log("Inventory Full!\n"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
        onsole.log(" ");
    }
    alertItemNotFound(thisItem){
        console.log(thisItem + " not found."); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
        console.log(" ");
    }
    alertItemPickedUp(thisItem){
        console.log("You picked up a " + thisItem); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    alertDroppedItem(thisItem){
        console.log("You dropped a " + thisItem + "\n"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
    debugPrintInventory(){
        console.log(this.inventory.join());
    }
}