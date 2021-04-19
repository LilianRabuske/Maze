import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;

public class Labirinto {





    public char[][] carregaLabirinto(String File) throws IOException { //Adicionar exceptions

        ; //dentro dos parenteses irá o parametro da método

        FileReader fr = new FileReader(File);
        BufferedReader br = new BufferedReader(fr);
        String rowString = br.readLine();
        String columnString = br.readLine();
        int row = Integer.parseInt(rowString);
        int column = Integer.parseInt(columnString);
        char [][]Labirinto = new char[row][column];
        for(int r = 0; r < row ; r++ ){ //por linha
            String line = br.readLine();
            for (int c = 0; c < column; c++){
                Labirinto [r][c] = line.charAt(c);
            }

        }
    br.close();
        return Labirinto;
    }

    private Boolean Labirinto (char [][] Labirinto, int rowAtual, int columnAtual, int rowAntigo, int columnAntigo){
        if(rowAtual == 0 && columnAtual == 0){
            //Se o labirinto encontrou D retorna true
            //Se o Labirinto Não encontrou saída então retorna false

            if(Labirinto [rowAtual + 1][columnAtual] == ' ' && Labirinto [rowAtual + 1][columnAtual] != Labirinto [rowAntigo][columnAntigo]){
                Labirinto()
            }
        }
    }

    public Boolean Labirinto(){
        
    }


    public String toString(char [][] Labirinto) {

        String situacaoLabirinto = "";
       for (int i = 0; i < Labirinto.length; i++) {
           situacaoLabirinto += "\n";
            for (int j = 0; j < Labirinto[0].length; j++) {
                situacaoLabirinto += Labirinto [i][j];

            }
        }
         return situacaoLabirinto;
    }

}



//Criar método carregaLabirinto que recebe String fileName e retorna um array bidimensional.
//Pesquisar a utilização de charAt para percorrer todos os caracteres de uma linha
//criar método recursivo (métodos público e privado) chamado labirinto
//este recebe array de caracteres e retorna verdadeiro caso chegue na saida e falso caso não exista.
//no método público deve-se chamar carregaLabirinto.


