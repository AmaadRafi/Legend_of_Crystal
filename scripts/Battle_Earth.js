var warriorObject = CacheHandler.getFromCache("warrior");
var mageObject = CacheHandler.getFromCache("mage");
var rangerObject = CacheHandler.getFromCache("ranger");
var inventoryObject = CacheHandler.getFromCache("inventory");

var sword = new Weapon("Ogre Sword", "fire", "close", 100, false);
var armor = new Armor("Ogre Armor", "fire", "heavy", 100, false);
var earthEnemy = new Enemy("ogre", 300, sword, armor);

var partyIsAlive = true;
var bossIsAlive = true;

function battleEarth(){

    if(!partyIsAlive){
        return;
    }
    if(!bossIsAlive){
        return;
    }

    var party = new BattleParty(warriorObject, mageObject, rangerObject, inventoryObject, earthEnemy);
    party.warrior.debugPrintHeroStats();
    earthEnemy.debugPrintEnemyStats();

    var taskCompleted = false;
      
    var cm = document.querySelector('.CodeMirror').CodeMirror;
    eval(cm.getValue()); // eval() pastes code from the user into this spot.
    
    try {
        
        if(pillars <= 5)
            for(var i = 0; i < pillars; i++){
                
                console.log("Destroyed pillar " + (i + 1));
            }
        if(pillars == 5){
            taskCompleted = true;
        }
        else if(pillars > 5){
            console.log("You destroyed too many pillars!  The cave starts to collapse!");
        }
        else{
            console.log("You did not destroy all of the pillars!  " + earthEnemy.name + " attacks!");
        }
    } catch (error) {
        alert("you did not define the var pillars!  Try again.");
    }

    party.resetStates();

    if(earthEnemy.hitpoints <= 0 && taskCompleted == true)
        win();
    else
        lose();
}
function win(){

    bossIsAlive = false;

    CacheHandler.addToCache(warriorObject, mageObject, rangerObject, inventoryObject);
    showOverlay();
}
function lose(){

    partyIsAlive = false;

    var popup = document.getElementById("popup");
    var consoleOutput = document.getElementById("console");
    
    popup.innerHTML += "<h1>You Lose!</h1>";
    showOverlay();
}
function showOverlay(){
    
    var textBox = document.getElementById("codeBox");
    textBox.style.pointerEvents = "none";
    $('.overlay').show();
}
function stateChange(){

    if(partyIsAlive && !bossIsAlive){
        window.location.href = "GameWorld.html";
    }
    else{
        location.reload();
    }
}
function viewLog(){
    $('.overlay').hide();
    var buttonContainer = document.getElementById("buttonContainer");
    buttonContainer.innerHTML = '<button class="centered" onclick="stateChange()">Continue</button>';
}