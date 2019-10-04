var warriorObject = CacheHandler.getFromCache("warrior");
var mageObject = CacheHandler.getFromCache("mage");
var rangerObject = CacheHandler.getFromCache("ranger");
var inventoryObject = CacheHandler.getFromCache("inventory");
var party = new Party(warriorObject, mageObject, rangerObject, inventoryObject.inventory);

function goToEarth(){

    moveChar('up');
    window.setTimeout(stop, 600);
    window.setTimeout(moveRight, 700);
    window.setTimeout(stop, 2850);
    window.setTimeout(moveDown, 3200);
    window.setTimeout(stop, 3900);
    window.setTimeout(moveRight, 4200);
    window.setTimeout(stop, 6000);
    window.setTimeout(moveUp, 6500);
    window.setTimeout(stop, 8000);
}
function goToIce()
{
    moveChar('up');
    window.setTimeout(stop, 2500);
    window.setTimeout(moveLeft, 2800);
    window.setTimeout(stop, 4800);
    window.setTimeout(moveUp, 5200);
    window.setTimeout(stop, 5500);
    window.setTimeout(moveLeft, 5800);
    window.setTimeout(stop, 9200);
    window.setTimeout(moveUp, 9500);
    window.setTimeout(stop, 10500);
}
function goToFire()
{
    moveChar('up');
    window.setTimeout(stop, 2800);
    window.setTimeout(moveRight, 3200);
    window.setTimeout(stop, 6300);
    window.setTimeout(moveUp, 6600);
    window.setTimeout(stop, 7100);
    window.setTimeout(moveRight, 7400);
    window.setTimeout(stop, 9000);
    window.setTimeout(moveUp, 9300);
    window.setTimeout(stop, 9700);
    window.setTimeout(moveRight, 10000);
    window.setTimeout(stop, 10800);
    window.setTimeout(moveUp, 11000);
    window.setTimeout(stop, 11800);
}
function moveUp(){
    
    moveChar('up');
}
function moveRight(){
    moveChar('right');
}
function moveLeft(){
    moveChar('left');
}
function moveDown(){
    moveChar('down');
}
function collidesWith (element1, element2) {
    var Element1 = {};
    var Element2 = {};

    Element1.top = $(element1).offset().top;
    Element1.left = $(element1).offset().left;
    Element1.right = Number($(element1).offset().left) + Number($(element1).width());
    Element1.bottom = Number($(element1).offset().top) + Number($(element1).height());

    Element2.top = $(element2).offset().top;
    Element2.left = $(element2).offset().left;
    Element2.right = Number($(element2).offset().left) + Number($(element2).width());
    Element2.bottom = Number($(element2).offset().top) + Number($(element2).height());

    if (Element1.right > Element2.left && Element1.left < Element2.right && Element1.top < Element2.bottom && Element1.bottom > Element2.top) {
       if(element2 == "#earthStage"){
           window.location.href = "Transition_Earth.html";
       }
       if(element2 == "#iceStage"){
            window.location.href = "Transition_Ice.html";
       }
       if(element2 == "#fireStage"){
            window.location.href = "Transition_Fire.html";
       }
       
    }
}
window.setInterval(function(){
    collidesWith('#character', '#iceStage');
    collidesWith('#character', '#fireStage');
    collidesWith('#character', '#earthStage');
  }, 1);

  var currentKey;          //records the current key pressed
  var TimerWalk;          //timer handle
  var charStep = 1;       //1=1st foot, 2=stand, 3=2nd foot, 4=stand
  var charSpeed = 400;
  
  $(document).ready(function() {
   
      //add character state class
      $('#character').addClass('front-stand');
   
    });
  
    $(document).keydown(function(e) {
      if (!currentKey && $('#character').queue("fx").length == 0) {
        currentKey = e.keyCode;
        switch(e.keyCode) {
          case 38: moveChar('up');    break;
          case 39: moveChar('right'); break;
          case 40: moveChar('down');  break;
          case 37: moveChar('left');  break;
        }
      }
    });
   
    //KeyUp Function
    $(document).keyup(function(e) {
   
      //don't stop the walk if the player is pushing other buttons
      //only stop the walk if the key that started the walk is released
      if (e.keyCode == currentKey) {
   
        //set the currentKey to false, this will enable a new key to be pressed
        currentKey = false;
   
        //clear the walk timer
        clearInterval(TimerWalk);
   
        //finish the character's movement
        $('#character').stop(false, false);
   
      }
   
    });

    function stop(){
        $('#character').stop(false, false);
    }
  
    function moveChar(dir) {
   
      //a player could switch key mid-animation
      //record the key that was down when animation started
      var currentKeyCheck = currentKey;
     
      //adjust from lang to code
      if (dir == 'up') dir = 'back';
      if (dir == 'down') dir = 'front';
     
      charStep++;
      if (charStep == 5) charStep = 1;
     
      //remove the current class
      $('#character').removeAttr('class');
     
      //add the new class
      switch(charStep) {
        case 1: 
          $('#character').addClass(dir+'-stand'); 
          setTimeout(function() { 
            charStep++;
            if (charStep == 5) charStep = 1;
            $('#character').removeAttr('class');
            $('#character').addClass(dir+'-right'); 
          }, (charSpeed/3));
          setTimeout(function() { 
            charStep++;
            if (charStep == 5) charStep = 1;
            $('#character').removeAttr('class');
            $('#character').addClass(dir+'-stand'); 
          }, ((charSpeed/3)*2));
        break;
        case 2: 
          $('#character').addClass(dir+'-right');
          setTimeout(function() { 
            charStep++;
            if (charStep == 5) charStep = 1;
            $('#character').removeAttr('class');
            $('#character').addClass(dir+'-stand'); 
          }, (charSpeed/3));
          setTimeout(function() { 
            charStep++;
            if (charStep == 5) charStep = 1;
            $('#character').removeAttr('class');
            $('#character').addClass(dir+'-left'); 
          }, ((charSpeed/3)*2));
        break;
        case 3: 
          $('#character').addClass(dir+'-stand');
          setTimeout(function() { 
            charStep++;
            if (charStep == 5) charStep = 1;
            $('#character').removeAttr('class');
            $('#character').addClass(dir+'-left'); 
          }, (charSpeed/3));
          setTimeout(function() { 
            charStep++;
            if (charStep == 5) charStep = 1;
            $('#character').removeAttr('class');
            $('#character').addClass(dir+'-stand'); 
          }, ((charSpeed/3)*2)); 
        break;
        case 4: 
          $('#character').addClass(dir+'-left');
          setTimeout(function() { 
            charStep++;
            if (charStep == 5) charStep = 1;
            $('#character').removeAttr('class');
            $('#character').addClass(dir+'-stand'); 
          }, (charSpeed/3));
          setTimeout(function() { 
            charStep++;
            if (charStep == 5) charStep = 1;
            $('#character').removeAttr('class');
            $('#character').addClass(dir+'-right'); 
          }, ((charSpeed/3)*2));
        break;
      }
      //move the char
      switch(dir) {
        case'front':
          $('#character').animate({top: '+=32'}, charSpeed, "linear", function() {
            if (currentKey == currentKeyCheck) moveChar(dir);
          });
        break;
        case'back':
          if ($('#character').position().top > 0) {
            $('#character').animate({top: '-=32'}, charSpeed, "linear", function() {
              if (currentKey == currentKeyCheck) moveChar(dir);
            });
          }
        break;
        case'left':
          if ($('#character').position().left > 0) {
            $('#character').animate({left: '-=32'}, charSpeed, "linear", function() {
              if (currentKey == currentKeyCheck) moveChar(dir);
            });
          }
        break;
        case'right':
          $('#character').animate({left: '+=32'}, charSpeed, "linear", function() {
            if (currentKey == currentKeyCheck) moveChar(dir);
          });
        break;
      }
     
      }