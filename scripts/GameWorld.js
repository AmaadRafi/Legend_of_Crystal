var warriorObject = CacheHandler.getFromCache("warrior");
var mageObject = CacheHandler.getFromCache("mage");
var rangerObject = CacheHandler.getFromCache("ranger");
var inventoryObject = CacheHandler.getFromCache("inventory");
var party = new Party(warriorObject, mageObject, rangerObject, inventoryObject.inventory);

function goToEarth(){

    window.location.href = "Transition_Earth.html";
}

function goToIce()
{
    window.location.href = "Transition_Ice.html";
}

function goToFire()
{
    window.location.href = "Transition_Fire.html";
}