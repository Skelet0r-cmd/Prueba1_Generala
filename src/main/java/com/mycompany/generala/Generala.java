/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author Marcelo
 */
public class Generala {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        int total = 0;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
    }

    // '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
    //es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
    public static int generala(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        for (int i = 0; i != 6; i++) {
            if (counts[i] == 5) {
                return 50;
            }
        }
        return 0;
    }

    //Suma algunos los elementos de un array.
    public static int sumSelectedElements(int objetivo, int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[5];
        tallies[0] = d1;
        tallies[1] = d2;
        tallies[2] = d3;
        tallies[3] = d4;
        tallies[4] = d5;
        int sum = 0;
        for (int s : tallies) {
            if (s == objetivo) {
                sum = sum + s;
            }
        }
        return sum;
    }

    //Se implementa en el cuerpo los metodos "sumAllElements" y "compareEquality".
    //A todos los ones,twos y threes.
    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int sum = sumSelectedElements(1, d1, d2, d3, d4, d5);
        return sum;
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int sum = sumSelectedElements(2, d1, d2, d3, d4, d5);
        return sum;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int sum = sumSelectedElements(3, d1, d2, d3, d4, d5);
        return sum;
    }

    protected int[] dice;

    public Generala(int d1, int d2, int d3, int d4, int _5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    //Método de suma para fours and fives.
    public static int sumOfSelectedNumbers(int[] dice, int objetivo) {
        int sum = 0;
        for (int s : dice) {
            if (s == objetivo) {
                sum = (sum + s);
            }
        }
        return sum;
    }

    public int fours() {
        int sum = sumOfSelectedNumbers(dice, 4);
        return sum;
    }

    public int fives() {
        int sum = sumOfSelectedNumbers(dice, 5);
        return sum;
    }

    public int sixes() {
        int sum = 0;
        for (int at = 0; at < dice.length; at++) {
            if (dice[at] == 6) {
                sum = sum + 6;
            }
        }
        return sum;
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int at;
        for (at = 0; at != 6; at++) {
            if (counts[6 - at - 1] >= 2) {
                return (6 - at) * 2;
            }
        }
        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1) {
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        }
        if (n == 2) {
            return score * 2;
        } else {
            return 0;
        }
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[_1 - 1]++;
        tallies[_2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] t;
        t = new int[6];
        t[d1 - 1]++;
        t[d2 - 1]++;
        t[d3 - 1]++;
        t[d4 - 1]++;
        t[d5 - 1]++;
        for (int i = 0; i < 6; i++) {
            if (t[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    //Se implementa en el cuerpo el método "searhObjectRepeated" y "searchNumberSpecific"
    //Se verifica que ambos cumplan con los parametros.
    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        if (searchNumberSpecific(6, d1, d2, d3, d4, d5) == false
                && searhObjectRepeated(d1, d2, d3, d4, d5) == false) {
            return 15;
        }
        return 0;
    }

    //Se implementa en el cuerpo el método "searhObjectRepeated" y "searchNumberSpecific"
    //Y se evalúa su estado, si alguno de estos contradice 
    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        if (searchNumberSpecific(1, d1, d2, d3, d4, d5)) {
            if (searhObjectRepeated(d1, d2, d3, d4, d5)) {
                return 0;
            }
        }
        return 20;
    }

    //Busca un número en específico dentro de la lista en caso de que existe dicho número retorna veerdadero.
    public static boolean searchNumberSpecific(int objetivo, int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[5];
        tallies[0] = d1;
        tallies[1] = d2;
        tallies[2] = d3;
        tallies[3] = d4;
        tallies[4] = d5;
        for (int s : tallies) {
            if (s == objetivo) {
                return true;
            }
        }
        return false;
    }

    //Verificca si la lista posee algún número repetido.
    //En caso de que exista uno repetido devolverá true.
    public static boolean searhObjectRepeated(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[5];
        tallies[0] = d1;
        tallies[1] = d2;
        tallies[2] = d3;
        tallies[3] = d4;
        tallies[4] = d5;
        long cont = Arrays.stream(tallies)
                .distinct()
                .count();
        if (cont == 5) {
            return false;
        }
        return true;
    }

    public static boolean checkFullHouse(int d1, int d2, int d3, int d4, int d5) {

        return false;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }
        }

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }
        }

        if (_2 && _3) {
            return _2_at * 2 + _3_at * 3;
        } else {
            return 0;
        }
    }
}
