package pl.dmcs.zai.dictionary;

	public enum EnumDictionaryType {
		
		CATEGORY("Kategoria"),SUBCATEGORY("Podkategoria"),TYPE("Typ"),
		PRIORITY("Priorytet"),STATUS("Status");
		
		String message;

		private EnumDictionaryType(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}	

}
