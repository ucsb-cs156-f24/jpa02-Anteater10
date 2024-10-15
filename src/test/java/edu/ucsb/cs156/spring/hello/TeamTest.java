package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;


public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    void testEquals_sameObject() {
        Team team = new Team("Team");
        team.addMember("Alice");
        team.addMember("Bob");
        assertEquals(true, team.equals(team));
    }

    @Test
    void testEquals_equalTeams() {
        Team team1 = new Team("Team");
        team1.addMember("Alice");
        team1.addMember("Bob");

        Team team2 = new Team("Team");
        team2.setMembers(new ArrayList<>(Arrays.asList("Alice", "Bob")));

        assertEquals(true, team1.equals(team2));
    }

    @Test
    void testEquals_differentNames() {
        Team team1 = new Team("Team One");
        team1.addMember("Alice");

        Team team2 = new Team("Team Two");
        team2.addMember("Alice");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    void testEquals_differentMembers() {
        Team team1 = new Team("Team");
        team1.addMember("Alice");

        Team team2 = new Team("Team");
        team2.addMember("Bob");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    void testEquals_nullObject() {
        Team team = new Team("Team");
        assertEquals(false, team.equals(null));
    }

    @Test
    void testEquals_differentObjectType() {
        Team team = new Team("Team");
        String notATeam = "Not a team";
        assertEquals(false, team.equals(notATeam));
    }

    @Test
    void testEquals_sameNameDifferentMembers() {
        Team team1 = new Team("Team");
        team1.addMember("Alice");

        Team team2 = new Team("Team");
        team2.addMember("Bob");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    void testEquals_differentNameSameMembers() {
        Team team1 = new Team("Team One");
        team1.addMember("Alice");

        Team team2 = new Team("Team Two");
        team2.addMember("Alice");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    void testEquals_differentNameAndDifferentMembers() {
        Team team1 = new Team("Team One");
        team1.addMember("Alice");

        Team team2 = new Team("Team Two");
        team2.addMember("Bob");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    void testHashCodeSameContent() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.setMembers(new ArrayList<>(Arrays.asList("bar", "baz")));

        Team t2 = new Team();
        t2.setName("foo");
        t2.setMembers(new ArrayList<>(Arrays.asList("bar", "baz")));

        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testHashCodeSpecificValue() {
        Team t = new Team();
        t.setName("foo");
        t.setMembers(new ArrayList<>(Arrays.asList("bar", "baz")));

        int actualHashCode = t.hashCode();

        int expectedHashCode = "foo".hashCode() | new ArrayList<>(Arrays.asList("bar", "baz")).hashCode();

        assertEquals(expectedHashCode, actualHashCode);
    }
}
