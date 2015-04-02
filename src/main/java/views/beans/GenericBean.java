package views.beans;
import javax.faces.bean.ManagedProperty;

import controllers.ControllerFactory;
public abstract class GenericBean {
	
	    @ManagedProperty(value = "#{controllerFactory}")
	    private ControllerFactory controllerFactory;

	    public void setControllerFactory(ControllerFactory controllerFactory) {
	        this.controllerFactory = controllerFactory;
	    }

	    protected ControllerFactory getControllerFactory() {
	        return controllerFactory;
	    }
	    
	    public abstract void update();
	    
	    public abstract void process();

}
