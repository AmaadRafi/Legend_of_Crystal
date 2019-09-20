/* Jason Allen 9/15/2019 5:14 PM.

This script handles initial character creation
and upload to the cache
*/ 

function createParty(warriorName, mageName, rangerName){
   
    var inventory = new Inventory();
 
    if(warriorName == null || mageName == null || rangerName == null)
       alert("hero names cannot be null, please try again");
    else{
       var warrior = new HeroWarrior(warriorName);
       var mage = new HeroMage(mageName);
       var ranger = new HeroRanger(rangerName);
 
       CacheHandler.addToCache(warrior, mage, ranger, inventory);
 
       window.location.href = "GameWorld.html";
    }
 }