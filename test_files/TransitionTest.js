var warriorObject = CacheHandler.getFromCache("warrior");
var mageObject = CacheHandler.getFromCache("mage");
var rangerObject = CacheHandler.getFromCache("ranger");
var inventoryObject = CacheHandler.getFromCache("inventory");
var party = new Party(warriorObject, mageObject, rangerObject, inventoryObject.inventory);

function changeWeapon(heroName, weapon){

    party.changeWeapon(heroName, weapon);
    CacheHandler.addToCache(warriorObject, mageObject, rangerObject, inventoryObject);
}