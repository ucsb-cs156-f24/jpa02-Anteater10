package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-f24-teams>
        assertEquals("Andy", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-f24-teams>
        assertEquals("Anteater10", Developer.getGithubId());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Steven"),"Team should contain Steven");
        assertTrue(t.getMembers().contains("Anvitha"),"Team should contain Anvitha");
        assertTrue(t.getMembers().contains("Andy"),"Team should contain Andy");
        assertTrue(t.getMembers().contains("Emily"),"Team should contain Emily");
        assertTrue(t.getMembers().contains("Shivani"),"Team should contain Shivani");
        assertTrue(t.getMembers().contains("David"),"Team should contain David");
    }
    
}
