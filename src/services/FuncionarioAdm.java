package services;
import entities.Funcionario;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

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

    public void aumentarTodosSalarios(BigDecimal percentual){
        for(Funcionario func: this.funcionarios){
            BigDecimal fator = BigDecimal.ONE.add(percentual);
            func.setSalario(func.getSalario().multiply(fator));
        }
    }

    public void cadastrarFuncionarios(String dirPath, String datePattern){
        Funcionario funcionario;
        
        
        try (Scanner sc = new Scanner(new File(dirPath))) {
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
            Integer funcId = 0;
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");

                funcionario = new Funcionario(funcId+=1,
                    line[0], 
                    LocalDate.parse(line[1], formatter),
                    new BigDecimal(line[2]), 
                    line[3]
                    );
                
                this.adicionarFuncionario(funcionario);
                
            }
        }catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    
    }

    public void removerFuncionario(String nome){
        this.funcionarios.removeIf(f -> f.getNome().equals(nome));
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