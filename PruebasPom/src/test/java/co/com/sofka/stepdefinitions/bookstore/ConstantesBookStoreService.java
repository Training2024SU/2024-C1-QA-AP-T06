package co.com.sofka.stepdefinitions.bookstore;

public class ConstantesBookStoreService {
    protected static String BASE_URL = "https://demoqa.com";
    protected static String GET_ALL_BOOKS_URL = "/BookStore/v1/Books";
    protected static String GET_BOOK_URL = "/BookStore/v1/Book?ISBN={isbn}";
    protected static String POST_USER_URL = "/Account/v1/User";
    protected static String GENERATE_TOKEN_URL = "/Account/v1/GenerateToken";
    protected static String ASK_AUTHORIZATION_URL = "/Account/v1/Authorized";

    // not authorized
    protected static String DELETE_USER_NOT_AUTHORIZED_URL = "/Account/v1/User/{UUID}";
    protected static String DELETE_BOOK_NOT_AUTHORIZED_URL = "/BookStore/v1/Book";
    protected static String UPDATE_BOOK_NOT_AUTHORIZED_URL = "/BookStore/v1/Books/{ISBN}";


    // Constantes de validacion
    protected static String SUCCESS_MESSAGE = "Success";
    protected static String RESULT_MESSAGE = "User authorized successfully.";

    // Constantes usuario no autorizado
    protected static String FAILED_CODE = "1200";
    protected static String NOT_AUTHORIZED_MESSAGE = "User not authorized!";


}
