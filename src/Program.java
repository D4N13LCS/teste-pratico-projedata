
import entities.Funcionario;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import services.FuncionarioFileReader;
import services.FuncionarioService;

public class Program{

    public static void main(String[] args) {
        FuncionarioFileReader reader = new FuncionarioFileReader();

        List<Funcionario> funcionarios =
                reader.carregar("C:\\Users\\DELL\\Desktop\\projedata\\funcionarios.csv", "dd/MM/yyyy");


        FuncionarioService service = new FuncionarioService(funcionarios);

        // Remover funcionário da lista
        service.removerFuncionario("João");

        // Listar funcionários
        System.out.println("lista de funcionários:\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        nf.setMinimumFractionDigits(2);

        for (Funcionario f : funcionarios) {
            System.out.println(
                    f.getId() + " " +
                    f.getNome() + " " +
                    f.getDataNascimento().format(formatter) + " " +
                    nf.format(f.getSalario()) + " " +
                    f.getFuncao()
            );
        }

        // Aumentar salário em 10%
        service.aumentarTodosSalarios(new BigDecimal("0.10"));

        // Agrupar os funcionários por função
        System.out.println("\nfuncionários agrupados por função:");

        Map<String, List<Funcionario>> funcionariosAgrupados = service.agruparFuncionariosPorFuncao();
        
        for(String func: funcionariosAgrupados.keySet()){
            System.out.print("\n" + func + ": ");
            funcionariosAgrupados.get(func).forEach(f -> System.out.print(f.getNome() + " "));
        }

        // funcionários que fazem aniversário no mês 10 e 12
        System.out.println("\n\nfuncionários que fazem aniversário no mês 10 e 12:\n");
        service.buscarPorMesDeNascimento()
        .forEach(f -> System.out.println("Nome: " + f.getNome() + " | Data de nascimento: " + f.getDataNascimento().format(formatter)));

        // Funcionário mais velho

        System.out.println("\n\nfuncionário mais velho:");

        Funcionario maisVelho = service.buscarFuncionarioMaisVelho();
        System.out.println("Nome: " + maisVelho.getNome() + "\nIdade: " + maisVelho.getIdade());

        System.out.println("\nlista de funcionários em ordem alfabética:\n");
        
        service.ordenarFuncionarios().forEach(f -> 
            System.out.println(
                f.getId() + " " +
                f.getNome() + " " +
                f.getDataNascimento().format(formatter) + " " +
                nf.format(f.getSalario()) + " " +
                f.getFuncao()
            )
        );

        // Total salários
        System.out.println("\nTotal salários: " + service.somarTodoSalarios());
        
        // Salários mínimos
        System.out.println("\nSalários mínimos:");
        service.buscarQuantidadeSalarioMinimo()
                .forEach((func, qtd) ->
                        System.out.println(func + ": " + qtd));
    }
}
