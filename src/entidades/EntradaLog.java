package entidades;

import java.util.Date;

public class EntradaLog implements Comparable<EntradaLog> {

	private String nomeDeUsuario;
	private Date data;

	public EntradaLog(String nomeDeUsuario, Date data) {
		super();
		this.nomeDeUsuario = nomeDeUsuario;
		this.data = data;
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	// set baseado apenas no nome do usuário, set não aceito dados repetidos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDeUsuario == null) ? 0 : nomeDeUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaLog other = (EntradaLog) obj;
		if (nomeDeUsuario == null) {
			if (other.nomeDeUsuario != null)
				return false;
		} else if (!nomeDeUsuario.equals(other.nomeDeUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + nomeDeUsuario + ", " + data + "]";
	}

	// ordenando por nome
	@Override
	public int compareTo(EntradaLog other) {

		return nomeDeUsuario.compareTo(other.getNomeDeUsuario());
	}

}
