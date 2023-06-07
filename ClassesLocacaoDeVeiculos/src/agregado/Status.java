package agregado;

public class Status {
	
	private boolean alugado;
	
	public Status() {
	}

    public Status(boolean alugado) {
        this.alugado = alugado;
    }

    public String getStatus() {
        if (alugado) {
            return "Disponível";
        } else {
            return "Alugado";
        }
    }

}
