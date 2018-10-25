package Marathon;

public class Course {

    Barrier[] barriers;

    public Course(Barrier[] barriers) {
        this.barriers = barriers;
    }

    public void doIt(Team team) {
        for (Competitor competitor : team.participants) {
            for (Barrier barrier : this.barriers) {
                barrier.doIt(competitor);
                if (!competitor.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
