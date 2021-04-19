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

    private Boolean Labirinto (char [][] Labirinto, int rowAtual, int columnAtual){
        Boolean verifica1 =  false;
        Boolean verifica2 =  false;
        Boolean verifica3 =  false;
        Boolean verifica4 =  false;
        Labirinto[rowAtual][columnAtual] = 'O';
        if(Labirinto[rowAtual][columnAtual] != 'D') {
            //Se for posição [0,0]
            if (rowAtual == 0 && columnAtual == 0) {
                //Se o labirinto encontrou D retorna true
                //Se o Labirinto Não encontrou saída então retorna false

                //[1,0]
                if (Labirinto[rowAtual + 1][columnAtual] == ' ' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                   verifica1 =  Labirinto(Labirinto, rowAtual + 1, columnAtual);
                }
                //[0,1]
                if (Labirinto[rowAtual][columnAtual + 1] == ' ' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual, columnAtual + 1);
                }
            }
            //[length-1, 0]
            else if (rowAtual == Labirinto.length - 1 && columnAtual == 0) {

                //[length - 2, 0]
                if (Labirinto[rowAtual - 1][columnAtual] == ' ' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                   verifica1 = Labirinto(Labirinto, rowAtual - 1, columnAtual);
                }
                //[length - 1, 1]
                if (Labirinto[rowAtual][columnAtual + 1] == ' ' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                   verifica2 = Labirinto(Labirinto, rowAtual, columnAtual + 1);
                }
            }
            //[0, length - 1]
            else if (rowAtual == 0 && columnAtual == Labirinto.length - 1) {

                //[0, length - 2]
                if (Labirinto[rowAtual][columnAtual - 1] == ' ' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                  verifica1 =  Labirinto(Labirinto, rowAtual, columnAtual - 1);
                }
                //[1, length - 1]
                if (Labirinto[rowAtual + 1][columnAtual] == ' ' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual + 1, columnAtual);
                }
            }
            //[length - 1, [0].length-1
            else if (rowAtual == Labirinto.length - 1 && columnAtual == Labirinto[0].length - 1) {

                //[length-1, length - 2]
                if (Labirinto[rowAtual][columnAtual - 1] == ' ' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica1 =  Labirinto(Labirinto, rowAtual, columnAtual - 1);
                }
                //[length-2, length - 1]
                if (Labirinto[rowAtual - 1][columnAtual] == ' ' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica2 =  Labirinto(Labirinto, rowAtual - 1, columnAtual);
                }
            }
            //[0, y]
            else if (rowAtual == 0 && columnAtual != Labirinto[0].length - 1 && columnAtual != 0) {


                if (Labirinto[rowAtual][columnAtual - 1] == ' ' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica1 =  Labirinto(Labirinto, rowAtual, columnAtual - 1);
                }
                if (Labirinto[rowAtual][columnAtual + 1] == ' ' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica2 =  Labirinto(Labirinto, rowAtual, columnAtual + 1);
                }
                if (Labirinto[rowAtual + 1][columnAtual] == ' ' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica3 =  Labirinto(Labirinto, rowAtual + 1, columnAtual);
                }
            }
            //[x, 0]
            else if (rowAtual != Labirinto.length - 1 && rowAtual != 0 && columnAtual == 0) {


                if (Labirinto[rowAtual - 1][columnAtual] == ' ' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual - 1, columnAtual);
                }
                if (Labirinto[rowAtual][columnAtual + 1] == ' ' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica2 =  Labirinto(Labirinto, rowAtual, columnAtual + 1);
                }
                if (Labirinto[rowAtual + 1][columnAtual] == ' ' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica3 = Labirinto(Labirinto, rowAtual + 1, columnAtual);
                }
            }

            //[x, [0].length-1]
            else if (rowAtual != Labirinto.length - 1 && rowAtual != 0 && columnAtual == Labirinto[0].length - 1) {
                if (Labirinto[rowAtual - 1][columnAtual] == ' ' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica1 =  Labirinto(Labirinto, rowAtual - 1, columnAtual);
                }
                if (Labirinto[rowAtual][columnAtual - 1] == ' ' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica2 =  Labirinto(Labirinto, rowAtual, columnAtual - 1);
                }
                if (Labirinto[rowAtual + 1][columnAtual] == ' ' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica3 =  Labirinto(Labirinto, rowAtual + 1, columnAtual);
                }
            }
            //[length-1, y]
            else if (rowAtual == Labirinto.length - 1 && columnAtual != Labirinto.length - 1 && columnAtual != 0) {
                if (Labirinto[rowAtual - 1][columnAtual] == ' ' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual - 1, columnAtual);
                }
                if (Labirinto[rowAtual][columnAtual - 1] == ' ' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual, columnAtual - 1);
                }
                if (Labirinto[rowAtual][columnAtual + 1] == ' ' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica3 = Labirinto(Labirinto, rowAtual, columnAtual + 1);
                }

            } else {
                if (Labirinto[rowAtual - 1][columnAtual] == ' ' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual - 1, columnAtual);
                }
                if (Labirinto[rowAtual][columnAtual - 1] == ' ' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica2 =  Labirinto(Labirinto, rowAtual, columnAtual - 1);
                }
                if (Labirinto[rowAtual][columnAtual + 1] == ' ' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica2 =  Labirinto(Labirinto, rowAtual, columnAtual + 1);
                }
                if (Labirinto[rowAtual + 1][columnAtual] == ' ' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica2 =  Labirinto(Labirinto, rowAtual + 1, columnAtual);
                }

            }
            if(!verifica1 && !verifica2 && !verifica3 && !verifica4) {
                return false;
            } else{
                return true;
            }
        }
        else {
           return true;
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


