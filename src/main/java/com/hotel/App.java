package com.hotel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Gestió de reserves d'un hotel.
 */
public class App {

    // --------- CONSTANTS I VARIABLES GLOBALS ---------

    // Tipus d'habitació
    public static final String TIPUS_ESTANDARD = "Estàndard";
    public static final String TIPUS_SUITE = "Suite";
    public static final String TIPUS_DELUXE = "Deluxe";

    // Serveis addicionals
    public static final String SERVEI_ESMORZAR = "Esmorzar";
    public static final String SERVEI_GIMNAS = "Gimnàs";
    public static final String SERVEI_SPA = "Spa";
    public static final String SERVEI_PISCINA = "Piscina";

    // Capacitat inicial
    public static final int CAPACITAT_ESTANDARD = 30;
    public static final int CAPACITAT_SUITE = 20;
    public static final int CAPACITAT_DELUXE = 10;

    // IVA
    public static final float IVA = 0.21f;

    // Scanner únic
    public static Scanner sc = new Scanner(System.in);

    // HashMaps de consulta
    public static HashMap<String, Float> preusHabitacions = new HashMap<String, Float>();
    public static HashMap<String, Integer> capacitatInicial = new HashMap<String, Integer>();
    public static HashMap<String, Float> preusServeis = new HashMap<String, Float>();

    // HashMaps dinàmics
    public static HashMap<String, Integer> disponibilitatHabitacions = new HashMap<String, Integer>();
    public static HashMap<Integer, ArrayList<String>> reserves = new HashMap<Integer, ArrayList<String>>();//importante

    // Generador de nombres aleatoris per als codis de reserva
    public static Random random = new Random();

    // --------- MÈTODE MAIN ---------

    /**
     * Mètode principal. Mostra el menú en un bucle i gestiona l'opció triada
     * fins que l'usuari decideix eixir.
     */
    public static void main(String[] args) {
        inicialitzarPreus();

        int opcio = 0;
        do {
            mostrarMenu();
            opcio = llegirEnter("Seleccione una opció: ");
            gestionarOpcio(opcio);
        } while (opcio != 6);

        System.out.println("Eixint del sistema... Gràcies per utilitzar el gestor de reserves!");
    }

    // --------- MÈTODES DEMANATS ---------

    /**
     * Configura els preus de les habitacions, serveis addicionals i
     * les capacitats inicials en els HashMaps corresponents.
     */
    public static void inicialitzarPreus() {
        // Preus habitacions
        preusHabitacions.put(TIPUS_ESTANDARD, 50f);
        preusHabitacions.put(TIPUS_SUITE, 100f);
        preusHabitacions.put(TIPUS_DELUXE, 150f);

        // Capacitats inicials
        capacitatInicial.put(TIPUS_ESTANDARD, CAPACITAT_ESTANDARD);
        capacitatInicial.put(TIPUS_SUITE, CAPACITAT_SUITE);
        capacitatInicial.put(TIPUS_DELUXE, CAPACITAT_DELUXE);

        // Disponibilitat inicial (comença igual que la capacitat)
        disponibilitatHabitacions.put(TIPUS_ESTANDARD, CAPACITAT_ESTANDARD);
        disponibilitatHabitacions.put(TIPUS_SUITE, CAPACITAT_SUITE);
        disponibilitatHabitacions.put(TIPUS_DELUXE, CAPACITAT_DELUXE);

        // Preus serveis
        preusServeis.put(SERVEI_ESMORZAR, 10f);
        preusServeis.put(SERVEI_GIMNAS, 15f);
        preusServeis.put(SERVEI_SPA, 20f);
        preusServeis.put(SERVEI_PISCINA, 25f);
    }

