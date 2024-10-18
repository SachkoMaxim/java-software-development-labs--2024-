package com.sachkomaxim.lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    /**
     * The main method of the program. It performs the following operations:
     * <ul>
     *   <li>Creates an array of "Student" objects with predefined data.</li>
     *   <li>Prints the list of students before sorting.</li>
     *   <li>Sorts the students by their name (ascending) and GPA (descending).</li>
     *   <li>Prints the sorted list of students.</li>
     *   <li>Compares a given "Student" object with the students in the array to find an identical match based on all fields.</li>
     *   <li>If a match is found, it prints the details of the matched student.</li>
     * </ul>
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Student[] studentsArray = createStudentsArray();

        System.out.println("Студенти перед сортуванням:");
        printStudentsArray(studentsArray);

        sortStudentsByNameAndGpa(studentsArray);

        System.out.println("\nСтуденти після сортування за іменами (за зростанням) і середнім балом (за спаданням):");
        printStudentsArray(studentsArray);

        Student compareStudent = new Student("Maryna", "Sirko", 20, 83.1, "Computer", 2);
        findAndPrintMatchingStudent(studentsArray, compareStudent);
    }

    /**
     * Creates an array of predefined "Student" objects.
     *
     * @return An array of "Student" objects
     */
    private static Student[] createStudentsArray() {
        return new Student[]{
                new Student("Dmytro", "Marchenko", 20, 80.5, "Mathematics", 2),
                new Student("Maryna", "Sirko", 20, 83.1, "Computer", 2),
                new Student("Mykhailo", "Balakhon", 21, 91.2, "Physics", 3),
                new Student("Elina", "Yurchenko", 18, 98.9, "Engineering", 1),
                new Student("Ruslan", "Marchenko", 23, 83.4, "Economics", 4),
                new Student("Dmytro", "Hryhorash", 20, 94.6, "Computer", 3),
                new Student("Anya", "Kovalenko", 22, 93.6, "Computer", 3),
                new Student("Maryna", "Sirko", 22, 93.5, "Mathematics", 3),
                new Student("Maxim", "Yurchenko", 24, 91.2, "History", 4),
                new Student("Elina", "Kuts", 19, 92.9, "Computer", 1),
                new Student("Ruslan", "Dyachok", 23, 90.5, "Biology", 2),
                new Student("Sofia", "Balakhon", 20, 87.7, "Chemistry", 1),
                new Student("Lesya", "Vasiliadi", 20, 95.6, "Biology", 2),
                new Student("Oleksandr", "Bondarenko", 21, 94.7, "Physics", 2),
                new Student("Anya", "Gorai", 23, 90.9, "Engineering", 2),
                new Student("Sofia", "Balakhon", 19, 99.9, "Chemistry", 2)
        };
    }

    /**
     * Sorts an array of "Student" objects by name (ascending) and GPA (descending).
     *
     * @param studentsArray The array of "Student" objects to sort
     */
    private static void sortStudentsByNameAndGpa(Student[] studentsArray) {
        Arrays.sort(studentsArray, Comparator
                .comparing(Student::getName)
                .thenComparing(Student::getGpa, Comparator.reverseOrder()));
    }

    /**
     * Prints the contents of an array of "Student" objects.
     *
     * @param studentsArray The array of "Student" objects to print
     */
    private static void printStudentsArray(Student[] studentsArray) {
        for (Student student : studentsArray) {
            System.out.println(student);
        }
    }

    /**
     * Finds and prints the "Student" object that matches the given "compareStudent" object.
     * The comparison is based on all fields (name, surname, age, GPA, subject, and year).
     *
     * @param studentsArray   The array of "Student" objects to search through
     * @param compareStudent  The "Student" object to compare against
     */
    private static void findAndPrintMatchingStudent(Student[] studentsArray, Student compareStudent) {
        for (int i = 0; i < studentsArray.length; i++) {
            Student student = studentsArray[i];
            if (compareStudent.equals(student)) {
                System.out.println("\nПісля сортування знайдено ідентичного студента: compareStudent.equals(studentsArray[" + (i + 1) + "]) = " + student);
            }
        }
    }
}
