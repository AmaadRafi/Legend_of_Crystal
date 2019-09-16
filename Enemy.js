/* Tobias Boyd 9/16/19 8:29 AM
This script defines classes for enemy characters that will be found in the game.
Note that toUpperCase() is used when comparing objects to prevent
user typing errors

*/

var hitpoints = 50;
var attack = 10;
var defense = 10;

class Enemy {
    constructor(name){
        this.name = name;
        this.hitpoints = hitpoints;
        this.attack = attack;
        this.defense = defense;
    }
}