package Polarising;

public class App {
    private String userName;
    private int yearsOfExistance;
    private int[] abc;

    public App(String name, int minNum, int maxNum) {
        this.userName = name;
        getPlanement(minNum, maxNum);
    }

    public void getPlanement(int minNum, int maxNum) {
        abc = fibonacciSequence(getRandNumb(minNum, maxNum));
        getGrowth(abc);
        numbOfficeChange(abc);
    }

    public int getRandNumb(int minNum, int maxNum) {
        int randNumb = (int) (Math.ceil(Math.random() * (maxNum - minNum + 1))) + minNum - 1;
        System.out.println(userName + (", the random number we are using as years is: " + randNumb + "\n"));
        return randNumb;
    }

    public int[] fibonacciSequence(int number) {
        yearsOfExistance = number;
        int[] list = new int[yearsOfExistance + 1];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i < list.length; i++) {
            list[i] = list[i - 2] + list[i - 1];
        }

        return list;
    }

    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public void getGrowth(int[] array) {
        int lastYear = 0;
        System.out
                .println("This is the expected consultants growth of the company over the next " + yearsOfExistance + " years:");
        System.out.println(GREEN + "Year " + RESET + "|" + RED + "Expected Consultants" + RESET);
        for (int i = 0; i < array.length; i++) {
            if (isOdd(array[i])) {
                System.out.println(GREEN + i + RESET + " | " + RED + array[i] + RESET);
                lastYear = array[i];
            }
        }
        System.out.println(YELLOW + "(it only shows the years in wich the number of consultants is odd)" + RESET);
        System.out.println("After " + yearsOfExistance + " years, the company is expected to have "
                + lastYear + " consultants");
    }

    public int numbOfficeChange(int[] array) {
        int counter = 0;
        for (int i : array) {
            if (isPrime(i)) {
                counter++;
            }
        }
        System.out.println("The office will be reconsidered " + counter + " times");
        return counter;
    }

    //StringColors
    String RESET = "\u001B[0m";
    String RED = "\u001B[31m";
    String GREEN = "\u001B[32m";
    String YELLOW = "\u001B[33m";
}



