$(document).ready(function(){

	
	$.get("/Booksystem_V0/showfriend/friendslist",function(data,status){
		let html ="<li class=\"active\"><a href=\"#\">好友列表<span class=\"sr-only\">(current)</span></a></li>"
		for(let i=0;i<data.length;i++){
			html += '<li><a href=\"#\">'+data[i].friendName+'</a></li>'
		}
		$("#friendslist").html(html)
		console.log(data)
		console.log("")
		console.log("require friendslist:"+status)
		
	})
	
	console.log("friendlist.js")
//	$("#friendslist").html("<li><a href="#">"+html+"</a></li>")
})