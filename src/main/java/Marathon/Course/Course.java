package Marathon.Course;

import Marathon.Team.Competitor;
import Marathon.Team.Team;

public class Course {

    private Obstacle[] m_obstacles;

    public Course(Obstacle [] obstacles) {
        m_obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Competitor c : team.getCompetitors()) {
            for (Obstacle o : m_obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
