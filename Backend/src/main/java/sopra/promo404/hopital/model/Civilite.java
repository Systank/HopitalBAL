package sopra.promo404.hopital.model;

public enum Civilite {
	DR("Docteur"),M("Monsieur"), MME("Madame"), MLLE("Mademoiselle");

	private final String label;

	private Civilite(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
