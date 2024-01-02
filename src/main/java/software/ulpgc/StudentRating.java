package software.ulpgc;

import java.util.Objects;

public class StudentRating {
    private final String dni;
    private final double rating;

    public StudentRating(String dni, double rating) {
        this.dni = dni;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRating that = (StudentRating) o;
        return Double.compare(rating, that.rating) == 0 && Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, rating);
    }

    @Override
    public String toString() {
        return "StudentRating{" +
                "dni='" + dni + '\'' +
                ", rating=" + rating +
                '}';
    }
}
