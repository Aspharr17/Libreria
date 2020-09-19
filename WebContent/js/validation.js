function validar()
{   
	var isbn = document.getElementById("isbn").value;
    var titulo = document.getElementById("titulo").value;
    var categoria = document.getElementById("categoria").value;
    var autor = document.getElementById("autor").value;
    
    if(isbn != "" && titulo != "" && categoria !="seleccionar" && autor!="seleccionar" && Number.isInteger(parseInt(isbn)))
    {
    	
    	alert("Guardado");
    	return true;

    }
    else
    {
        alert("Faltan datos");
        return false;
    }
    
}

function filtro()
{
	var sel_categoria = document.getElementById("sel_categoria").value;
    var formFiltro = document.getElementById("formFiltro");
	if(sel_categoria != "seleccionar")
	{
		 	formFiltro.action = "FiltrarLibros.do"
		 	formFiltro.method = "post";
		 	formFiltro.submit();
	}
	else
	{
		formFiltro.action = "MostrarLibro.do"
		formFiltro.method = "post";
		formFiltro.submit();
		
	}


}

