import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrincipalLabirinto {
    public static void main(String[] args) {
        Labirinto teste = new Labirinto();


        try {
            File f = new File("SaidaLabirinto.txt");
            FileWriter fr = new FileWriter(f);
            PrintWriter out = new PrintWriter(fr);
            if (teste.Labirinto()) {
                out.println("Existe um caminho para o labirinto.");
            } else {
                out.println("Não existe um caminho para o labirinto.");
            }
            out.close();

        } catch (IOException e) {
            System.out.print("Erro");
        }

    }
}
