public class Naive {
    public static void main(String[] args) {
        double salary = 50000;
        int rating = 4;
        String grade = "B";
        // More policies add branches here and make employee behavior depend on scattered conditions.
        double meritBonus = salary * rating * 0.02;
        System.out.printf("NAIVE merit bonus: R%.2f%n", meritBonus);
        double gradeBonus;
        if ("A".equals(grade)) {
            gradeBonus = salary * 0.10;
        } else if ("B".equals(grade)) {
            gradeBonus = salary * 0.05;
        } else {
            gradeBonus = salary * 0.02;
        }
        System.out.printf("NAIVE grade bonus: R%.2f%n", gradeBonus);
    }
}
