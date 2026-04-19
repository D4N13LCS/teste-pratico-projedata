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

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    
    public void listarTodosFuncionarios(String datePattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);

        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        nf.setMinimumFractionDigits(2);
        
        for (Funcionario func: this.getFuncionarios()){
                    System.out.println(func.getId()
                    + " " + func.getNome() 
                    + " " + func.getDataNascimento().format(formatter)
                    + " " + nf.format(func.getSalario())
                    + " " + func.getFuncao());
                }
    }
}