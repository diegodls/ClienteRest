/*, rs.getString("cpf")
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rodrigo Plotze
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String cpf;
   

    

    public Cliente() {
    }

    public Cliente(int id, String nome,String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    

    @Override
    public String toString() {
        return nome;
    }
    
}
