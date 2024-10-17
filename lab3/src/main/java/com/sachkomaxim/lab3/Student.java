package com.sachkomaxim.lab3;

/**
 * The "Student" class represents student objects and contains methods for sorting by name (ascending)
 * and GPA (descending), and overrides the "equals" method to allow comparison between two "Student"
 * objects based on their attributes.
 */
class Student implements Comparable<Student> {
    private final String name;
    private final int age;
    private final double gpa;
    private final String subject;
    private final int year;

    /**
     * Constructor for the "Student" class.
     *
     * @param name      The name of the student
     * @param age       The age of the student
     * @param gpa       The GPA (Grade Point Average) of the student
     * @param subject   The subject of the student
     * @param year      The year of the student
     */
    public Student(String name, int age, double gpa, String subject, int year) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.subject = subject;
        this.year = year;
    }

    /**
     * Overridden compareTo method for sorting by gpa.
     *
     * @param other The other "Student" object to compare to
     * @return The result of comparing the gpas (GPAs) of the students
     */
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    /**
     * Overridden toString method to represent the object as a string.
     *
     * @return A string representing the "Student" object
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                ", subject='" + subject + '\'' +
                ", year=" + year +
                '}';
    }

    /**
     * Overridden equals method for comparing two "Student" objects.
     * <p>
     * This method compares the current "Student" object with another object to determine
     * if they are equal. Equality is determined by checking if all fields (name, age, gpa,
     * subject, and year) are the same between both objects.
     *
     * @param obj The object to compare with the current "Student" object.
     * @return True if the objects are the same instance or have identical field values;
     *         false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Student)) return false;

        Student student = (Student) obj;

        return name.equals(student.name) &&
                age == student.age &&
                Double.compare(gpa, student.gpa) == 0 &&
                subject.equals(student.subject) &&
                year == student.year;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    public String getSubject() {
        return subject;
    }

    public int getYear() {
        return year;
    }
}
