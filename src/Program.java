
import entities.Funcionario;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import services.FuncionarioAdm;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        readEmployees();
    }

    public static void readEmployees(){
        // Inserir funcionários
        FuncionarioAdm funcionarioAdm = new FuncionarioAdm();
        funcionarioAdm.cadastrarFuncionarios("C:\\Users\\DELL\\Documents\\original_file.csv", "dd/MM/yyyy");

        // Remover funcionário João
        funcionarioAdm.removerFuncionario("João");

        // Imprimir todos os funcionários

        funcionarioAdm.listarTodosFuncionarios("dd/MM/yyyy");

        // Aumentar o salário de todos os funcionários em 10%
        funcionarioAdm.aumentarTodosSalarios(new BigDecimal("0.1"));
        funcionarioAdm.listarTodosFuncionarios("dd/MM/yyyy");

        // Agrupar funcionários por função
        Map<String, List<Funcionario>> mapa = funcionarioAdm.agruparFuncionariosPorFuncao();

        // Listar funcionários agrupados por função
        for(String func: mapa.keySet()){
            System.out.print("\n" + func + ": ");
            mapa.get(func).forEach(f -> System.out.print(f.getNome() + " "));
            
        }

        // Listar funcionários nascidos no mês 10 e 12
        funcionarioAdm.getFuncionarios()
        .stream()
        .filter(f -> f.getDataNascimento().getMonthValue() == 10 || 
        f.getDataNascimento().getMonthValue() == 12)
        .forEach(f -> System.out.println(f.getNome() + " " + f.getDataNascimento()));
        
        // Listar o funcionário mais velho
        System.err.println(funcionarioAdm.buscarFuncionarioMaisVelho());
        
        // Listar funcionários por ordem alfabética
        funcionarioAdm.ordenarFuncionarios().forEach(f -> System.out.println(f.getNome()));

        // Total dos salários 
        System.out.println(funcionarioAdm.somarTodoSalarios());

        // Quantidade de salários mínimos que cada funcionário ganha
        funcionarioAdm.buscarQuantidadeSalarioMinimo();
    }
}