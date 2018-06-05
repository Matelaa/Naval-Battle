import java.util.*;

/**
 * Created by josem on 20/04/2017.
 */
public class MainNavalBattle {

    static final int VAZIO = 0;
    static final int NAVIO = 1;
    static final int NAVIO2 = 4;
    static final int NAVIO3 = 5;
    static final int NAVIO4 = 6;
    static final int BOMBA = 8;
    static final int ERROU_TIRO = 2;
    static final int ACERTOU_TIRO = 3;
    static final int ACERTOU_TIRO_NA_BOMBA = 9;

    static final int POSIÇAO_X = 0;
    static final int POSIÇAO_Y = 1;

    static String nomePlayer1, nomePlayer2 = "Almirante Guimarães";
    static String patente;
    // LARGURA = COLUNA = tamanhoY = Y; ALTURA = LINHAS = tamanhoX = X;
    static int altura = 10, largura = 10;
    static int quantidadeNavios, limiteNavios;
    static int tabuleiroplayer1[][], tabuleiroplayer2[][];
    static int naviosPlayer1, naviosPlayer2;
    static int quantidadeRestanteDeBombas, quantidadeDeBombas;
    static boolean jogoAtivo = true;
    // U10 - Navio 4 espaços.
    static int U10 = 4;
    // G30 Ceará - Navio 3 espaços.
    static int G30 = 3;
    // G31 Rio de Janeiro - Navio 3 espaços.
    static int G31 = 3;
    // P40 Grajaú - Navio 2 espaços.
    static int P40 = 2;
    // P41 Guaiba - Navio 2 espaços.
    static int P41 = 2;
    // P42 Graúna - Navio 2 espaços.
    static int P42 = 2;
    // P43 Goiana - Navio 2 espaços.
    static int P43 = 2;
    // P10 Piratini - Navio 1 espaços.
    static int P10 = 1;
    // P11 Prajá - Navio 1 espaços.
    static int P11 = 1;
    // PATENTES.
    static int patentes = 1;
    static boolean win = false;
    static Scanner sc = new Scanner(System.in);

