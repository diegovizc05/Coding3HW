package bibleCode;

public class DiscipleGrowth {

    public static void main(String[] args) {
        double population = 7.7e9; // total humans
        double disciples = 13;     // starting disciples
        double yearsPerCycle = 3;  // 3 years per training cycle
        int k = 2;                 // each disciple trains 2 new disciples

        // --- Part 1: How many years to reach entire population ---
        int cycles = 0;
        double total = disciples;

        while (total < population) {
            total *= (1 + k); // each disciple trains k new ones
            cycles++;
        }

        double years = cycles * yearsPerCycle;

        System.out.printf("It takes about %.0f years to reach %.1f billion people.\n",
                years, population / 1e9);

        // --- Part 2: How many disciples per person for 50 years goal ---
        double targetYears = 50;
        double targetCycles = targetYears / yearsPerCycle;

        // Formula: 13 * (1 + x)^n = population
        double kNeeded = Math.pow(population / disciples, 1 / targetCycles) - 1;

        System.out.printf("To reach everyone in %.0f years, each must train %.2f disciples every 3 years.\n",
                targetYears, kNeeded);
    }
}