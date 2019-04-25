package Marathon;

import Marathon.Course.*;
import Marathon.Team.*;

public class Main {
    public static void main(String[] args) {

        Team team = new Team(new Competitor[] {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")});
        Course course = new Course(new Obstacle[] {new Cross(80), new Wall(2), new Wall(1), new Cross(120)});
        course.doIt(team);
        team.showResults();

    }
}