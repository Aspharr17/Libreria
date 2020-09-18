function validar()
{   
    var isbn = document.getElementById("isbn").value;
    var titulo = document.getElementById("titulo").value;
    var categoria = document.getElementById("categoria").value;
    if(isbn != "" && titulo != "" && categoria !="")
    {
    	
       
    	if(Number.isInteger(parseInt(isbn)))
    	{            
            document.forms[0].action = "InsertarLibro.jsp?ISBN="+isbn+"&titulo="+titulo+"&categoria="+categoria;
            document.forms[0].method = "post";
            document.forms[0].submit();
            
    	}
    	else
    	{
    		alert("Formato de ISBN incorrecto");
    	}
        

    }
    else
    {
        alert("Faltan datos");

    }
    
}

