//Filtrado
//const selectElement = document.querySelector('.sel_filtro');

function seleccion()
{
	$('#sel_categoria').hide();
	$('#sel_autor').hide();
	 const resultado = document.querySelector('.resultado');
	 var opc = ` #sel_${event.target.value}`
	 $(opc).show();
	 //resultado.textContent =opc;
}

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
	var sel_autor = document.getElementById("sel_autor").value;
	//var sel_filtro = document.getElementById("sel_filtro").value;

    var formFiltro = document.getElementById("formFiltro");
	if(sel_categoria != "seleccionar" || sel_autor !="seleccionar")
	{
		 	formFiltro.action = "FiltrarLibros.do"
		 	formFiltro.method = "post";
		 	formFiltro.submit();
		 	
	}
	else
	{
		formFiltro.action = "MostrarLibros.do"
		formFiltro.method = "post";
		formFiltro.submit();
		
	}


}

