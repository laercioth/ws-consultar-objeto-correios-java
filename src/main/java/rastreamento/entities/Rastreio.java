package rastreamento.entities;

public class Rastreio {
	private String data;

	private String situacao;

	private String local;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "Rastreio [data=" + data + ", situacao=" + situacao + ", local="
				+ local + "]";
	}
}