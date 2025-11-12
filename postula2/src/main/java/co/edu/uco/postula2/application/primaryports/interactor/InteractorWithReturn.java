package co.edu.uco.postula2.application.primaryports.interactor;

public interface InteractorWithReturn<T, R> {
    R execute(T data);
}
