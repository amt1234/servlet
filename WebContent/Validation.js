function ValidationTextname(){
	var result=document.getElementById("nameId");
	if(result.value=="")
		{
		alert("Please Enter name");
		return false;
		}
	var result1=document.getElementById("emailId");
	if(result1.value=="")
		{
		alert("Please Enter Username");
		return false;
		}
	var passWord=document.getElementById("passwordId");
	  if((passWord.value=="") && (passWord.lenght>5))
	  {
	    alert("Please Enter at least 6 digit Password");
	    return false;
	  } 
	  return true;
}