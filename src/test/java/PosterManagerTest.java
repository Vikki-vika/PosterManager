import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class PosterManagerTest {
    @Test
    public void testAddFilm() {
        PosterManager manager = new PosterManager();
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        assertArrayEquals(new String[]{"Film 1", "Film 2"}, manager.findAll());
    }

    @Test
    public void testFindAll() {
        PosterManager manager = new PosterManager();
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        assertArrayEquals(new String[]{"Film 1", "Film 2", "Film 3"}, manager.findAll());
    }

    @Test
    public void testFindLastDefaultLimit() {
        PosterManager manager = new PosterManager();
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        manager.addFilm("Film 4");
        manager.addFilm("Film 5");
        manager.addFilm("Film 6");
        assertArrayEquals(new String[]{"Film 6", "Film 5", "Film 4", "Film 3", "Film 2"}, manager.findLast());
    }

    @Test
    public void testFindLastCustomLimit() {
        PosterManager manager = new PosterManager(3);
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        manager.addFilm("Film 4");
        manager.addFilm("Film 5");
        manager.addFilm("Film 6");
        assertArrayEquals(new String[]{"Film 6", "Film 5", "Film 4"}, manager.findLast());
    }

    @Test
    public void testFindLastLessThanLimit() {
        PosterManager manager = new PosterManager(3);
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        assertArrayEquals(new String[]{"Film 2", "Film 1"}, manager.findLast());
    }

    @Test
    public void testEmptyManager() {
        PosterManager manager = new PosterManager();
        assertArrayEquals(new String[0], manager.findAll());
        assertArrayEquals(new String[0], manager.findLast());
    }

    @Test
    public void testFindLastWithZeroLimit() {
        PosterManager manager = new PosterManager(0);
        manager.addFilm("Film 1");
        assertArrayEquals(new String[0], manager.findLast());
    }

    @Test
    public void testFindLastWithNegativeLimit() {
        PosterManager manager = new PosterManager(-1);
        manager.addFilm("Film 1");
        assertArrayEquals(new String[0], manager.findLast());
    }
}