    /**
     * Mostra el menú principal amb les opcions disponibles per a l'usuari.
     */
    public static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Reservar una habitació");
        System.out.println("2. Alliberar una habitació");
        System.out.println("3. Consultar disponibilitat");
        System.out.println("4. Llistar reserves per tipus");
        System.out.println("5. Obtindre una reserva");
        System.out.println("6. Ixir");
    }

    /**
     * Processa l'opció seleccionada per l'usuari i crida el mètode corresponent.
     */
    public static void gestionarOpcio(int opcio) {
       //TODO:
       switch (opcio) {
        case 1:
            reservarHabitacio();
            break;
       case 2:
            alliberarHabitacio();
            break;
        case 3:
            consultarDisponibilitat();
            break;
       case 4:
            obtindreReserva();
            break;
       case 5:
            obtindreReservaPerTipus();
            break;
                      
       default:
            System.out.println("Opció incorrecta.");
            break;
       }
    }

    /**
     * Gestiona tot el procés de reserva: selecció del tipus d'habitació,
     * serveis addicionals, càlcul del preu total i generació del codi de reserva.
     */
    public static void reservarHabitacio() {
        System.out.println("\n===== RESERVAR HABITACIÓ =====");
        //TODO:
        
    }

    /**
     * Pregunta a l'usuari un tipus d'habitació en format numèric i
     * retorna el nom del tipus.
     */
    public static String seleccionarTipusHabitacio() {
        //TODO:
        int opcio = llegirEnter("Seleccione tipo de habitación: "); // Pido al usuario que elija una opción numérica 1, 2 o 3

        switch (opcio) {//verificare segun el numero introducido
            case 1:
               return TIPUS_ESTANDARD;
            case 2:
                return TIPUS_SUITE;
            case 3:
                return TIPUS_DELUXE;
            default:
                return null;
    }
    }

    /**
     * Mostra la disponibilitat i el preu de cada tipus d'habitació,
     * demana a l'usuari un tipus i només el retorna si encara hi ha
     * habitacions disponibles. En cas contrari, retorna null.
     */
    public static String seleccionarTipusHabitacioDisponible() {
        System.out.println("\nTipus d'habitació disponibles:");
        //TODO:
        
    int disponiblesEstandard = disponibilitatHabitacions.get(TIPUS_ESTANDARD);
    float preuEstandard = preusHabitacions.get(TIPUS_ESTANDARD);
    //para mostrar el precio como esta en la salida de ejemplo hago un casting ()
    System.out.println("1. Estàndard - " + disponiblesEstandard + " disponibles - " + (int)preuEstandard + "€");
    
    int disponiblesSuite = disponibilitatHabitacions.get(TIPUS_SUITE);
    float preuSuite = preusHabitacions.get(TIPUS_SUITE);
    System.out.println("2. Suite - " + disponiblesSuite + " disponibles - " + (int)preuSuite + "€");
    
    int disponiblesDeluxe = disponibilitatHabitacions.get(TIPUS_DELUXE);
    float preuDeluxe = preusHabitacions.get(TIPUS_DELUXE);
    System.out.println("3. Deluxe - " + disponiblesDeluxe + " disponibles - " + (int)preuDeluxe + "€");
    
    // Pido al usuario que seleccione 
    String tipusSeleccionat = seleccionarTipusHabitacio();
    
    // Si seleccionó algo válido, verifico disponibilidad
    if (tipusSeleccionat != null) {
        int disponibles = disponibilitatHabitacions.get(tipusSeleccionat);
        
        if (disponibles > 0) {
            return tipusSeleccionat;
        } else {
            return null;
        }
    }
    
    return null;
    }

    /**
     * Permet triar serveis addicionals (entre 0 i 4, sense repetir) i
     * els retorna en un ArrayList de String.
     */
  
