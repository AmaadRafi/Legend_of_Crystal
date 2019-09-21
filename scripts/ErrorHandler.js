/* Jason Allen 9/21/19

Script for handling user input errors
*/

window.onerror = function (msg, url, lineNo, columnNo, error) {
    var string = msg.toLowerCase();
    var substring = "script error";
    if (string.indexOf(substring) > -1){
      alert('The code you entered is undefined, try again.');
    } else {
      var message = "There is an error in your code, please try again.";
 
      alert(message);
    }
  
    return false;
  };