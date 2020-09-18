function validar(id)
{   
	var isbn = document.getElementById("isbn").value;
    var titulo = document.getElementById("titulo").value;
    var categoria = document.getElementById("categoria").value;
    if(isbn != "" && titulo != "" && categoria !="")
    {
    	
    	if(Number.isInteger(parseInt(isbn)))
    	{            
    		if(id=='nuevo')
    		{
    			alert("NUEVO");

    			document.forms[0].action = "InsertarLibro.jsp?ISBN="+isbn+"&titulo="+titulo+"&categoria="+categoria;
                document.forms[0].method = "post";
                document.forms[0].submit();
    		}
    		else
    		{
    			alert("ELSE");

    			document.forms[0].action = "GuardarLibro.jsp?ISBN="+isbn+"&titulo="+titulo+"&categoria="+categoria;
                document.forms[0].method = "post";
                document.forms[0].submit();
    		}

            
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

