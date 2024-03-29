/* Jason Allen 9/11/2019 2:43 AM.

This script defines the 'Party' class for a team of 3 heroses.
The goal of the script is to encapsulate the underlying methods
away from the user.
*/ 

class Party {

    constructor(warrior, mage, ranger, inventory){
        this.warrior = warrior;
        this.mage = mage;
        this.ranger = ranger;
        this.inventory = inventory;
    }
    selectHero(heroType){

        var heroName = heroType.toUpperCase();

        switch (heroName) {
            case this.warrior.heroType:
                return this.warrior;
            case this.mage.heroType:
                return this.mage;
            case this.ranger.heroType:
                return this.ranger;
            default:
                this.alertHeroNotFound(heroName);
        }
    }
    changeWeapon(heroType, weapon){

        var hero = this.selectHero(heroType);
        hero.changeWeapon(weapon, this.inventory.inventory);

        this.inventory.buildInventoryDisplay();
        this.inventory.showInventory();

        CacheHandler.addToCache(this.warrior, this.mage, this.ranger, this.inventory);
    }
    changeArmor(heroType, armor){

        var hero = this.selectHero(heroType);
        hero.changeArmor(armor, this.inventory.inventory);

        this.inventory.buildInventoryDisplay();
        this.inventory.showInventory();

        CacheHandler.addToCache(this.warrior, this.mage, this.ranger, this.inventory);
    }
    use(heroType, item){

        var hero = this.selectHero(heroType);
        hero.use(item, this.inventory.inventory);

        this.inventory.buildInventoryDisplay();
        this.inventory.showInventory();
    }
    resetHP(){
        this.warrior.hitpoints = 100;
        this.mage.hitpoints = 100;
        this.ranger.hitpoints = 100;
    }
    alertHeroNotFound(heroName){
        alert(heroName + " not found"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
}

class BattleParty extends Party{

    constructor(warrior, mage, ranger, inventory, currentEnemy){
        super(warrior, mage, ranger, inventory);
        this.currentEnemy = currentEnemy;
    }
    attack(enemyName, heroType){

        var hero = this.selectHero(heroType);
        enemyName = enemyName.toUpperCase();
        
        if(enemyName == this.currentEnemy.name){
            if(hero.actionThisTurn == false){
                
                hero.actionThisTurn = true;
                hero.attack(this.currentEnemy);
                console.log(hero.name + " attacked " + this.currentEnemy.displayName);
            }
            else{
                console.log(hero.name + " may only move once per turn");
            }
        }
        else{
            console.log(enemyName + " is not the current enemy.  Try again.");
        }
        console.log("\n");
    }
    use(heroType, item){
        var hero = this.selectHero(heroType);
        var usedItem = hero.use(item, this.inventory.inventory);

        return usedItem;

    }
    takeTreasure(){
        for(var i = 0; i < currentEnemy.treasureChest.length; i++){
            this.inventory.pickUp(currentEnemy.treasureChest[i]);
        }
    }
    resetStates(){
        this.warrior.actionThisTurn = false;
        this.mage.actionThisTurn = false;
        this.ranger.actionThisTurn = false;
    }
}