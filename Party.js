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
        hero.changeWeapon(weapon, this.inventory);
    }
    changeArmor(heroType, armor){

        var hero = this.selectHero(heroType);
        hero.changeArmor(armor, this.inventory);
    }
    use(heroType, item){

        var hero = this.selectHero(heroType);
        hero.use(item, this.inventory);
    }
    alertHeroNotFound(heroName){
        alert(heroName + " not found"); /* toDo: this statement must go in the real game - Jason Allen 9/11/2019 */
    }
}
class BattleParty{

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
    attack(enemy, hero){

        if(hero.actionThisTurn == false){
            
            hero.actionThisTurn = true;
            hero.attack(enemy);
            console.log(hero.name + " attacked " + enemy.name);
        }
        else{
            console.log(hero.name + " may only move once per turn");
        }
    }
    resetStates(){
        this.warrior.actionThisTurn = false;
        this.mage.actionThisTurn = false;
        this.ranger.actionThisTurn = false;
    }
}