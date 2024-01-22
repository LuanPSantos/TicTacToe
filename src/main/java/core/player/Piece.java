package core.player;

public abstract class Piece<T> {
    protected final T graphic;

    protected Piece(T graphic) {
        this.graphic = graphic;
    }

    public T getGraphic() {
        return graphic;
    };
}
