package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Principal 
{

	public static void main(String[] args) 
	{
		/*
		Mensaje mensaje = MensajeFactory.getMensaje();
		mensaje.hola();
		*/
	
		@SuppressWarnings("resource")
		ApplicationContext factoria =
				new FileSystemXmlApplicationContext("classpath*:/contextoAplicacion.xml");
		
		Mensaje mimensaje = (Mensaje)factoria.getBean("MensajeHTML");
		mimensaje.hola();
		
		mimensaje = (Mensaje)factoria.getBean("MensajePlano");
		mimensaje.hola();
		
	}

}
