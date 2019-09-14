var inventorySize = 40;

var inventory = new Inventory();

var team = createTeam("Jay", "Amaad", "Shabir");
window.localStorage.setItem('warrior', JSON.stringify(team[0]));
window.localStorage.setItem('mage', JSON.stringify(team[1]));
window.localStorage.setItem('ranger', JSON.stringify(team[2]));
window.localStorage.setItem('Inventory', JSON.stringify(inventory));

function createTeam(warriorName, mageName, rangerName){

    var warrior = new HeroWarrior(warriorName);
    var mage = new HeroMage(mageName);
    var ranger = new HeroRanger(rangerName);
    
    var team = [warrior, mage, ranger];

    return team;
}