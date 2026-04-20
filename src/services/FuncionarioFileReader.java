package services;
import entities.Funcionario;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioFileReader {

    public List<Funcionario> carregar(String dirPath, String datePattern) {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(dirPath))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
            int id = 0;

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");

                funcionarios.add(new Funcionario(
                        ++id,
                        line[0],
                        LocalDate.parse(line[1], formatter),
                        new BigDecimal(line[2]),
                        line[3]
                ));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }

        return funcionarios;
    }
}