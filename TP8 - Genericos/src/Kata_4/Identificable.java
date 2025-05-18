package Kata_4;

public interface Identificable<K> {
    K getID();
    boolean tieneMismoID(K id);
}
