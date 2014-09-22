package pl.dmcs.zai.dictionary;

	public enum EnumDictionaryType {
		
		CATEGORY("Kategoria", "categoriesList"),SUBCATEGORY("Podkategoria", "subcategoriesList"),TYPE("Typ", "typesList"),
		PRIORITY("Priorytet", "prioritiesList"),STATUS("Status", "statusesList");
		
		String message;
		
		String listContext;
		
		private EnumDictionaryType(String message, String listContext) {
			this.message = message;
			this.listContext = listContext;
		}

		public String getMessage() {
			return message;
		}	
		
		public String getName(){
			return this.name();
		}

		public String getListContext() {
			return listContext;
		}

		
		
}
