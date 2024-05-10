package co.com.sofka.model;

import java.util.Objects;

public class BookModel {
    private String isbn;
    private String title;
    private String subTitle;
    private String author;

    public BookModel() {
    }

    public BookModel(String isbn, String title, String subTitle, String author) {
        this.isbn = isbn;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookModel bookModel = (BookModel) o;
        return Objects.equals(isbn, bookModel.isbn) && Objects.equals(title, bookModel.title) && Objects.equals(subTitle, bookModel.subTitle) && Objects.equals(author, bookModel.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, subTitle, author);
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
