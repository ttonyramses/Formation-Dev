package liste;

public class VideException extends Exception {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "La liste est vide";
	}
}
