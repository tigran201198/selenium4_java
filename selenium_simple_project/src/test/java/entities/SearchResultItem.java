package entities;

import java.util.Objects;

public class SearchResultItem {

    private final String title;
    private final String description;

    public SearchResultItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResultItem that = (SearchResultItem) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

    @Override
    public String toString() {
        return "SearchResultItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
