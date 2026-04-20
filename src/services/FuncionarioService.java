package services;
import entities.Funcionario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioService{
    private final List<Funcionario> funcionarios;

    public FuncionarioService(List<Funcionario> funcionarios){
        this.funcionarios = funcionarios;
    }

    public List<Funcionario> buscarFuncionarios() {
        return this.funcionarios;
    }    

    public Funcionario buscarFuncionarioMaisVelho(){
        return this.buscarFuncionarios()
        .stream()
        .min((e1, e2) -> e1.getDataNascimento().compareTo(e2.getDataNascimento())).orElse(null);
    }

    public Map<String, Integer> buscarQuantidadeSalarioMinimo() {
        BigDecimal minimumSal = new BigDecimal("1212.00");
        Map<String, Integer> salMinimo= new HashMap<>();
        for (Funcionario f : this.funcionarios) {
            BigDecimal resultado = f.getSalario().divideToIntegralValue(minimumSal);
            int qty = resultado.intValue();

            salMinimo.put(f.getNome(), qty);
        }
        return salMinimo;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void removerFuncionario(String nome){
        this.funcionarios.removeIf(f -> f.getNome().equals(nome));
    }

    public void aumentarTodosSalarios(BigDecimal percentual){
        for(Funcionario func: this.funcionarios){
            BigDecimal fator = BigDecimal.ONE.add(percentual);
            func.setSalario(func.getSalario().multiply(fator));
        }
    }

    public BigDecimal somarTodoSalarios(){
        BigDecimal sal = new BigDecimal("0.00");
        for(Funcionario f: this.buscarFuncionarios()){
            sal = sal.add(f.getSalario());
        }
        return sal;
    }

    public Map<String, List<Funcionario>> agruparFuncionariosPorFuncao(){
        Map<String, List<Funcionario>> funcAgrupados = new HashMap<>();
        for(Funcionario func: this.funcionarios){
            String funcao = func.getFuncao();

            if(!funcAgrupados.containsKey(funcao)){
                funcAgrupados.put(funcao, new ArrayList<>());
            }

            funcAgrupados.get(funcao).add(func);
        }
        
        return funcAgrupados;
    }

    public List<Funcionario> ordenarFuncionarios(){
        return this.buscarFuncionarios()
        .stream()
        .sorted((e1,e2) -> e1.getNome().compareTo(e2.getNome()))
        .toList();
    }

    public List<Funcionario> buscarPorMesDeNascimento(){
        return this.buscarFuncionarios()
        .stream()
        .filter(f -> f.getDataNascimento().getMonthValue() == 10 || 
        f.getDataNascimento().getMonthValue() == 12).toList();
    }

}