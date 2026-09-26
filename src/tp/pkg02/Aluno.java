/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.pkg02;
import java.util.UUID;
import java.util.ArrayList;

/**
 *
 * @author cavia
 */
public class Aluno {
   private UUID uuid;
    private String endereco;
    private String nome;
    private int idade;
    
    public static ArrayList<Aluno> alunos = new ArrayList<>();

    public Aluno(String endereco, String nome, int idade) {
        setUuid();
        setEndereco(endereco);
        setNome(nome);
        setIdade(idade);
        alunos.add(this);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid() {
       UUID id = UUID.randomUUID();
       this.uuid = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
