function validar(id)
{   
	var isbn = document.getElementById("isbn").value;
    var titulo = document.getElementById("titulo").value;
    var categoria = document.getElementById("categoria").value;
    var formInsertar = document.getElementById("formInsertar");
    if(isbn != "" && titulo != "" && categoria !="" && Number.isInteger(parseInt(isbn)))
    {
    	
    	alert("Guardado");
    	formInsertar.submit();

    }
    else
    {
        alert("Faltan datos");
        return false;
    }
    
}

