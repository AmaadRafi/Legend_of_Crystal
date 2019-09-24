/* Jason Allen 9/19/2019 2:14 AM.

Script for playing music/sounds 
within the game.  Attached via
script tags in the HTML files.

NOTE: Chrome does not allow autoplay,
which is the reason for the onmousedown()
function rather than onload().
*/

function MusicPlayer(src) {
    this.sound = document.createElement("audio");
    this.sound.src = src;
    this.sound.setAttribute("preload", "auto");
    this.sound.setAttribute("controls", "none");
    this.sound.setAttribute("id", "MusicPlayer");
    this.sound.style.display = "none";
    document.body.appendChild(this.sound);
    this.play = function(){
      this.sound.play();
    }
    this.stop = function(){
      this.sound.pause();
    }
}