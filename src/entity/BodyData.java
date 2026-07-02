package entity;

import java.util.Iterator;
import java.util.LinkedList;

public record BodyData(LinkedList<RGBColor> data) {
    public Iterator<RGBColor> iterator(){
        return data.iterator();
    }
}
