public final class GradeBonus implements BonusStrategy {
    @Override
    public double calculateBonus(Employee employee) {
        switch (employee.getGrade()) {
            case "A":
                return employee.getAnnualSalary() * 0.10;
            case "B":
                return employee.getAnnualSalary() * 0.05;
            case "C":
                return employee.getAnnualSalary() * 0.02;
            default:
                throw new IllegalArgumentException("Unsupported grade: " + employee.getGrade());
        }
    }
}
