package sopra.promo404.hopital.model;



public class Views {
	public static class ViewCommon {
	}

	public static class ViewMedecin extends ViewCommon {
	}

	public static class ViewMedecinWithFileAttente extends ViewMedecin {
	}
	
	public static class ViewMedecinWithSalle extends ViewMedecin {
	}
	
	public static class ViewMedecinWithSpecialite extends ViewMedecin {
	}
	
//
//	

	public static class ViewPatient extends ViewCommon {
	}

	public static class ViewPatientWithFileAttente extends ViewPatient {
	}
	
	public static class ViewPatientWithConsultation extends ViewPatient {
	}

//	
//	
	
	public static class ViewSecretaire extends ViewCommon {
	}

	public static class ViewSecretaireWithFileAttente extends ViewSecretaire {	
	}
	
//	
//	

	public static class ViewConsultation extends ViewCommon {
	}
	
	public static class ViewConsultationWithSalle extends ViewConsultation {
	}
	
//	
//	

	public static class ViewSpecialite extends ViewCommon {
	}
	
//	
//	
	
	public static class ViewSalle extends ViewCommon {
	}
//
//

	public static class ViewFileAttente extends ViewCommon {
	}
}
