package co.com.sofka.util;

import co.com.sofka.model.BookModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class mapToModel {
    public static List<BookModel> mapToBooksList(List<Map<String, String>> bookModelList) {
        List<BookModel> bookModels = new ArrayList<>();
        bookModelList.forEach(model -> {
            BookModel bookModel = new BookModel();
            bookModel.setIsbn(model.get("isbn"));
            bookModel.setTitle(model.get("title"));
            bookModel.setSubTitle(model.get("subTitle"));
            bookModel.setAuthor(model.get("author"));
            bookModels.add(bookModel);
        });
        return bookModels;
    }
}
