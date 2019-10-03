var warriorObject = CacheHandler.getFromCache("warrior");
var mageObject = CacheHandler.getFromCache("mage");
var rangerObject = CacheHandler.getFromCache("ranger");
var inventoryObject = CacheHandler.getFromCache("inventory");

var party = new Party(warriorObject, mageObject, rangerObject, inventoryObject);

var fire = new Weapon("Flame Staff", "fire", "close", 100, false, "images/weapons/Flame_Staff.png");
var armor = new Armor("Dragon Shield", "fire", "heavy", 100, false, "images/weapons/Shield.png");
var fireStone = new Item("fire Stone", "consumable", false, "images/crystals/Red_Crystal.jpg");
var potion = new Item("Potion", "consumable", true, "images/items/Red_Potion.png");
potion.setConsumeMessage("You used a " + potion.displayName);
var fireEnemy = new Enemy("dragon", 300, fire , armor, [fire, potion, fireStone]);

var currentEnemy = null;
var currentParty = null;
var partyIsAlive = true;
var bossIsAlive = true;

function battleFire(){

    if(!partyIsAlive){
        return;
    }
    if(!bossIsAlive){
        return;
    }
    
    party = new BattleParty(warriorObject, mageObject, rangerObject, inventoryObject, fireEnemy);
    currentParty = party;
    currentEnemy = fireEnemy;

    var taskCompleted = false;
      
    var cm = document.querySelector('.CodeMirror').CodeMirror;
    eval(cm.getValue()); // eval() pastes code from the user into this spot.

    party.warrior.debugPrintHeroStats();
    fireEnemy.debugPrintEnemyStats();
    
    try {
        
        if(fire_pit <= 4)
            for(var i = 0; i < fire_pit; i++){
                
                console.log("destroyed Fire pit " + (i + 1));
            }
        if(fire_pit == 4){
            taskCompleted = true;
        }
        else if(fire_pit > 4){
            console.log("There are only 4 fire pits!");
        }
        else{
            console.log("You did not destroy all the fire pits!  " + fireEnemy.name + " attacks!");
        }
    } catch (error) {
        alert("you did not define the var fire_pits!  Try again.");
    }

    party.resetStates();

    if(fireEnemy.hitpoints <= 0 && taskCompleted == true)
        win();
    else
        lose();
}
function win(){

    bossIsAlive = false;

    var popup = document.getElementById("popup");

    popup.innerHTML += "<h1 class='modalWin'>" + currentEnemy.displayName + " was defeated! </h1>";
    popup.innerHTML += "<h3 class='modalSubtext'>The following items were dropped: <h3>";
    drawTreasureBoxes(popup);

    currentParty.takeTreasure();
    CacheHandler.addToCache(currentParty.warrior, currentParty.mage, currentParty.ranger, currentParty.inventory);
    playOutcomeSound("sounds/Victory.mp3");
    showOverlay();
}
function lose(){

    partyIsAlive = false;

    var popup = document.getElementById("popup");
    
    popup.innerHTML += "<h1 class='modalLose'>GAME OVER</h1>";
    playOutcomeSound("sounds/Defeat.mp3");
    showOverlay();
}
function drawTreasureBoxes(popup){
    
    var treasureBoxClass;
    var firstImagePosition = 40;
    var offset = 30;

    if(currentEnemy.treasureChest.length > 3){
        treasureBoxClass = "treasureBoxSmall";
        offset = 15;
    }
    else
        treasureBoxClass = "treasureBox";

    for(var i = 0; i < currentEnemy.treasureChest.length; i++){
        
        if(i > 0){
            if(i % 2 != 0)
                firstImagePosition += offset * i;
            else
                firstImagePosition -= offset * i;
        }
        popup.innerHTML += "<div class="+treasureBoxClass+" style='left: "+firstImagePosition+"%;'>"
        +"<img class='inventoryImage' src="+currentEnemy.treasureChest[i].imageSource+"></div>";
    }
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
        window.location.reload();
    }
}
function viewLog(){
    $('.overlay').hide();
    var buttonContainer = document.getElementById("buttonContainer");
    buttonContainer.innerHTML = '<button class="centered" onclick="stateChange()">Continue</button>';
}
function playVictorySound(){
    document.getElementById("MusicPlayer").outerHTML = "";
    var musicPlayer = new MusicPlayer("sounds/Victory.mp3"); 
    musicPlayer.play();
}
function playOutcomeSound(outcomeSound){
    document.getElementById("MusicPlayer").outerHTML = "";
    var musicPlayer = new MusicPlayer(outcomeSound); 
    musicPlayer.play();
}