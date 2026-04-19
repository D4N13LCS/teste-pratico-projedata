package services;
import entities.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioAdm{
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioAdm(){

    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }    

}