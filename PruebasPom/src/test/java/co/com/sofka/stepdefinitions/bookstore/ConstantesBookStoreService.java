package co.com.sofka.stepdefinitions.bookstore;

public class ConstantesBookStoreService {
    protected static String BASE_URL = "https://demoqa.com";
    protected static String GET_ALL_BOOKS_URL = "/BookStore/v1/Books";
    protected static String GET_BOOK_URL = "/BookStore/v1/Book?ISBN={isbn}";
    protected static String POST_USER_URL = "/Account/v1/User";
    protected static String GENERATE_TOKEN_URL = "/Account/v1/GenerateToken";
    protected static String ASK_AUTHORIZATION_URL = "/Account/v1/Authorized";


    // Constantes de validacion
    protected static String SUCCESS_MESSAGE = "Success";
    protected static String RESULT_MESSAGE = "User authorized successfully.";

}
