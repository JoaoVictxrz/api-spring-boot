package com.portfolio.users.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String name;
    private String email;
    private String password;
    private Integer telefone;
	
	//Construtor vazio
	public void Users() {  
	}
	//construtor usando todos os atributos
	public void Users(Long id, String name,String email, String password, Integer telefone  ) { 
		this.id = id;
		this.name = name; 
		this.email = email; 
		this.password = password; 
		this.telefone = telefone;
	}
	
	// Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //hashcode 
	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(telefone, other.telefone);
	}    

}
