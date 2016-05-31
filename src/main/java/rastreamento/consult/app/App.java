package rastreamento.consult.app;

import rastreamento.consult.factory.ServiceFactory;

import com.google.gson.Gson;

/**
 * Classe teste, simulando a aplicacao, classe, metodo que poderia estar
 * invocando o servico
 * @author laercioleal
 */
public class App {
	/**
	 * Init variables
	 */
	private static final String URI_WS = "http://taleslunadev.com/rastro/json/";
	private static final String NRO_OBJETO = "DN75869s7244BR";
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Object rastreamento = null;
		rastreamento = callWebService(NRO_OBJETO, rastreamento);
		if (rastreamento != null) {
			String[] animalsArray = parserObjetoToString(rastreamento);
			boolean first = true;
			first = formatterString(animalsArray, first);
		}
	}

	/**
	 * Faz o parse do Object to Gson
	 * @param rastreamento
	 * @param gson
	 * @return
	 */
	private static String[] parserObjetoToString(Object rastreamento) {
		Gson gson = new Gson();
		String json = gson.toJson(rastreamento);
		String[] animalsArray = json.split(",");
		return animalsArray;
	}

	/**
	 * Formata a string com as informacoes do WS
	 * @param animalsArray
	 * @param first
	 * @return
	 */
	private static boolean formatterString(String[] animalsArray, boolean first) {
		for (String string : animalsArray) {
			String cleanString = string.replaceAll("[\\p{Punct}]", " ");
			if(first){
				cleanString = new StringBuilder(cleanString).insert(cleanString.length()-24, "\n\n").toString();
				System.out.println(cleanString.toString().trim());
				first = false;
			}else{
				System.out.println(cleanString.toString().trim());
			}
		}
		return first;
	}
	
	/**
	 * Chama o WS
	 * @param nroObjeto
	 * @param rastreamento
	 * @return
	 */
	private static Object callWebService(String nroObjeto, Object rastreamento) {
		try {
			rastreamento = ServiceFactory.consultarGet(URI_WS + nroObjeto.toUpperCase(), Object.class);
		} catch (Exception e) {
			System.out.println("OBJETO NÃO ENCONTRADO OU NÃO EXISTE!");
		}
		return rastreamento;
	}
}

