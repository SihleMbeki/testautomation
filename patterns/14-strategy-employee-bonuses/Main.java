public class Main {
    private static void printBonus(Employee employee) {
        System.out.printf("%s bonus: R%.2f%n", employee.getName(), employee.calculateBonus());
    }

    public static void main(String[] args) {
        Employee ava = new Employee("Ava", 50000, 4, "B", new MeritRatingBonus());
        Employee ben = new Employee("Ben", 50000, 3, "B", new GradeBonus());
        printBonus(ava);
        printBonus(ben);
        ava.setBonusStrategy(new GradeBonus());
        System.out.println("Ava switches to grade strategy");
        printBonus(ava);
    }
}
