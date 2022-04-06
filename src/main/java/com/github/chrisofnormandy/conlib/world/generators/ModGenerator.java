package com.github.chrisofnormandy.conlib.world.generators;

import java.util.HashMap;

public class ModGenerator {

    HashMap<String, Element> elements = new HashMap<String, Element>();

    public ModGenerator() {
    }

    public Object getValue(String element) {
        return elements.get(element).getValue();
    }

    public void add(String element, Object value) {
        elements.put(element, new Element(value));
    }

    public class Element {
        Object value;

        public Element(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return this.value;
        }
    }
}
