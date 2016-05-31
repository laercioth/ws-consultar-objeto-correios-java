package rastreamento.test;
import org.junit.Test;

import rastreamento.consult.factory.ServiceFactory;


public class AppTest {
	
	/**
	 * URI WS
	 */
	private static final String URI_WS = "http://taleslunadev.com/rastro/json/";
	/**
	 * Numero do objeto a ser consultado
	 */
	private static final String NRO_OBJETO = "DN758697244BR";
	
	/**
	 * Testa o pool de conexão, se esta funcionando ou não
	 * @throws Exception 
	 */
	@Test
	public void testConnection() throws Exception {
		ServiceFactory.consultarGet(URI_WS + NRO_OBJETO , Object.class);
		if(ServiceFactory.connection_ok){
			System.out.println("Conectado!");
		}else{
			System.out.println("Não conectado!");
		}
	}
}
