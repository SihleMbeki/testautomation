public abstract class Match {
    protected abstract String name();
    protected abstract int firstHalfHome(); protected abstract int firstHalfAway();
    protected abstract int secondHalfHome(); protected abstract int secondHalfAway();
    protected void tiedAtFullTime(int home, int away) { }
    public final void playMatch() {
        System.out.println(name() + ": Kick off");
        System.out.println(name() + ": First half");
        int home = firstHalfHome(), away = firstHalfAway();
        System.out.println(name() + ": Half time (" + home + "-" + away + ")");
        System.out.println(name() + ": Second half");
        home += secondHalfHome(); away += secondHalfAway();
        System.out.println(name() + ": Full time (" + home + "-" + away + ")");
        if (home == away) tiedAtFullTime(home, away);
    }
}
