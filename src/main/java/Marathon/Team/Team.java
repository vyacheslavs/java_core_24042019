package Marathon.Team;

public class Team {

    private Competitor[] m_competitors;

    public Team(Competitor[] competitors) {
        m_competitors = competitors;
    }

    public Competitor[] getCompetitors() {
        return m_competitors.clone();
    }

    public void showResults() {
        for (Competitor c : m_competitors) {
            c.info();
        }
    }
}
