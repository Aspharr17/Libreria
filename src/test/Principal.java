package test;

public class Principal 
{

	public static void main(String[] args) 
	{
		/*
		Mensaje mensaje = MensajeFactory.getMensaje();
		mensaje.hola();
		*/
		/*
		@SuppressWarnings("resource")
		ApplicationContext factoria =
				new FileSystemXmlApplicationContext("classpath*:/contextoAplicacion.xml");
		
		Mensaje mimensaje = (Mensaje)factoria.getBean("MensajeHTML");
		mimensaje.hola();
		
		//mimensaje = (Mensaje)factoria.getBean("MensajePlano");
		//mimensaje.hola();
		 
		 */
		MensajeFactory mifactoria= new MensajeFactory();
		Mensaje mensaje= mifactoria.getMensaje();
		mensaje.hola();
		
		((MensajeProxy) mensaje).getMensaje().hola();
	}
		

}
