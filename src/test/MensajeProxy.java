package test;

public class MensajeProxy implements Mensaje 
{
	private Mensaje mensaje;
	public Mensaje getMensaje()
	{
		return mensaje;
	}
	
	public void hola() {
		System.out.println("funcionalidad adicional proxy");
		mensaje.hola();
		System.out.println("funcionalidad adicional proxy");
	}
	
	public MensajeProxy()
	{
		this.mensaje = new MensajeHTML();
	}
}
