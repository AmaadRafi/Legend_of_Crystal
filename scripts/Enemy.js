/* Jason Allen 9/15/2019 5:14 PM.

This script defines classes for enemy characters that will
be found in the game.
*/ 

class Enemy {
    constructor(name, hitpoints, weapon, armor, treasureChest) {
        this.name = name.toUpperCase();
        this.displayName = name;
        this.heroType = null;
        this.hitpoints = hitpoints;
        this.weapon = weapon;
        this.armor = armor;
        this.isInvulnerable = false;
        this.treasureChest = treasureChest;
    }
    attack(playerCharacter){
        if(!playerCharacter.isInvulnerable)
            playerCharacter.hitpoints -= this.weapon.attackPower;
    }

    attack(playerCharacter, modifier){
        if(!playerCharacter.isInvulnerable)
            playerCharacter.hitpoints -= (this.weapon.attackPower * 100);
    }
    debugPrintEnemyStats(){
        console.log("Enemy name is: " + this.name + "\tEnemy HP is: " + this.hitpoints + "\tEnemy weapon is: " + this.weapon.name + 
        "\tEnemy armor is: " + this.armor.name); 
    }
}