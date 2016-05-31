package rastreamento.consult.factory;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


/**
 * Classe responsavel por criar Pool de conexao via WS
 * @author laercioleal
 *
 */
public class ServiceFactory {
	
	private static final Long STATUS_OK = 200L;
	
	public static boolean connection_ok = false;
	/**
	 * Responsavel por criar um pool de conexao com a url do WS
	 * @param url
	 * @param classeResposta
	 * @return
	 * @throws Exception 
	 */
	public static <E> E consultarGet(String url, Class<E> classeResposta) throws Exception {
		WebResource.Builder resource = Client.create().resource(url).header("Content-Type", "text/html");
		WebResource.Builder builder = resource.type(MediaType.APPLICATION_JSON);
		return acessarGet(classeResposta, builder);
	}
	
	/**
	 * Responsavel por receber o WS e fazer a conversao da classe de resposta
	 * @param classeResposta
	 * @param builder
	 * @return
	 * @throws Exception 
	 */
	private static <E> E acessarGet(Class<E> classeResposta, WebResource.Builder builder) throws Exception {
		ClientResponse response = builder.get(ClientResponse.class);
		if (response.getStatus() == STATUS_OK) {
			connection_ok = true;
			
			try {
				return response.getEntity(classeResposta);
			} catch (Exception e) {
				throw new Exception();
			}
		}else{
			connection_ok = false;
			return null;
		}
	}

	/**
	 * @return the connection_ok
	 */
	public static boolean isConnection_ok() {
		return connection_ok;
	}

	/**
	 * @param connection_ok the connection_ok to set
	 */
	public static void setConnection_ok(boolean connection_ok) {
		ServiceFactory.connection_ok = connection_ok;
	}
	
}