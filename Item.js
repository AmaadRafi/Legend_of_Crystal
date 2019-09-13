/*Jason Allen 9/11/2019 9:47 PM.
This script defines classes for all the items that will
be found in the game.

Note that toUpperCase() is used when comparing objects to prevent
user typing errors
*/ 

/*toDo: Come up with a list of weapon types

Jason Allen 9/11/2019 9:47 PM.
*/

class Item{
    constructor(displayName, type, isConsumable){
        this.handleParentExceptions(displayName, type, isConsumable);
        this.displayName = displayName;
        this.name = displayName.toUpperCase();
        this.type = type.toUpperCase();
        this.isConsumable = isConsumable;
        this.consumeMessage = "";
    }
    setConsumeMessage(consumeMessage){
        this.consumeMessage = consumeMessage;
    }
    getConsumeMessage(){
        return this.consumeMessage;
    }
    getName(){
        if(this.name == null)
            return "none equipped";
        else
            return this.name;
    }
    displayName(){
        return this.displayName;
    }
    toString (){
        return this.displayName;
    }
    // throw an exception if incorrect input - Jason Allen 9/11/2019
    handleParentExceptions(displayName, type, isConsumable) {
        try { 
            if ((typeof displayName === "string") == false)
                throw "displayName must be a string value";
        }
        catch (e) {
            throw new SyntaxError(e);
        }
        try { 
            if ((typeof type === "string") == false)
                throw "type must be a string value";
        }
        catch (e) {
            throw new SyntaxError(e);
        }
        try { 
            if ((typeof isConsumable === "boolean") == false)
                throw "isConsumable must be a boolean value";
        }
        catch (e) {
            throw new SyntaxError(e);
        }
    }
}
class Weapon extends Item {
    constructor(displayName, element, weaponType, attackPower, isConsumable) {
        
        super(displayName, "weapon", isConsumable);
        this.handleChildExceptions(element, weaponType, attackPower);
        this.element = element.toUpperCase();
        this.weaponType = weaponType.toUpperCase();
        this.attackPower = attackPower;
        
        if(this.element != "NONE")
            this.displayName = displayName + " (" + element.toLowerCase() + ")";
    }
    // throw an exception if incorrect input - Jason Allen 9/11/2019
    handleChildExceptions(element, weaponType, attackPower) {
        try { 
            if ((typeof element === "string") == false)
                throw "element must be a string value";
        }
        catch (e) {
            throw new SyntaxError(e);
        }
        try { 
            if ((typeof weaponType === "string") == false)
                throw "weaponType must be a string value";
        }
        catch (e) {
            throw new SyntaxError(e);
        }
        try { 
            if (Number.isInteger(attackPower) == false)
                throw "attackPower must be an integer";
        }
        catch (e) {
            throw new SyntaxError(e);
        }
    }
}
class Armor extends Item{
    constructor(displayName, element, armorType, defenseValue, isConsumable) {
        
        super(displayName, "armor", isConsumable);
        this.handleChildExceptions(element, armorType, defenseValue);
        this.element = element.toUpperCase();
        this.armorType = armorType.toUpperCase();
        this.defenseValue = defenseValue;

        if(this.element != "NONE")
            this.displayName = displayName + " (" + element.toLowerCase() + ")";
    }
    // throw an exception if incorrect input - Jason Allen 9/11/2019
    handleChildExceptions(element, armorType, defenseValue) {
        try { 
            if ((typeof element === "string") == false)
                throw "element must be a string value";
        }
        catch (e) {
            throw new SyntaxError(e);
        }
        try { 
            if ((typeof armorType === "string") == false)
                throw "armorType must be a string value";
        }
        catch (e) {
            throw new SyntaxError(e);
        }
        try { 
            if (Number.isInteger(defenseValue) == false)
                throw "defenseValue must be an integer";
        }
        catch (e) {
            throw new SyntaxError(e);
        }
    }
}