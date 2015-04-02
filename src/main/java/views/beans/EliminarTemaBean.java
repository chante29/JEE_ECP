package views.beans;


public class EliminarTemaBean extends ListaTemasBean {
	private static final long serialVersionUID = 1L;
	private static final String MSG_NO_AUTORIZADO = "No has introducido el c&oacute;digo correcto";
	private static final String MSG_TEMA_ELIMINADO = "Se ha eliminado el tema correctamente";
	private static final String VISTA_ELIMINAR_TEMA= "EliminarTema";
	private static final String MSG_INTRODUCE_TOKEN= "Introduce un c&oacute;digo correcto";
	private String mensaje;
	private String token;
	private Integer idTema;
	private boolean autorizado = false;
	@Override
	public String process() {
		if(token == null && idTema != null){
			this.getControllerFactory().getEliminarTemaController().eliminarTema(idTema);
			this.mensaje = MSG_TEMA_ELIMINADO;
		}else if(token != null){
			autorizado = this.getControllerFactory().getEliminarTemaController().autorizacionCorrecta(token);
			if(!autorizado){
				this.mensaje = MSG_NO_AUTORIZADO;
			}
		}else{
			this.mensaje = MSG_INTRODUCE_TOKEN;
		}
		return VISTA_ELIMINAR_TEMA;
	}
	
	@Override
	public void recogerDatosUpdate() {
		// TODO Auto-generated method stub
		
	}


	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}
	
	
	


}
