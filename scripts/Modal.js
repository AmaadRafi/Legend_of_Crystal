/* Jason Allen 9/20/19

Script for dealing with modals
(popup on screen)
*/

$('.overlay').on('click', function(e) {
    if (e.target == this) {
        return;
    }
});