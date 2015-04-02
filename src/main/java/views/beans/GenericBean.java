package views.beans;
import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import controllers.ControllerFactory;
public abstract class GenericBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
		@ManagedProperty(value = "#{controllerFactory}")
	    private ControllerFactory controllerFactory;

	    public void setControllerFactory(ControllerFactory controllerFactory) {
	        this.controllerFactory = controllerFactory;
	    }

	    protected ControllerFactory getControllerFactory() {
	        return controllerFactory;
	    }
	    
	    public abstract void update();
	    
	    public abstract String process();

}
