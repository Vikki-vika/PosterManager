public class PosterManager {
    private String[] films;
    private int limit;

    public PosterManager() {
        this.films = new String[0];
        this.limit = 5;
    }

    public PosterManager(int limit) {
        this.films = new String[0];
        this.limit = Math.max(limit, 0);
    }

    public void addFilm(String film) {
        String[] tmp = new String[films.length + 1];
        System.arraycopy(films, 0, tmp, 0, films.length);
        tmp[films.length] = film;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength = Math.min(films.length, Math.max(limit, 0));
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }
}