function sum()
{
    
    var n1 = document.getElementById("n1").value;
    var n2 = document.getElementById("n2").value;
    
    if(validar(n1,n2))
        {
            alert(parseInt(n1)+parseInt(n2));
        }
    else
        {
            alert("Faltan datos");
        }
}
function validar(n1,n2)
{
    
    if(n1 != "" && n2 != "" )
    {
        return true;

    }
    else
    {
        return false;

    }
}

function tbtimes()
{
    var number = document.getElementById("number").value;
    if(number != "")
    {
        for(var i = 0; i<10; i++)
        {
            console.log(parseInt(number)*(i+1));
        }
    
    }
       
}