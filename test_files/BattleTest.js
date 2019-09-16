/* Jason Allen 9/15/2019 5:14 PM.

Script for testing battle sequences
with code injection from the user  
*/ 

// get objects from cache
var warriorObject = CacheHandler.getFromCache("warrior");
var mageObject = CacheHandler.getFromCache("mage");
var rangerObject = CacheHandler.getFromCache("ranger");
var inventoryObject = CacheHandler.getFromCache("inventory");

var party = new BattleParty(warriorObject, mageObject, rangerObject);

var sword = new Weapon("Ogre Sword", "fire", "close", 10, false);
var armor = new Armor("Ogre Armor", "fire", "heavy", 10, false);
var ogre = new Enemy("ogre", 1000, sword, armor);


function battle(){

    party.warrior.debugPrintHeroStats();
    ogre.debugPrintEnemyStats();
    
    for(var turn = 1; turn <= 10; turn++){
        
        console.log("current turn: " + turn);

        var cm = document.querySelector('.CodeMirror').CodeMirror;
        eval(cm.getValue()); // eval() pastes code from the user into this spot.
        ogre.attack(party.warrior);

        party.warrior.debugPrintHeroStats();
        ogre.debugPrintEnemyStats();
        party.resetStates();
    }
}