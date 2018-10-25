package Marathon;

public class Course {

    Barrier[] barriers;

    public Course(Barrier[] barriers) {
        this.barriers = barriers;
    }

    public void doIt(Team team) {
        for (Human human : team.participants) {
            for (Barrier barrier : this.barriers) {
                barrier.doIt(human);
                if (!human.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
