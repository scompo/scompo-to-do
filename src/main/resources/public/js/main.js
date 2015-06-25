 $(window).load(function() {
	
	log.enableAll();
	
	$("#showListsButton").unbind();
	$("#showListsButton").bind("click", onClickShowList);
	
});

function onClickShowList() {
	
	self.location = "/userLists";
}