package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int id;

    @Column(length = 20)
    private String nombre;

    public User(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "User[id=" + id + ", nombre=" + nombre + "]";
    }
    
}
