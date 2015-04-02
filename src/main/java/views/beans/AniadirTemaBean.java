package views.beans;

import es.miw.persistence.models.entities.Tema;


public class AniadirTemaBean extends GenericBean {
	private static final long serialVersionUID = 1L;
	private static final String EXISTE_TEMA_MSG= "Ya existe ese tema";
	private static final String TEMA_ANADIDO= "Se ha a&ntilde;adido el tema";
	private static final String VISTA_ANIADIR_TEMA= "AniadirTema";
	

	private Tema tema;
	private String mensaje = "";
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String process() {
		boolean existeTema = this.getControllerFactory().getAniadirTemaController().existeTema(tema);
		
		if(!existeTema){
			this.getControllerFactory().getAniadirTemaController().aniadirTema(tema);
			this.mensaje = TEMA_ANADIDO;
		}
		else{
			this.mensaje =  EXISTE_TEMA_MSG;
		}
		
		return VISTA_ANIADIR_TEMA;
	}


	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(String nombre_tema, String pregunta) {
		this.tema = new Tema(nombre_tema, pregunta);
	}
	
	

}
