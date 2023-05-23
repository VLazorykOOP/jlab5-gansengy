import java.io.*;
import java.util.*;


public class Main {
    public static void readDataFromFile(List<PrintedPublication> publications, String filename) {
        try (Scanner fileScanner = new Scanner(Main.class.getResourceAsStream(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");
                String type = data[0].trim();
                String title = data[1].trim();
                String author = data[2].trim();
                int year = Integer.parseInt(data[3].trim());

                if (type.equals("PrintedPublication")) {
                    publications.add(new PrintedPublication(title, author, year));
                } else if (type.equals("Book")) {
                    int pageCount = Integer.parseInt(data[4].trim());
                    publications.add(new Book(title, author, year, pageCount));
                } else if (type.equals("Magazine")) {
                    int issueNumber = Integer.parseInt(data[4].trim());
                    publications.add(new Magazine(title, author, year, issueNumber));
                } else if (type.equals("Textbook")) {
                    int pageCount = Integer.parseInt(data[4].trim());
                    String subject = data[5].trim();
                    publications.add(new Textbook(title, author, year, pageCount, subject));
                }
            }
        } catch (NullPointerException e) {
            System.out.println("File not found: " + filename);
        }
    }


    public static void displayData(List<PrintedPublication> publications) {
        for (PrintedPublication publication : publications) {
            publication.show();
            System.out.println();
        }
    }

    public static void writeDataToFile(List<PrintedPublication> publications, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (PrintedPublication publication : publications) {
                writer.println(publication.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
        }
    }

    public static class PublicationComparator implements Comparator<PrintedPublication> {
        @Override
        public int compare(PrintedPublication publication1, PrintedPublication publication2) {
            // Comparing by title in reverse alphabetical order
            return publication2.getTitle().compareTo(publication1.getTitle());
        }
    }

    public static void firstTask() {
        List<PrintedPublication> publications = new ArrayList<>();

        // Read input data from files and add to the collection
        readDataFromFile(publications, "PrintedPublication.txt");
        readDataFromFile(publications, "Book.txt");
        readDataFromFile(publications, "Magazine.txt");
        readDataFromFile(publications, "Textbook.txt");

        // Display the read data
        System.out.println("Data read from files:");
        displayData(publications);

        // Sort the collection
        Collections.sort(publications);

        // Display the sorted data
        System.out.println("Sorted data:");
        displayData(publications);

        // Add a new record from user input
        Scanner scanner = new Scanner(System.in);
        PrintedPublication newPublication = PrintedPublication.createFromInput();
        publications.add(newPublication);

        // Sort the collection after adding the new record
        Collections.sort(publications);

        // Display the sorted data after adding the new record
        System.out.println("Sorted data after adding a new publication:");
        displayData(publications);

        // Create and sort an ArrayList based on the abstract class
        List<PrintedPublication> arrayList = new ArrayList<>(publications);
        Collections.sort(arrayList, new PublicationComparator());

        // Write the sorted ArrayList to a file
        writeDataToFile(arrayList, "SortedData.txt");


        System.out.println("Operation completed successfully.");
    }
    public static double findResistance(List<Double> currents, List<Double> voltages) {
        int n = currents.size();
        double sumI = 0.0;
        double sumU = 0.0;
        double sumIU = 0.0;
        double sumI2 = 0.0;

        for (int i = 0; i < n; i++) {
            double I = currents.get(i);
            double U = voltages.get(i);

            sumI += I;
            sumU += U;
            sumIU += I * U;
            sumI2 += I * I;
        }

        double denominator = (n * sumI2) - (sumI * sumI);
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero. Check the input data.");
        }

        double resistance = ((n * sumIU) - (sumI * sumU)) / denominator;
        return resistance;
    }
    public static void secondTask() {
        List<Double> currents = new ArrayList<>();
        List<Double> voltages = new ArrayList<>();

        // Add example data
        currents.add(1.0);
        currents.add(2.0);
        currents.add(3.0);

        voltages.add(2.0);
        voltages.add(4.0);
        voltages.add(6.0);

        // Find the resistance
        double resistance = findResistance(currents, voltages);
        System.out.println("Approximate resistance: " + resistance);
    }

    public static void main(String[] args) {
        System.out.println("Java lab 7");

        char answer;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. First task");
            System.out.println("2. Second task");
            System.out.println("E. Exit\n");
            System.out.print("Choose an option:");

            answer = scanner.nextLine().charAt(0);

            switch (answer) {
                case '1':
                    firstTask();
                    break;
                case '2':
                    secondTask();
                    break;
                case 'e':
                case 'E':
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (answer != 'e' && answer != 'E');
    }
}