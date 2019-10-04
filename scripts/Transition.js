/* Jason Allen 9/21/19 12:41 AM

makes use of the HTML5 'history' API
for dynamic loading of page content.
For this application it serves as a way
to have persistent music playback across
the Transition and Battle scenes.  

Battle scene content is loaded dynamically into
the Transition scenes without page refresh.  Data
used for loading is found in the /pages folder

NOTE: due to the addition of dynamic page loading, game must now
run in a web server to run properly due to Chrome restrictions
*/ 
$(document).ready(function() {
	
	function anchorClick(link, name) {
		
        var linkSplit = link.split('/').pop();
    
		$.get('pages/' + linkSplit, function(data) {
			$(name).html(data);
		});
	
	}
<<<<<<< HEAD
	$('#containerIce').on('click', 'a', function(e) {
=======
	// $('#container').on('click', 'a', function(e) {
		
	// 	window.history.pushState(null, null, $(this).attr('href'));
		
	// 	anchorClick($(this).attr('href'), "#background");
	// 	anchorClick("buttonContainer.html", "#buttonContainer");
	// 	anchorClick("gameRules.html", "#gameRules");
	// 	anchorClick("overlay.html", "#overlay");
		
	// 	e.preventDefault();

	// });
	
	$('#containerEarth').on('click', 'a', function(e) {
>>>>>>> da9bac0a2a110f4ce03c9632dfe52fbb3edd1330
		
		window.history.pushState(null, null, $(this).attr('href'));
		
		anchorClick($(this).attr('href'), "#background");
<<<<<<< HEAD
		anchorClick("buttonContainerIce.html", "#buttonContainer");
		anchorClick("gameRulesIce.html", "#gameRules");
		anchorClick("overlay.html", "#overlay");
		
		e.preventDefault();

	});
	$('#containerFire').on('click', 'a', function(e) {
		
		window.history.pushState(null, null, $(this).attr('href'));
		
		anchorClick($(this).attr('href'), "#background");
		anchorClick("buttonContainerFire.html", "#buttonContainer");
		anchorClick("gameRulesFire.html", "#gameRules");
=======
		anchorClick("buttons_Earth.html", "#buttonContainer");
		anchorClick("gameRulesEarth.html", "#gameRules");
>>>>>>> da9bac0a2a110f4ce03c9632dfe52fbb3edd1330
		anchorClick("overlay.html", "#overlay");
		
		e.preventDefault();

	});
<<<<<<< HEAD
	$('#containerEarth').on('click', 'a', function(e) {
=======

	$('#containerIce').on('click', 'a', function(e) {
>>>>>>> da9bac0a2a110f4ce03c9632dfe52fbb3edd1330
		
		window.history.pushState(null, null, $(this).attr('href'));
		
		anchorClick($(this).attr('href'), "#background");
<<<<<<< HEAD
		anchorClick("buttonContainerEarth.html", "#buttonContainer");
		anchorClick("gameRulesEarth.html", "#gameRules");
=======
		anchorClick("buttons_Ice.html", "#buttonContainer");
		anchorClick("gameRulesIce.html", "#gameRules");
>>>>>>> da9bac0a2a110f4ce03c9632dfe52fbb3edd1330
		anchorClick("overlay.html", "#overlay");
		
		e.preventDefault();

	});

	$('#containerFire').on('click', 'a', function(e) {
		
		window.history.pushState(null, null, $(this).attr('href'));
		
		anchorClick($(this).attr('href'), "#background");
		anchorClick("buttons_Fire.html", "#buttonContainer");
		anchorClick("gameRulesFire.html", "#gameRules");
		anchorClick("overlay.html", "#overlay");
		
		e.preventDefault();

	});

	window.addEventListener('popstate', function(e) {
		
		anchorClick(location.pathname);		
	
	});
});