package fr.jvsonline.jvsmairistemcli.omega.model;

/**
 * EnumerationType
 * 
 * @author jeromeklam
 */
public enum EnumerateType {
	 TYPE_HABITATION("THAB")	// Type d'habitation	// enum_thab
	,MARQUE_COMPTEUR("MQCPT")	// Marque compteur		// enum_marq
	,DIAMETRE_COMPTEUR("DCPT")	// Diamètre compteur	// enum_diam
	,CALIBRE_COMPTEUR("CALIB")	// Calibre compteur		// enum_calib
	,TYPE_COMPTEUR("TCPT")		// Type de compteur		// enum_tcpt
	,UNITE("UNITE")				// Unité				// enum_unite
	,CIVILITE("CIV")			// Civilité				// enum_civ
	,NATURE_JURIDIQUE("NATJU")	// Nature juridique		// enum_natju
	,CATEGORIE_TIERS("CTIER")	// Catégorie de Tiers	// enum_ctier
	,TYPE_RELEVE("TREL")		// Type de relevè		// enum_crlv
	,BUDGET("BUDGT")			// Budget				// enum_budg
	,TYPE_CONTRAT("TCNT")		// Type de contrat		// enum_tcon
	,NATURE_CONTRAT("NACNT")	// nature du contrat	// enum_natcont
	,SOUS_TYPE_CONTRAT("TCNT")	// sous-type de contrat	// enum_stcont
	,CODE_TVA("TXTVA")			// Code TVA				// enum_tva
	,PAYS("PAYSR")				//						// enum_paysr
	;

	//EnumSet<Civilite> enumSet = EnumSet.allOf(Civilite.class) ;
	
	/**
	 * Code
	 */
	private String code;

	/**
	 * Constructor
	 * 
	 * @param p_code Code
	 * 
	 * @return void
	 */
	private EnumerateType(String p_code) {
		this.code = p_code;
	}

	/**
	 * As String
	 * 
	 * @return String
	 */
	public String getCode() {
		return this.code;
	}
}
