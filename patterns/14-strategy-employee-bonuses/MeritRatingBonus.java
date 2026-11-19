public final class MeritRatingBonus implements BonusStrategy {
    @Override
    public double calculateBonus(Employee employee) {
        if (employee.getMeritRating() < 1 || employee.getMeritRating() > 5) {
            throw new IllegalArgumentException("Merit rating must be from 1 to 5");
        }
        return employee.getAnnualSalary() * employee.getMeritRating() * 0.02;
    }
}
