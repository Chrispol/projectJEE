package pl.dmcs.zai.dictionary;

public class DictionaryType {

	public enum Type {
		
		CATEGORY("Kategoria"),SUBCATEGORY("Podkategoria"),TYPE("Typ"),
		PRIORITY("Priorytet"),STATUS("Status");
		
		String message;

		private Type(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}	
	}
}
