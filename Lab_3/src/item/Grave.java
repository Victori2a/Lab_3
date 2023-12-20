package item;

import base.Human;
import base.Item;
import enums.Color;
import base.Position;

public class Grave extends Item {
    private Corpse owner;
    public Color color;
    private Edge edge;
    public final String name = "могила";
    public Grave(Corpse owner){
        this.owner = owner;
        edge = new Edge();
    }
    public Edge getEdge(){
        return edge;
    }

    public void setEdgeColor(Color color) {
        this.edge.color = color;
    }
    @Override
    public void action(Human human) {

    }
    public Color getColor() {
        return null;
    }

    public class Edge extends Item implements Position {
        private Color color;
        private final String name = "край могилы ";
        public Color getColor(){
            return color;
        }
        @Override
        public void action(Human human) {

        }

        @Override
        public String toString() {
            return name + owner +"а";
        }
    }
}
