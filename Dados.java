import java.util.Scanner;

public class Dados {


            static String[] jugadores;


            static int[][] tablaPuntuaciones;


            static int[] lanzamiento() {

                int[] resultados = new int[3];

                resultados[0] = (int)(Math.random()*6 + 1);
                resultados[1] = (int)(Math.random()*6 + 1);
                resultados[2] = (int)(Math.random()*6 + 1); 

                return resultados;
            }


            public static void main(String[] args) {

                Scanner teclado = new Scanner(System.in);
                System.out.print("¿Cuantos jugadores serán?: ");
                int n = Integer.parseInt(teclado.nextLine());

                System.out.print("Cauntas veces quieres tirar el dado?:");
                int m = Integer.parseInt(teclado.nextLine());


                jugadores = new String[n];
                tablaPuntuaciones = new int[n][m];


                System.out.println("\nIntroduzca nombres.");
                for (int i = 0; i < n; i++) {
                    System.out.printf("Jugador #%d: ", (i+1));
                    jugadores[i] = teclado.nextLine();
                }

                boolean hayGanador = false;

                for (int i = 0; i < m && !hayGanador; i++) {
                    System.out.print("\n\t\t\tTURNO #" + (i+1));


                    for (int j = 0; j < jugadores.length && !hayGanador; j++) {

                        System.out.printf("\n\nLanza el jugador %s --> ", jugadores[j]);

                        int[] dados = lanzamiento();
                        System.out.printf("Dado1: %d\tDado2: %d\tDado3: %d", dados[0], dados[1], dados[2]);

                        if (dados[0] == dados[1] && dados[1] == dados[2]) {
                            System.out.println("\nHa ganado el Jugador " + jugadores[j]);
                            hayGanador = true; //Esto pone fin al juego
                        }
                        else {
                            tablaPuntuaciones[j][i] = dados[0] + dados[1] + dados[2];
                        }

                    }
                    System.out.println("\n\n\t\tPULSE INTRO PARA CONTINUAR");
                    teclado.nextLine();

                }

                teclado.close();
                System.out.println("\n\n\t\t\tFIN DE PROGRAMA");

            }

        }
