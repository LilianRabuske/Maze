import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.Scanner;

public class Labirinto {
    private char[][] Labirinto;
    private int row = 0;
    private int column;


    public char[][] carregaLabirinto(String File) {

        try {
            FileReader fr = new FileReader(File);
            BufferedReader br = new BufferedReader(fr);
            try {
                String rowString = br.readLine();
                String columnString = br.readLine();
                row = Integer.parseInt(rowString);
                column = Integer.parseInt(columnString);
            } catch (NumberFormatException e) {
                System.out.println("Há alteração nas linhas do documento que indicam o tamanho da matriz.");
                System.exit(1);
            }

            try {
                Labirinto = new char[row][column];
                for (int r = 0; r < row; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < column; c++) {
                        Labirinto[r][c] = line.charAt(c);
                    }
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Componentes do labirinto não estão de acordo com o tamanho do mesmo. Verificar se não há espaços sem conteúdo.");
                System.exit(1);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo.");
            System.exit(1);
        }
        return Labirinto;
    }


    private Boolean Labirinto(char[][] Labirinto, int rowAtual, int columnAtual) {
        Boolean verifica1 = false;
        Boolean verifica2 = false;
        Boolean verifica3 = false;
        Boolean verifica4 = false;
        //Para conferir como o labirinto é percorrido
        //System.out.print(toString(Labirinto) + "\n \n ");
        if (Labirinto[rowAtual][columnAtual] == 'D') {
            System.out.println("Aqui chegou o fim");
            return true;
        } else {
            Labirinto[rowAtual][columnAtual] = 'O';

            if (rowAtual == 0 && columnAtual == 0) {

                if (Labirinto[rowAtual + 1][columnAtual] != 'X' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual + 1, columnAtual);

                }

                if (Labirinto[rowAtual][columnAtual + 1] != 'X' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual, columnAtual + 1);

                }
            } else if (rowAtual == Labirinto.length - 1 && columnAtual == 0) {


                if (Labirinto[rowAtual - 1][columnAtual] != 'X' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual - 1, columnAtual);

                }

                if (Labirinto[rowAtual][columnAtual + 1] != 'X' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual, columnAtual + 1);

                }
            } else if (rowAtual == 0 && columnAtual == Labirinto[0].length - 1) {


                if (Labirinto[rowAtual][columnAtual - 1] != 'X' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual, columnAtual - 1);

                }

                if (Labirinto[rowAtual + 1][columnAtual] != 'X' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual + 1, columnAtual);

                }
            } else if (rowAtual == Labirinto.length - 1 && columnAtual == Labirinto[0].length - 1) {


                if (Labirinto[rowAtual][columnAtual - 1] != 'X' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual, columnAtual - 1);

                }

                if (Labirinto[rowAtual - 1][columnAtual] != 'X' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual - 1, columnAtual);

                }
            } else if (rowAtual == 0 && columnAtual != Labirinto[0].length - 1 && columnAtual != 0) {


                if (Labirinto[rowAtual][columnAtual - 1] != 'X' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual, columnAtual - 1);

                }
                if (Labirinto[rowAtual][columnAtual + 1] != 'X' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual, columnAtual + 1);

                }
                if (Labirinto[rowAtual + 1][columnAtual] != 'X' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica3 = Labirinto(Labirinto, rowAtual + 1, columnAtual);

                }
            } else if (rowAtual != Labirinto.length - 1 && rowAtual != 0 && columnAtual == 0) {


                if (Labirinto[rowAtual - 1][columnAtual] != 'X' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual - 1, columnAtual);

                }
                if (Labirinto[rowAtual][columnAtual + 1] != 'X' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual, columnAtual + 1);

                }
                if (Labirinto[rowAtual + 1][columnAtual] != 'X' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica3 = Labirinto(Labirinto, rowAtual + 1, columnAtual);

                }
            } else if (rowAtual != Labirinto.length - 1 && rowAtual != 0 && columnAtual == Labirinto[0].length - 1) {
                if (Labirinto[rowAtual - 1][columnAtual] != 'X' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual - 1, columnAtual);

                }
                if (Labirinto[rowAtual][columnAtual - 1] != 'X' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual, columnAtual - 1);

                }
                if (Labirinto[rowAtual + 1][columnAtual] != 'X' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica3 = Labirinto(Labirinto, rowAtual + 1, columnAtual);

                }
            } else if (rowAtual == Labirinto.length - 1 && columnAtual != Labirinto[0].length - 1 && columnAtual != 0) {
                if (Labirinto[rowAtual - 1][columnAtual] != 'X' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual - 1, columnAtual);

                }
                if (Labirinto[rowAtual][columnAtual - 1] != 'X' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual, columnAtual - 1);

                }
                if (Labirinto[rowAtual][columnAtual + 1] != 'X' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica3 = Labirinto(Labirinto, rowAtual, columnAtual + 1);

                }

            } else {
                if (Labirinto[rowAtual - 1][columnAtual] != 'X' && Labirinto[rowAtual - 1][columnAtual] != 'O') {
                    verifica1 = Labirinto(Labirinto, rowAtual - 1, columnAtual);

                }
                if (Labirinto[rowAtual][columnAtual - 1] != 'X' && Labirinto[rowAtual][columnAtual - 1] != 'O') {
                    verifica2 = Labirinto(Labirinto, rowAtual, columnAtual - 1);

                }
                if (Labirinto[rowAtual][columnAtual + 1] != 'X' && Labirinto[rowAtual][columnAtual + 1] != 'O') {
                    verifica3 = Labirinto(Labirinto, rowAtual, columnAtual + 1);

                }
                if (Labirinto[rowAtual + 1][columnAtual] != 'X' && Labirinto[rowAtual + 1][columnAtual] != 'O') {
                    verifica4 = Labirinto(Labirinto, rowAtual + 1, columnAtual);

                }

            }
        }
        if (verifica1 || verifica2 || verifica3 || verifica4) {
            return true;
        } else {
            return false;
        }
    }


    public Boolean Labirinto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo no qual se encontra o labirinto: ");
        String arquivo = scanner.nextLine();
        Labirinto = carregaLabirinto(arquivo);
        Boolean resposta = Labirinto(Labirinto, 0, 0);
        System.out.println("#### Verifique a resposta no documento criado. ####");
        return resposta;
    }


    //Para verificar situação do labirinto se necessário
    /*public String toString(char [][] Labirinto) {

        String situacaoLabirinto = "";
       for (int i = 0; i < Labirinto.length; i++) {
           situacaoLabirinto += "\n";
            for (int j = 0; j < Labirinto[0].length; j++) {
                situacaoLabirinto += Labirinto [i][j];

            }
        }
         return situacaoLabirinto;
    }*/

}






