
package RedNeuronal;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public void xor(){
        
    }
    public static void main(String[] args) {
        int errores=0;
        int intentos=0;
        double MOMENTO = 0.5;
        double RAZON_APRENDIZAJE = 0.2;
        int inputs = 2;
        int[] array_ocultas = {4};
        int outputs = 1;
        Red red = new Red(inputs,array_ocultas,outputs,RAZON_APRENDIZAJE,MOMENTO);
        Scanner lector = new Scanner(System.in);
        int opc;
        int mod = 0;
        do{
            System.out.println("1) XOR");
            System.out.println("2) NAND");
            System.out.println("3) NOR");
            System.out.println("0)  Salir");
            System.out.print("opcion ->");
            opc = lector.nextInt();
            
            if (opc != 0) {
                System.out.println("2.- Empezar");
                mod = lector.nextInt();
            }
            switch (opc) {
                case 1:
                        //Tabla XOR
                    double entradas[][] = {{0,0},{0,1},{1,0},{1,1}}; //Entradas
                    double salidas[] = {0.0, 1.0, 1.0, 0.0}; //Salidas esperadas
                    //Simular entrenamiento
                    for(int etapa =0 ; etapa<8000; etapa++){ //Se itera 'n' número de veces
                        for(int i=0; i<4; i++) {
                            ArrayList<Double> ob= new ArrayList<Double>(); //Entradas
                                for(int j=0;j<2;j++) {
                                //Se colocan las entradas en la lista que se le pasa como parametro a la red
                                    ob.add(entradas[i][j]);
                                }

                                double[] arr = red.epoca(ob); //Valores retornados
                                for(int j = 0; j<arr.length; j++) {
                                    double error = salidas[i]-arr[j];

                    System.out.println("Ciclo "+etapa+" Epoca: "+i+" Entrada:"+entradas[i][0]+
                    " "+entradas[i][1]+" Salida :"+arr[j]+ " Esperado: "+ salidas[i]+ " ERROR: "+error);
                                    if(error>=0.1)
                                        errores++;
                                    intentos++;
                                    double[] salidaEsperada = new double[1];
                                    salidaEsperada[0] = salidas[i];
                                    red.calibrar(salidaEsperada);
                                }
                            }
                        }
                        System.out.println("\n\nERRORES TOTALES:"+errores+", intentos:"+intentos*entradas.length );
                    break;
                case 2:
                        //Tabla NAND
                    double entradas1[][] = {{0,0},{0,1},{1,0},{1,1}}; //Entradas
                    double salidas1[] = {1.0, 1.0, 1.0, 0.0}; //Salidas esperadas
                    //Simular entrenamiento
                    for(int etapa =0 ; etapa<8000; etapa++){ //Se itera 'n' número de veces
                        for(int i=0; i<4; i++) {
                            ArrayList<Double> ob= new ArrayList<Double>(); //Entradas
                                for(int j=0;j<2;j++) {
                                //Se colocan las entradas en la lista que se le pasa como parametro a la red
                                    ob.add(entradas1[i][j]);
                                }

                                double[] arr = red.epoca(ob); //Valores retornados
                                for(int j = 0; j<arr.length; j++) {
                                    double error = salidas1[i]-arr[j];

                    System.out.println("Ciclo "+etapa+" Epoca: "+i+" Entrada:"+entradas1[i][0]+
                    " "+entradas1[i][1]+" Salida :"+arr[j]+ " Esperado: "+ salidas1[i]+ " ERROR: "+error);
                                    if(error>=0.1)
                                        errores++;
                                    intentos++;
                                    double[] salidaEsperada = new double[1];
                                    salidaEsperada[0] = salidas1[i];
                                    red.calibrar(salidaEsperada);
                                }
                            }
                        }
                        System.out.println("\n\nERRORES TOTALES:"+errores+", intentos:"+intentos*entradas1.length );
                    break;
                case 3:
                        //Tabla NOR
                    double entradas2[][] = {{0,0},{0,1},{1,0},{1,1}}; //Entradas
                    double salidas2[] = {1.0, 0.0, 0.0, 0.0}; //Salidas esperadas
                    //Simular entrenamiento
                    for(int etapa =0 ; etapa<8000; etapa++){ //Se itera 'n' número de veces
                        for(int i=0; i<4; i++) {
                            ArrayList<Double> ob= new ArrayList<Double>(); //Entradas
                                for(int j=0;j<2;j++) {
                                //Se colocan las entradas en la lista que se le pasa como parametro a la red
                                    ob.add(entradas2[i][j]);
                                }

                                double[] arr = red.epoca(ob); //Valores retornados
                                for(int j = 0; j<arr.length; j++) {
                                    double error = salidas2[i]-arr[j];

                    System.out.println("Ciclo "+etapa+" Epoca: "+i+" Entrada:"+entradas2[i][0]+
                    " "+entradas2[i][1]+" Salida :"+arr[j]+ " Esperado: "+ salidas2[i]+ " ERROR: "+error);
                                    if(error>=0.1)
                                        errores++;
                                    intentos++;
                                    double[] salidaEsperada = new double[1];
                                    salidaEsperada[0] = salidas2[i];
                                    red.calibrar(salidaEsperada);
                                }
                            }
                        }
                        System.out.println("\n\nERRORES TOTALES:"+errores+", intentos:"+intentos*entradas2.length );
                    break;
                default:
                    System.out.println("Opcion no valida");
                }
            } while (opc != 0);
        
        }
    }   

