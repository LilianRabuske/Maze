import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Labirinto teste = new Labirinto();
        char [][] Labirinto = teste.carregaLabirinto("Labirinto.txt");

System.out.println(teste.toString(Labirinto));

    }
}
