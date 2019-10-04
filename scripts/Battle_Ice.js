var warriorObject = CacheHandler.getFromCache("warrior");
var mageObject = CacheHandler.getFromCache("mage");
var rangerObject = CacheHandler.getFromCache("ranger");
var inventoryObject = CacheHandler.getFromCache("inventory");

var party = new Party(warriorObject, mageObject, rangerObject, inventoryObject);

<<<<<<< HEAD
var staff = new Weapon("Ice Staff", "ice", "close", 100, false, "images/weapons/Ice_Staff.png");
var armor = new Armor("Ice Armor", "ice", "heavy", 100, false, "images/weapons/Heavy_Sword.png");
var iceStone = new Item("Ice Stone", "consumable", false, "images/crystals/White_Crystal.jpg");
=======
var staff = new Weapon("Snowman", "ice", "close", 100, false, "images/weapons/Ice_Staff.png");
var armor = new Armor("Snowman Armor", "fire", "heavy", 100, false, "images/weaponsShield.png");
var iceStone = new Item("Ice Stone", "consumable", false, "images/crystals/Blue_Crystal.jpg");
>>>>>>> da9bac0a2a110f4ce03c9632dfe52fbb3edd1330
var potion = new Item("Potion", "consumable", true, "images/items/Blue_Potion.png");
potion.setConsumeMessage("You used a " + potion.displayName);
var iceEnemy = new Enemy("ISSVERN", 2000, staff , armor, [staff, potion, iceStone]);

var currentEnemy = null;
var currentParty = null;
var partyIsAlive = true;
var bossIsAlive = true;
var defend = false;

function battleIce(){

    if(!partyIsAlive){
        return;
    }
    if(!bossIsAlive){
        return;
    }
    
    party = new BattleParty(warriorObject, mageObject, rangerObject, inventoryObject, iceEnemy);
    currentParty = party;
    currentEnemy = iceEnemy;

    var taskCompleted = false;
    var cm = document.querySelector('.CodeMirror').CodeMirror;

    party.warrior.debugPrintHeroStats();
    iceEnemy.debugPrintEnemyStats();

    for(var turn = 1; turn <= 10; turn++) {
        if((party.warrior.hitpoints + party.ranger.hitpoints + party.mage.hitpoints) <= 0){
            partyIsAlive = false; 
            lose();
            
        }

        console.log("Turn = " + (turn));
        
<<<<<<< HEAD
        eval(cm.getValue());

        if(turn%2 == 0) { // even turns = boss turns
            if((turn == 8)) {
                if(!defend){
                    iceEnemy.attack(party.mage, 100);
                    iceEnemy.attack(party.warrior, 100);
                    iceEnemy.attack(party.ranger, 100);
                    console.log("ISSBERN used Hail.")
                    console.log("You have been frozen for eternity.\n");

                    break;
                } else {
                    console.log("ISSVERN used Hail.")
                    console.log("You blocked it!");
                    taskCompleted = true;
                }
            } else {
                if(turn < 8)
                console.log("The dragon seems to be charging an attack.");
            }
        }

        party.resetStates();
    } 
               
        if(iceEnemy.hitpoints <= 0) {
            taskCompleted = true;
        }

        if(party.hitpoints <= 0){
            partyIsAlive = false;
            //lose();
        }

    if(iceEnemy.hitpoints <= 0 && taskCompleted == true)
        win();
    else
        lose();
}

function blockIceAttack(){
    defend = true;
}

function partyAttack() {
    party.attack("ISSVERN", "mage");
    party.attack("ISSVERN", "warrior");
    party.attack("ISSVERN", "ranger");
}

function enemyAttack() {
    iceEnemy.attack(party.mage);
    iceEnemy.attack(party.warrior);
    iceEnemy.attack(party.ranger);
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