public static ArrayList<String> seleccionarServeis() {
    // Creo un ArrayList donde guardare los servicios 
    ArrayList<String> serveisSeleccionats = new ArrayList<String>();
    
    
    System.out.println("\nServeis addicionals (0-4):");
    System.out.println("0. Finalitzar");
    System.out.println("1. Esmorzar (10€)");
    System.out.println("2. Gimnàs (15€)");
    System.out.println("3. Spa (20€)");
    System.out.println("4. Piscina (25€)");
    
    // Variable para controlar si el usuario quiere seguir añadiendo servicios
    String resposta = "s";
    
   
    while (resposta.equals("s") && serveisSeleccionats.size() < 4) {
        
        
        System.out.print("¿Vols afegir un servei? (s/n): ");
        resposta = sc.next();
        
        if (resposta.equals("s")) {
            int opcio = llegirEnter("Selecciona servei: ");
            
            // Verifico qué servicio eligió
            String serveiElegit = null;
            
            if (opcio == 1) {
                serveiElegit = SERVEI_ESMORZAR;
            } else if (opcio == 2) {
                serveiElegit = SERVEI_GIMNAS;
            } else if (opcio == 3) {
                serveiElegit = SERVEI_SPA;
            } else if (opcio == 4) {
                serveiElegit = SERVEI_PISCINA;
            }
            
            // Si eligió un servicio válido
            if (serveiElegit != null) {// Verifico si ya está en la lista para no repetir
                
                boolean esta = false;
                for (int i = 0; i < serveisSeleccionats.size(); i++) {
                    if (serveisSeleccionats.get(i).equals(serveiElegit)) {
                        esta = true;
                    }
                }
                
                // Si no está repetido, lo añado
                if (!esta) {
                    serveisSeleccionats.add(serveiElegit);
                    System.out.println("Servei afegit: " + serveiElegit);
                } else {
                    System.out.println("Aquest servei ja està seleccionat.");
                }
            }
        }
    }
    
    return serveisSeleccionats;
}

    /**
     * Calcula i retorna el cost total de la reserva, incloent l'habitació,
     * els serveis seleccionats i l'IVA.
     */
    public static float calcularPreuTotal(String tipusHabitacio, ArrayList<String> serveisSeleccionats) {
        //TODO:
        // Obtengo el precio base de la habitación según el tipo elegido
        float preuHabitacio = preusHabitacions.get(tipusHabitacio);
        float subtotal = preuHabitacio;// mi subtotal empieza con el precio de la habitación
         // Recorremos la lista de servicios seleccionados
        for (int i = 0; i < serveisSeleccionats.size(); i++) {
            String servei = serveisSeleccionats.get(i);
            float preuServei = preusServeis.get(servei);
            subtotal = subtotal + preuServei;
        }

        float iva = subtotal * IVA;//precio iva * por subtotal
        float total = subtotal + iva; //precio total

        return total;
    }

    /**
     * Genera i retorna un codi de reserva únic de tres xifres
     * (entre 100 i 999) que no estiga repetit.
     */
  
    public static int generarCodiReserva() {
    // Variable para guardar el código generado
        int codigo = 0;
        boolean existe = true;
    
        while (existe) {
            codigo = random.nextInt(900) + 100;// Genero un número aleatorio entre 100 y 999
        
        // Verifico si este código ya existe en el HashMap de reservas
            if (reserves.containsKey(codigo)) {
                existe = true; 
            } else {
                existe = false; 
            }
    }
    
    return codigo;
}

    /**
     * Permet alliberar una habitació utilitzant el codi de reserva
     * i actualitza la disponibilitat.
     */
    public static void alliberarHabitacio() {
        System.out.println("\n===== ALLIBERAR HABITACIÓ =====");
         // TODO: Demanar codi, tornar habitació i eliminar reserva
    }

    /**
     * Mostra la disponibilitat actual de les habitacions (lliures i ocupades).
     */
    public static void consultarDisponibilitat() {
        // TODO: Mostrar lliures i ocupades

        System.out.println("\n===== DISPONIBILITAT D'HABITACIONS =====");// Imprimo el título para que el usuario sepa qué opción está viendo
            
            System.out.println("Tipo\t\tLibres\tOcupadas");// Cabecera de la tabla: tipo de habitación, libres y ocupadas

            // Muestro la disponibilidad del tipo Estándar, suit,deluxe
            mostrarDisponibilitatTipus(TIPUS_ESTANDARD);
            mostrarDisponibilitatTipus(TIPUS_SUITE);
            mostrarDisponibilitatTipus(TIPUS_DELUXE);

    }

    /**
     * Funció recursiva. Mostra les dades de totes les reserves
     * associades a un tipus d'habitació.
     */
    public static void llistarReservesPerTipus(int[] codis, String tipus) {
         // TODO: Implementar recursivitat
    }

    /**
     * Permet consultar els detalls d'una reserva introduint el codi.
     */
    public static void obtindreReserva() {
        System.out.println("\n===== CONSULTAR RESERVA =====");
        // TODO: Mostrar dades d'una reserva concreta
 
    }

    /**
     * Mostra totes les reserves existents per a un tipus d'habitació
     * específic.
     */
    public static void obtindreReservaPerTipus() {
        System.out.println("\n===== CONSULTAR RESERVES PER TIPUS =====");
        // TODO: Llistar reserves per tipus
    }

    /**
     * Consulta i mostra en detall la informació d'una reserva.
     */
    public static void mostrarDadesReserva(int codi) {
       // TODO: Imprimir tota la informació d'una reserva
    }

    // --------- MÈTODES AUXILIARS (PER MILLORAR LEGIBILITAT) ---------

    /**
     * Llig un enter per teclat mostrant un missatge i gestiona possibles
     * errors d'entrada.
     */
    static int llegirEnter(String missatge) {
        int valor = 0;
        boolean correcte = false;
        while (!correcte) {
                System.out.print(missatge);
                valor = sc.nextInt();
                correcte = true;
        }
        return valor;
    }

    /**
     * Mostra per pantalla informació d'un tipus d'habitació: preu i
     * habitacions disponibles.
     */
    static void mostrarInfoTipus(String tipus) {
        int disponibles = disponibilitatHabitacions.get(tipus);
        int capacitat = capacitatInicial.get(tipus);
        float preu = preusHabitacions.get(tipus);
        System.out.println("- " + tipus + " (" + disponibles + " disponibles de " + capacitat + ") - " + preu + "€");
    }

    /**
     * Mostra la disponibilitat (lliures i ocupades) d'un tipus d'habitació.
     */
    static void mostrarDisponibilitatTipus(String tipus) {
        int lliures = disponibilitatHabitacions.get(tipus);
        int capacitat = capacitatInicial.get(tipus);
        int ocupades = capacitat - lliures;

        String etiqueta = tipus;
        if (etiqueta.length() < 8) {
            etiqueta = etiqueta + "\t"; // per a quadrar la taula
        }

        System.out.println(etiqueta + "\t" + lliures + "\t" + ocupades);
    }
}
