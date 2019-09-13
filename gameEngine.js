function createTeam(warriorName, mageName, rangerName){

    const warrior = new HeroWarrior("Jay");
    const mage = new HeroMage("Amaad");
    const ranger = new HeroRanger("Shabir");
    
    var team = [warrior, mage, ranger];

    return team;
}