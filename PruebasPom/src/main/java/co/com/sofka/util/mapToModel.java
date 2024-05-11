package co.com.sofka.util;

import co.com.sofka.model.BookModel;
import co.com.sofka.model.UserRegisterPageModel;

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

    public static List<UserRegisterPageModel> mapToUserList(List<Map<String, String>> userModelList){
        List<UserRegisterPageModel> userRegisterPageModels = new ArrayList<>();
        userModelList.forEach(model -> {
            UserRegisterPageModel userRegisterPageModel = new UserRegisterPageModel();
            userRegisterPageModel.setName(model.get("nombre"));
            userRegisterPageModel.setLastname(model.get("apellido"));
            userRegisterPageModel.setUsername(model.get("user"));
            userRegisterPageModel.setPassword(model.get("contrasena"));
            userRegisterPageModels.add(userRegisterPageModel);
        });
        return userRegisterPageModels;
    }
}
