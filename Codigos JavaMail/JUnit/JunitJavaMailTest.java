package ejemjunitjmail;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JunitJavaMailTest {

	
	@Test
	public void probar1 (){
		System.out.print("Estamos Testtiando prueba 1");
		JunitJavaMail juan = new JunitJavaMail("juankaperez.jcp@gmail.com","juanperez");
		assertTrue(juan.enviarMensaje(null)== true);
	}
}
