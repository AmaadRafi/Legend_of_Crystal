/* Jason Allen 9/15/2019 5:14 PM.

This script defines a CacheHandler class that is used to save
and retrieve information from browser localStorage
*/ 

class CacheHandler {

    constructor(){

    }

    static getFromCache(itemName){

        switch (itemName) {
            case "warrior":
                return HeroWarrior.createFromCache(window.localStorage.getItem('warrior'));
            case "mage":
                return HeroMage.createFromCache(window.localStorage.getItem('mage'));
            case "ranger":
                return HeroRanger.createFromCache(window.localStorage.getItem('ranger'));
            case "inventory":
                return Inventory.createFromCache(window.localStorage.getItem('inventory'));
            default:
        }
    }
    static addToCache(warrior, mage, ranger, inventory){
        window.localStorage.setItem('warrior', JSON.stringify(warrior));
        window.localStorage.setItem('mage', JSON.stringify(mage));
        window.localStorage.setItem('ranger', JSON.stringify(ranger));
        window.localStorage.setItem('inventory', JSON.stringify(inventory));
    }
}