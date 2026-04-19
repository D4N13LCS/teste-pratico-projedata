package entities;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private final Integer id;
    private BigDecimal salario;
    private String funcao;

    public Funcionario(Integer id, String nome, LocalDate dataNascimento,BigDecimal salario, String funcao){
        super(nome, dataNascimento);
        this.id = id;
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString(){
        return this.getNome();
    }
}