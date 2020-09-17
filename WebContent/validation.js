function suma()
{
    var isbn = document.getElementById("isbn").value;
    console.log(isbn);
}

function validar()
{
    console.log("Validar");
   
    var isbn = document.getElementById("isbn").value;
    var titulo = document.getElementById("titulo").value;
    var categoria = document.getElementById("categoria").value;
    if(isbn != "" && titulo != "" && categoria !="")
    {
       
    	console.log(isbn+titulo+categoria);
        
        document.forms[0].action = "InsertarLibro.jsp?ISBN="+isbn+"&titulo="+titulo+"&categoria="+categoria;
        document.forms[0].method = "post";
        document.forms[0].submit();
        

    }
    else
    {
        alert("Faltan datos")

    }
    
}