    public static void tamanhoTabuleiro() {

        //MENU DO JOGO
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ie) {

            }
            System.out.println(" -------  BATALHA NAVRAL   -------");
            System.out.println("|                                 |");
            System.out.println("|     ---------------------       |");
            System.out.println("|     |                   |       |");
            System.out.println("|     |  PREPARE FOR WAR  |       |");
            System.out.println("|     |                   |       |");
            System.out.println("|     ---------------------       |");
            System.out.println("|                                 |");
            System.out.println(" -------  BATALHA NAVRAL   -------");
            System.out.println();
        }
    }

    public static void recebendoTamanhoDosTabuleiros() {

        // RECEBE OS VALORES Largura/Altura aplica em uma matriz
        tabuleiroplayer1 = retornarNovoTabuleiroVazio();
        tabuleiroplayer2 = retornarNovoTabuleiroVazio();
    }

    public static int[][] retornarNovoTabuleiroVazio() {

        // RETORNAR UM NOVO TABULEIRO VAZIO PARA COMEÇAR A APLICAR AS AÇÕES.
        return new int[largura][altura];
    }

    public static void obterNumeroDeNavios() {

        // INFORMAR O NÚMERO DE NAVIOS, E IMPEDIR QUE ELE COLOQUE UM NUMERO FORA DO LIMITE.
        quantidadeNavios = 20;
        quantidadeDeBombas = 3;

    }

    public static void instanciarContadoresDeNaviosDosPlayer() {

        naviosPlayer1 = quantidadeNavios;
        naviosPlayer2 = quantidadeNavios;
    }

    public static void colocandoNaviosNosTabuleiroDosPlayers() {

        // CADA TABULEIRO RECEBE A QUANTIDADE DE NAVIOS INFORMADAS.
        tabuleiroplayer1 = retornarNovoTabuleiroComOsNavios();
        tabuleiroplayer2 = retornarNovoTabuleiroComOsNavios();

    }


    public static int[][] retornarNovoTabuleiroComOsNavios() {

        // AQUI ELE COMEÇA A FAZER DE MANEIRA ALEATORIA A COLOCAÇÃO DE CADA NAVIO NO SEU TABULEIRO E DO INIMIGO.
        int novoTabuleiro[][] = retornarNovoTabuleiroVazio();
        Random rand = new Random();
        int quantidadeRestanteDeNavios = quantidadeNavios;
        do {
            int x = 0;
            int y = 0;
            for (int i = 0; i < U10; i++) {
                if (i == 0) {
                    x = rand.nextInt(10);
                    y = rand.nextInt(6);
                }
                while (novoTabuleiro[x][y] != VAZIO) {
                    x = rand.nextInt(10);
                }
                novoTabuleiro[x][y] = NAVIO4;
                y++;
                quantidadeRestanteDeNavios--;
            }
            for (int i = 0; i < G30; i++) {
                if (i == 0) {
                    x = rand.nextInt(10);
                    y = rand.nextInt(7);
                }
                while (novoTabuleiro[x][y] != VAZIO) {
                    x = rand.nextInt(10);
                }
                novoTabuleiro[x][y] = NAVIO3;
                y++;
                quantidadeRestanteDeNavios--;
            }
            for (int i = 0; i < G31; i++) {
                if (i == 0) {
                    x = rand.nextInt(10);
                    y = rand.nextInt(7);
                }
                while (novoTabuleiro[x][y] != VAZIO) {
                    x = rand.nextInt(10);
                }
                novoTabuleiro[x][y] = NAVIO3;
                y++;
                quantidadeRestanteDeNavios--;
            }
            for (int i = 0; i < P40; i++) {
                if (i == 0) {
                    x = rand.nextInt(10);
                    y = rand.nextInt(8);
                }
                while (novoTabuleiro[x][y] != VAZIO) {
                    x = rand.nextInt(10);
                }
                novoTabuleiro[x][y] = NAVIO2;
                y++;
                quantidadeRestanteDeNavios--;
            }
            for (int i = 0; i < P41; i++) {
                if (i == 0) {
                    x = rand.nextInt(10);
                    y = rand.nextInt(8);
                }
                while (novoTabuleiro[x][y] != VAZIO) {
                    x = rand.nextInt(10);
                }
                novoTabuleiro[x][y] = NAVIO2;
                y++;
                quantidadeRestanteDeNavios--;
            }
            for (int i = 0; i < P42; i++) {
                if (i == 0) {
                    x = rand.nextInt(10);
                    y = rand.nextInt(8);
                }
                while (novoTabuleiro[x][y] != VAZIO) {
                    x = rand.nextInt(10);
                }
                novoTabuleiro[x][y] = NAVIO2;
                y++;
                quantidadeRestanteDeNavios--;
            }
            for (int i = 0; i < P43; i++) {
                if (i == 0) {
                    x = rand.nextInt(10);
                    y = rand.nextInt(8);
                }
                while (novoTabuleiro[x][y] != VAZIO) {
                    x = rand.nextInt(10);
                }
                novoTabuleiro[x][y] = NAVIO2;
                y++;
                quantidadeRestanteDeNavios--;
            }
            for (int i = 0; i < P10; i++) {
                if (i == 0) {
                    x = rand.nextInt(10);
                    y = rand.nextInt(9);
                }
                while (novoTabuleiro[x][y] != VAZIO) {
                    x = rand.nextInt(10);
                }
                novoTabuleiro[x][y] = NAVIO;
                y++;
                quantidadeRestanteDeNavios--;
            }
            for (int i = 0; i < P11; i++) {
                if (i == 0) {
                    x = rand.nextInt(10);
                    y = rand.nextInt(9);
                }
                while (novoTabuleiro[x][y] != VAZIO) {
                    x = rand.nextInt(10);
                }
                novoTabuleiro[x][y] = NAVIO;
                y++;
                quantidadeRestanteDeNavios--;
            }
        } while (quantidadeRestanteDeNavios > 0);
        for (int i = 0; i < quantidadeDeBombas; i++) {
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            while (novoTabuleiro[x][y] != VAZIO) {
                x = rand.nextInt(10);
                y = rand.nextInt(10);
            }
            novoTabuleiro[x][y] = BOMBA;
            quantidadeRestanteDeBombas--;
        }
        return novoTabuleiro;
    }

    public static void exibirNumerosDasColunasTabuladamenteDoTabuleiro() {
        int numeroDaColuna = 1;
        String numerosDoTabuleiro;

        // TABULAR CORRETAMENTE OS TABULEIROS
        //2 espaços a mais < 10.
        //2 esp a mais no > 10

        if (largura < 10) {
            numerosDoTabuleiro = "   |";
        } else {
            numerosDoTabuleiro = "   |";
        }
        for (int i = 0; i < largura; i++) {
            if (i < 9) {
                numerosDoTabuleiro += "0" + (numeroDaColuna++) + ("|");
            } else {
                numerosDoTabuleiro += (numeroDaColuna++) + ("|");
            }
        }
        System.out.println(numerosDoTabuleiro);
    }

    public static void exibirTabuleiroTabulado(String nomeDoPlayer, int[][] tabuleiro, boolean seuTabuleiro) {

        // exibirTabuleiroTabulado exibe colunas e linhas tabuladas.
        System.out.println("|------ " + nomeDoPlayer + " -----|");
        exibirNumerosDasColunasTabuladamenteDoTabuleiro();
        String linhaDoTabuleiro = "";
        char letraDaLinha = 65;
        for (int[] linha : tabuleiro) {
            linhaDoTabuleiro = (letraDaLinha++) + "  |";
            for (int coluna : linha) {
                switch (coluna) {
                    case VAZIO: // Vazio ou sem açaõ.
                        linhaDoTabuleiro += "  |";
                        break;
                    case NAVIO: // Navio.
                        if (seuTabuleiro) {
                            linhaDoTabuleiro += "N |";
                            break;
                        } else {
                            linhaDoTabuleiro += "  |";
                            break;
                        }
                    case NAVIO2: // Navio.
                        if (seuTabuleiro) {
                            linhaDoTabuleiro += "N2|";
                            break;
                        } else {
                            linhaDoTabuleiro += "  |";
                            break;
                        }
                    case NAVIO3: // Navio.
                        if (seuTabuleiro) {
                            linhaDoTabuleiro += "N3|";
                            break;
                        } else {
                            linhaDoTabuleiro += "  |";
                            break;
                        }
                    case NAVIO4: // Navio.
                        if (seuTabuleiro) {
                            linhaDoTabuleiro += "N4|";
                            break;
                        } else {
                            linhaDoTabuleiro += "  |";
                            break;
                        }
                    case BOMBA: // Bomba.
                        if (seuTabuleiro) {
                            linhaDoTabuleiro += "BB|";
                            break;
                        } else {
                            linhaDoTabuleiro += "  |";
                            break;
                        }
                    case ERROU_TIRO: // Erro.
                        linhaDoTabuleiro += "  |";
                        break;

                    case ACERTOU_TIRO: // Acertou.
                        linhaDoTabuleiro += "D |";
                        break;
                    case ACERTOU_TIRO_NA_BOMBA: // Acertou.
                        linhaDoTabuleiro += "BB|";
                        break;
                }
            }
            System.out.println(linhaDoTabuleiro);
        }
    }

    public static void inserirNomeDosPlayers() {

        // PEDIR PARA INFORMAR O NOME DOS PLAYERS PARA IMPRIMIR NO TABULEIRO.
        System.out.printf("   Insira o seu sobrenome: ");
        nomePlayer1 = sc.nextLine();
        nomePlayer1 = sc.nextLine();
        nomePlayer1 = patente.concat(nomePlayer1);
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ie) {

            }
            System.out.printf("   Continências " + nomePlayer1 + " ...\n");
        }
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ie) {

            }
            System.out.printf("   Nessa versão você irá jogar contra o " + nomePlayer2 + " ...\n");
        }
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ie) {

            }
        }
        System.out.printf("   Eu lhe desejo MUITA SORTE ...\n");
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ie) {

            }
        }
        nomePlayer2 = nomePlayer2.substring(9);
        System.out.printf("   Pois o" + nomePlayer2 + " foi o ÚNICO que AGUENTOU e CONSEGUIU ficar até o final na MARINHA ...\n");
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ie) {

            }
        }
        nomePlayer2 = "Almirante".concat(nomePlayer2);
        System.out.printf("   Diferente dos outros MEROS MARINHEIROS ...\n");
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ie) {

            }
        }
        System.out.printf("   E conseguiu atingir a tão almejada patente de ALMIRANTE na MARINHA .\n");
        System.out.println(" |=====================================|");
    }


    public static void exibirTabuleiroDosPlayers() {

        // CRIADO PARA EXIBIR O TABULEIRO DE CADA PLAYER, CASO SEJA O SEU TABULEIRO VOCÊ PODE VER OS NAVIOS.
        // CASO NÃO, VOCÊ NÃO PODERÁ VER OS NAVIOS DO INIMIGO.
        exibirTabuleiroTabulado(nomePlayer1, tabuleiroplayer1, true);
        exibirTabuleiroTabulado(nomePlayer2, tabuleiroplayer2, false);
    }

    public static boolean validarPosiçoesInseridasPeloPlayer(int[] posiçoes) {

        // VALIDAR O SEU TIRO, VER SE É POSSIVEL ATIRAR EM TAL POSIÇÃO
        boolean retorno = true;
        if (posiçoes[0] > altura - 1) {
            retorno = false;
            // Erro.
            System.out.println("A posição das LETRAS não pode ser maior que " + (char) (altura + 64));
            // -64 pois é antes do ''A'' maiusculo.
        }

        if (posiçoes[1] > largura) {
            retorno = false;
            // Erro.
            System.out.println("A posição dos NUMEROS não pode ser maior que " + largura);
        }

        return retorno;
    }

    public static String receberValorDigitadoPeloPlayer() {

        // RECEBE O VALOR DIGITADO PELA PESSOA PARA COMEÇAR A FAZER A AÇÃO.
        System.out.println();
        System.out.printf("Informe a posição do seu tiro : ");
        return sc.next();
    }

    public static boolean validarTiroDoPlayer(String tiroDoPlayer) {

        // VERITIFCAÇÕES.
        // {?} Significa ENTÃO.
        // {:} Significa CASO NÃO.
        char letras[] = new char[altura];  //Criando um vetor de chars com o total de letras que ele pode usar.
        char inicio = 'a';   // Primeiro letra, usada como paramentro para alimentar o vetor.
        int cont = 0;  // variavel que permite percorrer o alfabeto dentro do loop.

        for (int i = 0; i < altura; i++) {
            letras[i] = (char) (inicio + cont);  // Vetor contando todas as letras jogaveis.
            cont++;
        }

        String letra = tiroDoPlayer.toLowerCase().substring(0, 1);  //Diminuindo a caixa e pegando apenas a letra.
        int numero = Integer.parseInt(tiroDoPlayer.substring(1));  //Transformando em inteiro e pegando o numero.


        boolean isValido[] = new boolean[2];

        for (int i = 0; i < 2; i++) {    //Inicializando como false, caso encontre o caso true no loop seguinte
            isValido[i] = false;         // ele vira true.
        }

        for (int i = 0; i < altura; i++) {          //Validando ataque na altura...
            if (letra.charAt(0) == letras[i]) {
                isValido[0] = true;
                break;
            }
        }

        if (numero <= largura) {             //Validando ataque na largura...
            isValido[1] = true;
        }

        if (isValido[0] && isValido[1]) {
            return true;         //Caso os dois testes deem verdade..
        } else {
            return false;        //Caso algum teste de errado...
        }
    }

    public static int[] retornarPosiçoesDigitadasPeloPlayer(String tiroDoPlayer) {

        String tiro = tiroDoPlayer.toLowerCase();
        int[] retorno = new int[2];
        retorno[POSIÇAO_X] = tiro.charAt(0) - 97;
        // retorno[0] = int posiçãoAltura = tiro.charAt(0) - 97;
        retorno[POSIÇAO_Y] = Integer.parseInt(tiro.substring(1)) - 1;
        // retorno[1] = int posiçãoLargura = Integer.parseInt(tiro.substring(1)) - 1;
        // -1 pois toda contação começa por 0 então com o -1 sairá corretamente, por exemplo (4 iria sair como 5, mas como o -1 irá sair 4).
        return retorno;
    }

    //PODE COLOCAR TANTO JOGADOR UM COMO JOGADOR DOIS.
    public static void inserirValoresDaAçaoNoTabuleiro(int[] posiçoes, int numeroDoPlayer) {

        if (numeroDoPlayer == 1) {


            if (tabuleiroplayer2[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == NAVIO || tabuleiroplayer2[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == NAVIO2 || tabuleiroplayer2[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == NAVIO3 || tabuleiroplayer2[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == NAVIO4 || tabuleiroplayer2[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == BOMBA) {
                if (tabuleiroplayer2[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == BOMBA) {
                    tabuleiroplayer2[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] = ACERTOU_TIRO_NA_BOMBA;
                    jogoAtivo = false;
                    win = false;
                    patentes = 1;
                    exibirTabuleiroDosPlayers();
                    System.out.println();
                    System.out.println("O " + nomePlayer1 + " ACERTOU UMA BOMBA!.");
                    System.out.println("O " + nomePlayer2 + " COMO DE COSTUME GANHOU O JOGO!.");
                    System.out.println();
                    System.out.println("|--------------------------------|");
                    System.out.println("|***********FIM DE JOGO**********|");
                    System.out.println("|--------------------------------|");
                } else {
                    tabuleiroplayer2[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] = ACERTOU_TIRO;
                    naviosPlayer2--;
                    System.out.println();
                    System.out.println("O " + nomePlayer1 + " ACERTOU o tiro!.");
                }
            } else {
                tabuleiroplayer2[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] = ERROU_TIRO;
                System.out.println();
                System.out.println("O " + nomePlayer1 + " ERROU o tiro!.");
            }
        } else {

            if (tabuleiroplayer1[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == NAVIO || tabuleiroplayer1[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == NAVIO2 || tabuleiroplayer1[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == NAVIO3 || tabuleiroplayer1[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == NAVIO4 || tabuleiroplayer1[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == BOMBA) {
                if (tabuleiroplayer1[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] == BOMBA) {
                    tabuleiroplayer1[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] = ACERTOU_TIRO_NA_BOMBA;
                    jogoAtivo = false;
                    win = true;
                    exibirTabuleiroDosPlayers();
                    System.out.println();
                    System.out.println("O " + nomePlayer2 + " ACERTOU UMA BOMBA!.");
                    System.out.println("O " + nomePlayer1 + " MILAGROSAMENTE GANHOU O JOGO!.");
                    System.out.println();
                    System.out.println("|--------------------------------|");
                    System.out.println("|***********FIM DE JOGO**********|");
                    System.out.println("|--------------------------------|");
                } else {
                    tabuleiroplayer1[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] = ACERTOU_TIRO;
                    naviosPlayer1--;
                    System.out.println("O " + nomePlayer2 + " ACERTOU o tiro!.");
                }
            } else {
                tabuleiroplayer1[posiçoes[POSIÇAO_X]][posiçoes[POSIÇAO_Y]] = ERROU_TIRO;
                System.out.println("O " + nomePlayer2 + " ERROU o tiro!.");
            }
        }
    }

    public static boolean açaoDoPlayer() {

        boolean açaoValida = true;
        String tiroDoPlayer = receberValorDigitadoPeloPlayer();

        // VERITIFCAÇÕES.
        // {?} Significa ENTÃO.
        // {:} Significa CASO NÃO.

        if (validarTiroDoPlayer(tiroDoPlayer)) {
            int[] posiçoes = retornarPosiçoesDigitadasPeloPlayer(tiroDoPlayer);
            // int posiçãoAltura = tiro.charAt(0) - 97;
            // -97 pois o 97 é a posição ''a'' na tabela ASCII.
            // posiçãoAltura = LETRAS = ALGURA = X;
            // int posiçãoLargura = Integer.parseInt(tiro.substring(1)) - 1;
            // -1 pois toda contação começa por 0 então com o -1 sairá corretamente, por exemplo (4 iria sair como 5, mas como o -1 irá sair 4).
            // posiçãoLargura = NUMEROS = LARGURA = Y;
            // -----------------------------------------
            // VERIFICAÇÃO DAS POSIÇÕES;
            if (validarPosiçoesInseridasPeloPlayer(posiçoes)) {
                inserirValoresDaAçaoNoTabuleiro(posiçoes, 1);

            } else {
                açaoValida = false;
            }
        } else {
            System.out.println("Posição inválida");
            açaoValida = false;
        }
        return açaoValida;
    }

    public static void açaoDoComputador() {


        int posiçoes[] = retornarJogadaDoComputador();
        inserirValoresDaAçaoNoTabuleiro(posiçoes, 2);
    }

    public static int[] retornarJogadaDoComputador() {

        int posiçoes[] = new int[2];

        posiçoes[POSIÇAO_X] = retornarJogadaAleatoriaDoComputador(altura);
        posiçoes[POSIÇAO_Y] = retornarJogadaAleatoriaDoComputador(largura);

        return posiçoes;
    }

    public static int retornarJogadaAleatoriaDoComputador(int limite) {

        Random jogadaDoComputador = new Random();
        int numeroGerado = jogadaDoComputador.nextInt(limite);

        return (numeroGerado == limite) ? --numeroGerado : numeroGerado;
    }


    public static void main(String[] args) {

        int opçao = 0;

        do {

            System.out.println();
            System.out.println(" |=====================================|");
            System.out.println(" |          BATALHA NAVRAL             |");
            System.out.println(" |=====================================|");
            System.out.println(" |               MENU                  |");
            System.out.println(" |                                     |");
            System.out.println(" |         ----------                  |");
            System.out.println(" |        |  OPÇÕES  |                 |");
            System.out.println(" |        |   ---    -------------|    |");
            System.out.println(" |        |  | 0 |== |  ENCERRAR  |    |");
            System.out.println(" |        |   ---    -------------|    |");
            System.out.println(" |        |          |                 |");
            System.out.println(" |        |   ---    |------------|    |");
            System.out.println(" |        |  | 1 |== | INSTRUÇÕES |    |");
            System.out.println(" |        |   ---    |------------|    |");
            System.out.println(" |        |          |                 |");
            System.out.println(" |        |   ---    |------------|    |");
            System.out.println(" |        |  | 2 |== |  PATENTES  |    |");
            System.out.println(" |        |   ---    |------------|    |");
            System.out.println(" |        |          |                 |");
            System.out.println(" |        |          |                 |");
            System.out.println(" |        |   ---    |------------|    |");
            System.out.println(" |        |  | 3 |== |    PLAY    |    |");
            System.out.println(" |        |   ---    |------------|    |");
            System.out.println(" |        |          |                 |");
            System.out.println(" |         ----------                  |");
            System.out.println(" |                                     |");
            System.out.println(" |=====================================|");
            System.out.printf("   INSIRA A OPÇÃO QUE VOCÊ DESEJA : ");
            opçao = sc.nextInt();
            System.out.println(" |=====================================|");
            switch (opçao) {

                case 1:
                    System.out.println();
                    System.out.println(" |=====================================|");
                    System.out.println(" |                                     |");
                    System.out.println(" |             INSTRUÇÕES              |");
                    System.out.println(" |                                     |");
                    System.out.println(" |Ola, bem vindo ao jogo BATALHA NAVAL.|");
                    System.out.println(" |                                     |");
                    System.out.println(" |--------------OBJETIVOS--------------|");
                    System.out.println(" |Adivinhar em que quadrados estão os  |");
                    System.out.println(" |NAVIOS do oponente, seu objetivo é   |");
                    System.out.println(" |destruir os NAVIOS do advserario.    |");
                    System.out.println(" |Ganha quem DESTRUIR TODOS os NAVIOS  |");
                    System.out.println(" |um do outro PRIMEIRO.                |");
                    System.out.println(" |-------------------------------------|");
                    System.out.println(" |*************************************|");
                    System.out.println(" |----------------NAVIOS---------------|");
                    System.out.println(" |O jogo contem um total de 9 NAVIOS   |");
                    System.out.println(" |que são os :                         |");
                    System.out.println(" |-----------------U10-----------------|");
                    System.out.println(" |TAMANHO : 4 ESPAÇOS.                 |");
                    System.out.println(" |QUANTIDADE : APENAS 1 NAVIO.         |");
                    System.out.println(" |----------G30-----------G31----------|");
                    System.out.println(" |TAMANHO : 3 ESPAÇOS.                 |");
                    System.out.println(" |QUANTIDADE : 2 NAVIOS.               |");
                    System.out.println(" |-----P40-----P41-----P42-----P43-----|");
                    System.out.println(" |TAMANHO : 2 ESPAÇOS.                 |");
                    System.out.println(" |QUANTIDADE : 4 NAVIOS.               |");
                    System.out.println(" |----------P10-----------P11----------|");
                    System.out.println(" |TAMANHO : 1 ESPAÇOS.                 |");
                    System.out.println(" |QUANTIDADE : 2 NAVIOS.               |");
                    System.out.println(" |-------------------------------------|");
                    System.out.println(" |*************************************|");
                    System.out.println(" |----------------BOMBAS---------------|");
                    System.out.println(" |Essa versão do jogo BATALHA NAVAL    |");
                    System.out.println(" |conta com a presença de BOMBAS,      |");
                    System.out.println(" |existem 3 bombas espalhadas pelo MAPA|");
                    System.out.println(" |onde caso você atire no local onde há|");
                    System.out.println(" |uma bomba inimiga, ou o inimigo atire|");
                    System.out.println(" |em um local onde há uma bomba sua,   |");
                    System.out.println(" |VOCÊ OU ELE PERDERA automaticamente o|");
                    System.out.println(" |JOGO, então muito cuidado ao tentar  |");
                    System.out.println(" |acetar os NAVIOS de seu oponente.    |");
                    System.out.println(" |-------------------------------------|");
                    System.out.println(" |*************************************|");
                    System.out.println(" |--------------COMO JOGAR-------------|");
                    System.out.println(" |Ao iniciar o jogo será exibido uma   |");
                    System.out.println(" |MATRIZ de tamanho 10x10.             |");
                    System.out.println(" |Os NAVIOS e BOMBAS serão setados     |");
                    System.out.println(" |aleatoriamente.                      |");
                    System.out.println(" |Quando você for digitar a posição    |");
                    System.out.println(" |desejada para executar o TIRO digite |");
                    System.out.println(" |PRIMEIRO a LINHA e depois a COLUNA.  |");
                    System.out.println(" |EX : [A9] ; [B5] ; [C4] ; [J10]; [H2]|");
                    System.out.println(" |Caso você ACERTE um NAVIO INIMIGO    |");
                    System.out.println(" |será mostrado a LETRA ''D''.         |");
                    System.out.println(" |Caso você ERRE um NAVIO INIMIGO      |");
                    System.out.println(" |não será exibido absolutamente NADA  |");
                    System.out.println(" |então GUARDE MUITO BEM a posição que |");
                    System.out.println(" |você acabou de atirar.               |");
                    System.out.println(" |Caso você ACERTE uma BOMBA INIMIGA   |");
                    System.out.println(" |será mostrado as LETRAS ''BB''       |");
                    System.out.println(" |e o jogo será encerrado com a sua    |");
                    System.out.println(" |DERROTA!.                            |");
                    System.out.println(" |-------------------------------------|");
                    System.out.println(" |                                     |");
                    System.out.println(" |             INSTRUÇÕES              |");
                    System.out.println(" |                                     |");
                    System.out.println(" |=====================================|");
                    System.out.println();
                    break;

                case 2:

                    System.out.println();
                    System.out.println(" |=====================================|");
                    System.out.println(" |                                     |");
                    System.out.println(" |               PATENTES              |");
                    System.out.println(" |                                     |");
                    System.out.println(" |17• ALMIRANTE.                       |");
                    System.out.println(" |16• ALMIRANTE-DE-ESQUADRA.           |");
                    System.out.println(" |15• VICE-ALMIRANTE.                  |");
                    System.out.println(" |14• CONTRA-ALMIRANTE.                |");
                    System.out.println(" |13• CAPITÃO DE MAR E GUERRA.         |");
                    System.out.println(" |12• CAPITÃO DE FRAGATA.              |");
                    System.out.println(" |11• CAPITÃO DE COVERTA.              |");
                    System.out.println(" |10• CAPITÃO-TENENTE.                 |");
                    System.out.println(" |09• PRIMEIRO TENENTE.                |");
                    System.out.println(" |08• SEGUNDO TENENTE.                 |");
                    System.out.println(" |07• GUARDA-MARINHA.                  |");
                    System.out.println(" |06• SUBOFICIAL.                      |");
                    System.out.println(" |05• PRIMEIRO-SARGENTO.               |");
                    System.out.println(" |04• SEGUNDO-SARGENTO.                |");
                    System.out.println(" |03• TERCEIRO-SARGENTO.               |");
                    System.out.println(" |02• CABO.                            |");
                    System.out.println(" |01• MARINHEIRO/SOLDADO.              |");
                    System.out.println(" |                                     |");
                    System.out.println(" |               PATENTES              |");
                    System.out.println(" |                                     |");
                    System.out.println(" |=====================================|");
                    System.out.println();
                    break;

                case 3:

                    switch (patentes) {

                        case 1:
                            if (win = true) {
                                patente = "Marinheiro ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;

                        case 2:
                            if (win == true) {
                                patente = "Cabo ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 3:
                            if (win == true) {
                                patente = "Terceiro-Sargento ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 4:
                            if (win == true) {
                                patente = "Segundo-Sargento ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 5:
                            if (win == true) {
                                patente = "Primeiro-Sargento ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 6:
                            if (win == true) {
                                patente = "Suboficial ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 7:
                            if (win == true) {
                                patente = "Guarda-Marinha ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 8:
                            if (win == true) {
                                patente = "Segundo Tenente ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 9:
                            if (win == true) {
                                patente = "Primeiro Tenente ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 10:
                            if (win == true) {
                                patente = "Capitão-Tenente ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 11:
                            if (win == true) {
                                patente = "Capitão de Coverta ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 12:
                            if (win == true) {
                                patente = "Capitão de Fragata ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 13:
                            if (win == true) {
                                patente = "Capitão de Mar e Guerra ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 14:
                            if (win == true) {
                                patente = "Contra-Almirante ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 15:
                            if (win == true) {
                                patente = "Vice-Almirante ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 16:
                            if (win == true) {
                                patente = "Almirante-de-Esquadra ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;
                        case 17:
                            if (win == true) {
                                patente = "Almirante ";
                                patentes++;
                            } else {
                                patentes = 1;
                            }
                            break;

                    }

                    inserirNomeDosPlayers();

                    tamanhoTabuleiro();

                    recebendoTamanhoDosTabuleiros();

                    obterNumeroDeNavios();

                    instanciarContadoresDeNaviosDosPlayer();

                    colocandoNaviosNosTabuleiroDosPlayers();

                    do {

                        exibirTabuleiroDosPlayers();
                        if (açaoDoPlayer()) {
                            if (naviosPlayer2 <= 0) {
                                System.out.println("O " + nomePlayer1 + " MILAGROSAMENTE GANHOU O JOGO!.");
                                System.out.println();
                                win = true;
                                break;

                            }
                            // Verificar fim do jogo
                            açaoDoComputador();
                            if (naviosPlayer1 <= 0) {
                                System.out.println("O " + nomePlayer2 + " COMO DE COSTUME GANHOU O JOGO!.");
                                System.out.println();
                                win = false;
                                break;
                            }
                            // Ação do computador
                        }


                    } while (jogoAtivo);
                    exibirTabuleiroDosPlayers();
                    break;


                case 0:
                    System.out.println("JOGO ENCERRADO.");
                    System.exit(0);
                    break;
            }


        } while (opçao != 0);
    }
}
