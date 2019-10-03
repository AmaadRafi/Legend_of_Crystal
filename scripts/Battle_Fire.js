var warriorObject = CacheHandler.getFromCache("warrior");
var mageObject = CacheHandler.getFromCache("mage");
var rangerObject = CacheHandler.getFromCache("ranger");
var inventoryObject = CacheHandler.getFromCache("inventory");

var party = new Party(warriorObject, mageObject, rangerObject, inventoryObject);

var fireStaff = new Weapon("Flame Staff", "fire", "magic", 100, false, "images/weapons/Flame_Staff.png");
var armor = new Armor("Fire Armor", "fire", "heavy", 100, false, "images/armor/Fire_Armor.png");
var fireStone = new Item("Fire Stone", "consumable", false, "images/crystals/Red_Crystal.jpg");
var potion = new Item("Potion", "consumable", true, "images/items/Red_Potion.png");
potion.setConsumeMessage("You used a " + potion.displayName);
var fireEnemy = new Enemy("Dragon", 300, fireStaff, armor, [fireStaff, armor, potion, fireStone]);

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
    party.warrior.debugPrintHeroStats();
    party.mage.debugPrintHeroStats();
    party.ranger.debugPrintHeroStats();
    fireEnemy.debugPrintEnemyStats();

    for(var i = 0; i < 10; i++){

        eval(cm.getValue());
        party.resetStates();

        taskCompleted = true;
    }
    //eval(cm.getValue()); // eval() pastes code from the user into this spots

    if(taskCompleted == true)
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