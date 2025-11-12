package co.edu.uco.postula2.application.usecase;

public interface UseCaseWithOutReturn<D> {
    void execute(D domain);
}
