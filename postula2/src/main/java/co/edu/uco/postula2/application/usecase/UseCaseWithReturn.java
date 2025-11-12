package co.edu.uco.postula2.application.usecase;

public interface UseCaseWithReturn<D, R> {
    R execute(D domain);
}
