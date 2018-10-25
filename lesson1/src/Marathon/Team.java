package Marathon;

public class Team {

    String name;

    Human[] participants;

    public Team(String name, Human[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public void passDistanceInfo()
    {
        System.out.println("Участники команды "+ name + " прошедшие полосу препятствий: ");
        for(Human human: participants){
            if(human.isOnDistance())
                human.info();
        }
    }


    public void showResults() {
        System.out.println("Участники команды "+ name + ": ");
        for(Human human: participants){
                human.info();
        }
    }
}
