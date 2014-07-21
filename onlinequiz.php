<html>
<title>
Online quiz
</title>
<head>
	<center><h1>Online Quiz</h1></center>
</head>
<div>
    <form action="onlinequiz.php" method="post">
	<p> Fill in the blanks with the appropirate allusion from the options given</p>
	<p>
		Q1. Her uncle and cousins are reporters , and she, too, hopes to join the ....<br />
		<input type="checkbox" name="a" value="1a"/> a. juggernaut<br />  
		<input type="checkbox" name="b"value="1b"/> b. Armageddon<br /> 
		<input type="checkbox" name="c"/> c. Fourth estate<br /> 
		<input type="checkbox" name="d"/> d. Fifth coloum<br /> 
	</p>	
	<p>
		Q2. The freedom fighters knew they would be hanged if caught , but they nevertheless decided to : <br />
		<input type="checkbox" name="a2"/> a. carry coal to newcastle<br />  
		<input type="checkbox" name="b2"/> b. juggernaut<br /> 
		<input type="checkbox" name="c2" value="2c"/> c. hoist with one own petrad<br /> 
		<input type="checkbox" name="d2"/> d. cross the rubicon<br /> 
	</p>	
	<p>
		Q3. Best meaning of cower is :<br />
		<input type="checkbox" name="a3"/> a. invert<br />  
		<input type="checkbox" name="b3" value="3b"/> b. assuge<br /> 
		<input type="checkbox" name="c3"/> c. swiftly disappear<br /> 
		<input type="checkbox" name="d3"/> d. brazenly confront<br /> 
	</p>	
	<p>
		Q4. Turpitude  means :<br />
		<input type="checkbox" name="a4"/> a. aggitation<br />  
		<input type="checkbox" name="b4"/> b. clever conversation<br /> 
		<input type="checkbox" name="c4"/> c. saintly behaviour<br /> 
		<input type="checkbox" name="d4" value="4d"/> d. lively imagination<br /> 
	</p>	
	<input type="submit" name="submit" value="click to view your score"/>
	</form>
	</div>
</html>
<?php
if(isset($_POST['submit'])){
$counter=0;
$ansa=$_POST['a'];
$ansc=$_POST['c2'];
$ansb=$_POST['b3'];
$ansd=$_POST['d4'];
if($ansa=="1a"){
$counter+=1;
}else{
}
if($ansc=="2c"){
$counter+=1;
}else{}
if($ansb=="3b"){
$counter+=1;
}else{}
if($ansd=="4d"){
$counter+=1;
}else{}
echo"your score out of 4 is ".$counter ;
}else{
echo "your score will be displayed here";
}
?>









































<?php
?>