package interfaces;

public interface IObservable {
    void notificarObservadores();
    void agregarObservador(IObserver observer);
    void eliminarObservador(IObserver observer);
}
