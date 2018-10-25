package Marathon;

public class Team {

    String name;

    Competitor[] participants;

    public Team(String name, Competitor[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public void passDistanceInfo()
    {
        System.out.println("Участники команды "+ name + " прошедшие полосу препятствий: ");
        for(Competitor competitor: participants){
            if(competitor.isOnDistance())
                competitor.info();
        }
    }


    public void showResults() {
        System.out.println("Участники команды "+ name + ": ");
        for(Competitor competitor: participants){
            competitor.info();
        }
    }
}
