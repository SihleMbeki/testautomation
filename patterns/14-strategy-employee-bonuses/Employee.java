public final class Employee {
    private final String name;
    private final double annualSalary;
    private final int meritRating;
    private final String grade;
    private BonusStrategy bonusStrategy;

    public Employee(String name, double annualSalary, int meritRating, String grade,
            BonusStrategy bonusStrategy) {
        this.name = name;
        this.annualSalary = annualSalary;
        this.meritRating = meritRating;
        this.grade = grade;
        this.bonusStrategy = bonusStrategy;
    }

    public String getName() {
        return name;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public int getMeritRating() {
        return meritRating;
    }

    public String getGrade() {
        return grade;
    }

    public void setBonusStrategy(BonusStrategy bonusStrategy) {
        this.bonusStrategy = bonusStrategy;
    }

    public double calculateBonus() {
        return bonusStrategy.calculateBonus(this);
    }
}
