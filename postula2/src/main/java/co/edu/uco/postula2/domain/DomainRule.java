package co.edu.uco.postula2.domain;

public interface DomainRule<T> {
    void validate(T data);
}
