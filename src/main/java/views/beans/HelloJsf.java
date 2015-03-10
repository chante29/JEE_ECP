package views.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="helloJsf")
@RequestScoped
public class HelloJsf{
    private String name="Hola, desde Bean. OK!!!";

    public String getName() {
        return name;
    }
}
