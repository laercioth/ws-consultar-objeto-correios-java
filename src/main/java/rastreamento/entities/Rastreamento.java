
package rastreamento.entities;

import java.util.ArrayList;
import java.util.List;

public class Rastreamento {

    private List<Rastreio> rastreios = new ArrayList<Rastreio>();

	/**
	 * @return the rastreios
	 */
	public List<Rastreio> getRastreios() {
		return rastreios;
	}

	/**
	 * @param rastreios the rastreios to set
	 */
	public void setRastreios(List<Rastreio> rastreios) {
		this.rastreios = rastreios;
	}

}
