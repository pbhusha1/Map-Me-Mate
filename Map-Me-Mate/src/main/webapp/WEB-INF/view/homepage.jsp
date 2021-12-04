<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="wed, 01 Dec 2021 00:00:00 GMT">
<title>Map-Me-Mate</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Map-Me-Mate</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>
					<li><a href="/logout" style="float:right">Logout</a>
				</ul>
			</div>
		</div>
	</div>
	<div class="container" id="homediv">
	<c:choose>
		<c:when test="${mode=='MODE_SEARCH' }">
			<div class="jumbotron text-center">
				<h2>Hello ${firstname}, Welcome to <i>Map-Me-Mate</i></h2>
				<h5>Select university and find your flatmates</h5>
				<br>
				<form method="GET" action="/searchapartments">
  					<label for="cars">Select University: </label>
			  			<select name="uname" id="uname">
			    			<option value="select">Select University</option>
			    			<option value="Arizona State University Tempe">Arizona State University Tempe</option>
			    			<option value="George Mason University">George Mason University</option>
			    			<option value="Harvard University">Harvard University</option>
			    			<option value="University of Missouri Kansas City">University of Missouri Kansas City</option>
			    			<option value="Purdue University">Purdue University</option>
			    			<option value="Stanford University">Stanford University</option>
			    			<option value="Stony Brook University">Stony Brook University</option>
			    			<option value="SUNY Buffalo State College">SUNY Buffalo State College</option>
			    			<option value="University of Illinois at Urbana-Champaign">University of Illinois at Urbana-Champaign</option>
			    			<option value="University Of Cincinnati">University Of Cincinnati</option>
			    			<option value="Universsity Of South Florida">Universsity Of South Florida</option>
			    			<option value="University of Southern California">University of Southern California</option>
			  			</select>
  						<br><br>
  					<input class="btn btn-primary btn-sm" type="submit" value="Search">
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_APT_DETAILS' }">
			<div class="jumbotron text-center">
			<a href="/search">Go Back</a>
				<h2 class="text-left" >${apartment.name}</h2>
				<div class="text-left">
				<i>Address: ${apartment.address}</i><br>
				<i>Contact: ${apartment.contact}</i><br>
				<i>Rent: ${apartment.rentRange}</i><br>
				<i>Rating: ${apartment.rating}</i><br>
				<i>Website: <a href="${apartment.apartmentURL}" target="_blank">${apartment.apartmentURL}</a></i><br>
				<i>Location: <a href="${apartment.directionURL}" target="_blank">${apartment.directionURL}</a></i><br>
				<i>Description: ${apartment.description}</i><br>
				</div><br>
				<img src="${apartment.imageURL}" hight="40%" width="40%" alt="no image">
				<br>
			</div>
			<br>
			<div class="jumbotron text-center">
			<button class="btn btn-primary" id="tempaccomdation">VIEW TEMPORARY ACCOMDATION</button>
			<br><br>
			<div id="output1"></div>
			</div>
			<br>
			<div class="jumbotron text-center">
			<h4><u>VIEW NEARBY AMENITIES</u></h4>
			<br><br>
			<div class="text-center">
			<button class="btn btn-primary" id="banks">VIEW BANKS</button>
			</div>
			<br>
			<div id="output_1"></div>
			<br>
			<div class="text-center">
			<button class="btn btn-primary" id="atms">VIEW ATMS</button>
			</div>
			<br>
			<div id="output_2"></div>
			<br>
			<div class="text-center">
			<button class="btn btn-primary" id="buses">VIEW BUS STOPS</button>
			</div>
			<br>
			<div id="output_3"></div>
			<br>
			<div class="text-center">
			<button class="btn btn-primary" id="hospitals">VIEW HOSPITALS</button>
			</div>
			<br>
			<div id="output_4"></div>
			<br>
			<div class="text-center">
			<button class="btn btn-primary" id="foods">VIEW FOOD OUTLETS</button>
			</div>
			<br>
			<div id="output_5"></div>
			<br>
			<div class="text-center">
			<button class="btn btn-primary" id="stores">VIEW GROCERY STORES</button>
			</div>
			<br>
			<div id="output_6"></div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_RESULTS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Search Results</h3>
				<a href="/search">Go Back</a>
				<hr>
				<i class="text-danger">${queryMsg}</i>&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
			  Filters
			</button>
				<hr>
  				<table class="center">
  				<tr>
  				<td>
  				<div class="list-group">
  				<c:forEach items="${apartments1}" var="apartment">
					  <a href="http://localhost:8080/apartmentdetails?apt_name=${apartment.name}" class="list-group-item list-group-item-action">${apartment.name}</a>
				</c:forEach>
				</div>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
  				<td>
  				<div class="list-group">
				<c:forEach items="${apartments2}" var="apartment">
					  <a href="http://localhost:8080/apartmentdetails?apt_name=${apartment.name}" class="list-group-item list-group-item-action">${apartment.name}</a>
				</c:forEach>
				</div>
				</td>
  				<tr>
  				</table>
			</div>
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Rent & Rating</h5>
			      </div>
			      <div class="modal-body">
			      <form method="GET" action="/searchapartments_filters" id="filterform">
			      <i>Enter minium and maximum rents below </i>
					<input type="text" name="min_rent" class="form-control" placeholder="Enter Min Rent"><br>
					<input type="text" name="max_rent" class="form-control" placeholder="Enter Max Rent"><br>
					<i>Select rating on a scale of 1 to 5 </i>
					<select class="form-control" id="rating" name="rating"><br>
      					<option>1</option>
					    <option>2</option>
					    <option>3</option>
					    <option>4</option>
					    <option>5</option>
					</select>
					<input type="hidden" name="hideuname" value="${uname}"></input>
				   </form>
			      </div>
			      <div class="modal-footer">
			      <b><i class="text-danger">Please enter the details before apply&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i></b>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary" onclick="doFormSubmit(this);">Apply</button>
			      </div>
			    </div>
			  </div>
			</div>
		</c:when>
	</c:choose>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	function doFormSubmit(){
	document.getElementById("filterform").submit();
	}
	$("#tempaccomdation").click(function (){
         $.ajax({
                type: "GET",
                url: "temp_accomdation_details?apt_name=${apartment.name}",
                success: function(response){ 
                var HTML = "";
                for(var i=0; i<response.length; i++){
                HTML += "<div class='list-group'>";
                HTML += "<a class='list-group-item active'>Temporary Accomdation - "+(i+1)+" </a>";
                HTML += "<a class='list-group-item'>Provider Name: "+response[i].personName+"</a>";
                HTML += "<a class='list-group-item'>Gender: "+response[i].gender+"</a>";
                HTML += "<a class='list-group-item'>Nationality: "+response[i].nationality+"</a>";
                HTML += "<a class='list-group-item'>Course Name: "+response[i].courseName+"</a>";
                HTML += "<a class='list-group-item'>Semester: "+response[i].semester+"</a>";
                HTML += "<a class='list-group-item'>Rent Per Day: "+response[i].rentPerDay+"</a>";
                HTML += "<a class='list-group-item'>Rent Per Week: "+response[i].rentPerWeek+"</a>";
                HTML += "<a class='list-group-item'>Rent Per Month: "+response[i].rentPerMonth+"</a>";
                HTML += "<a class='list-group-item'>Will Negotiate: "+response[i].willNegotiate+"</a>";
                HTML += "</div><br>";
                }
                document.getElementById("output1").innerHTML=HTML;   
                }
            });
         });
    $('#banks').click(function (){
         $.ajax({
		        type: "GET",
		        url: "show_amenities_details?apt_name=${apartment.name}&type=banks",
		        success: function(response){
		        var HTML = "";
		        for(var i=0; i<response.length; i++){
                HTML += "<div class='list-group'>";
                HTML += "<a class='list-group-item active'>BANK - "+(i+1)+" </a>";
                HTML += "<a class='list-group-item'>Bank Name: "+response[i].amenityName+"</a>";
                HTML += "<a class='list-group-item'>Distance: "+response[i].amenityDistance+"</a>";
                HTML += "</div><br>";
                }
		        document.getElementById("output_1").innerHTML=HTML;
		        }
            });
         });
    $('#atms').click(function (){
         $.ajax({
		        type: "GET",
		        url: "show_amenities_details?apt_name=${apartment.name}&type=atms",
		        success: function(response){
		        var HTML = "";
		        for(var i=0; i<response.length; i++){
                HTML += "<div class='list-group'>";
                HTML += "<a class='list-group-item active'>ATM - "+(i+1)+" </a>";
                HTML += "<a class='list-group-item'>ATM Name: "+response[i].amenityName+"</a>";
                HTML += "<a class='list-group-item'>Distance: "+response[i].amenityDistance+"</a>";
                HTML += "</div><br>";
                }
		        document.getElementById("output_2").innerHTML=HTML;
		        }
            });
         });
    $('#buses').click(function (){
         $.ajax({
		        type: "GET",
		        url: "show_amenities_details?apt_name=${apartment.name}&type=buses",
		        success: function(response){
		        console.log(response);
		        var HTML = "";
		        for(var i=0; i<response.length; i++){
                HTML += "<div class='list-group'>";
                HTML += "<a class='list-group-item active'>Bus Stop - "+(i+1)+" </a>";
                HTML += "<a class='list-group-item'>Stop Name: "+response[i].amenityName+"</a>";
                HTML += "<a class='list-group-item'>Distance: "+response[i].amenityDistance+"</a>";
                HTML += "</div><br>";
                }
		        document.getElementById("output_3").innerHTML=HTML;
		        }
            });
         });
     $('#foods').click(function (){
         $.ajax({
		        type: "GET",
		        url: "show_amenities_details?apt_name=${apartment.name}&type=foods",
		        success: function(response){
		        var HTML = "";
		        for(var i=0; i<response.length; i++){
                HTML += "<div class='list-group'>";
                HTML += "<a class='list-group-item active'>Food Outlet - "+(i+1)+" </a>";
                HTML += "<a class='list-group-item'>Food Outlet Name: "+response[i].amenityName+"</a>";
                HTML += "<a class='list-group-item'>Distance: "+response[i].amenityDistance+"</a>";
                HTML += "</div><br>";
                }
		        document.getElementById("output_5").innerHTML=HTML;
		        }
            });
         });
     $('#hospitals').click(function (){
         $.ajax({
		        type: "GET",
		        url: "show_amenities_details?apt_name=${apartment.name}&type=hospitals",
		        success: function(response){
		        var HTML = "";
		        for(var i=0; i<response.length; i++){
                HTML += "<div class='list-group'>";
                HTML += "<a class='list-group-item active'>Hospital - "+(i+1)+" </a>";
                HTML += "<a class='list-group-item'>Hospital Name: "+response[i].amenityName+"</a>";
                HTML += "<a class='list-group-item'>Distance: "+response[i].amenityDistance+"</a>";
                HTML += "</div><br>";
                }
		        document.getElementById("output_4").innerHTML=HTML;
		        }
            });
         });
     $('#stores').click(function (){
         $.ajax({
		        type: "GET",
		        url: "show_amenities_details?apt_name=${apartment.name}&type=stores",
		        success: function(response){
		        console.log(response)
		        var HTML = "";
		        for(var i=0; i<response.length; i++){
                HTML += "<div class='list-group'>";
                HTML += "<a class='list-group-item active'>Grocery Store - "+(i+1)+" </a>";
                HTML += "<a class='list-group-item'>Store Name: "+response[i].amenityName+"</a>";
                HTML += "<a class='list-group-item'>Distance: "+response[i].amenityDistance+"</a>";
                HTML += "</div><br>";
                }
		        document.getElementById("output_6").innerHTML=HTML;
		        }
            });
         });
</script>
	</body>
</html>