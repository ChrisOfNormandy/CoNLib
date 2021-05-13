package com.github.chrisofnormandy.conlib.collections;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.chrisofnormandy.conlib.Main;
import com.github.chrisofnormandy.conlib.common.Files;

public class JsonBuilder {
    public JsonObject createJsonObject() {
        return new JsonObject();
    }

    public JsonArray createJsonArray() {
        return new JsonArray();
    }

    public String stringify(JsonObject json) {
        return json.toString();
    }

    public String stringify(JsonArray json) {
        return json.toString();
    }

    public JsonObject merge(JsonObject a, JsonObject b) {
        a.map.forEach((String key, Object value) -> {
            b.map.put(key, value);
        });
        return a;
    }

    public JsonArray concat(JsonArray a, JsonArray b) {
        if (a.first == null)
            return b;
        if (b.first == null)
            return a;
        a.last.append(b.first);
        return a;
    }

    public void write(String path, String name, JsonObject json) {
        Files.write(path, name, stringify(json), ".json");
    }

    public void write(String path, String name, JsonArray json) {
        Files.write(path, name, stringify(json), ".json");
    }

    public class JsonArray {
        public JsonArray() {}

        public class Node {
            Object value = null;

            Node next = null;

            public Node() {}

            public Node(Object value) {
                this.value = value;
            }

            public Node getNext() {
                return this.next;
            }

            /**
             * Will append a new Node to the linked list and attach the following links to the new element.
             * @param node
             * @return
             */
            public Node insert(Node node) {
                node.next = this.next.getNext();
                this.next = node;
                return this.next;
            }

            public Node append() {
                this.next = new Node();
                return this;
            }

            public Node append(Node node) {
                this.next = node;
                return this;
            }            

            public String toString() {
                if (this.value instanceof String)
                    return "\"" + this.value + "\"";
                return this.value.toString();
            }

            public Object get() {
                return this.value;
            }

            public void clear() {
                this.value = null;
            }
        }       

        Node first = null;
        Node last = first;

        public Integer length() {
            int length = 0;
            Node current = first;

            while (current != null) {
                length++;
                current = current.getNext();
            }

            return length;
        }

        public JsonArray add(Object value) {
            if (last == null) {
                first = new Node(value);
                last = first;
            }
            else {
                Node current = new Node(value);
                last.append(current);
                last = current;
            }
            return this;
        }

        public JsonObject addObject() {
            JsonObject obj = new JsonObject();
            add(obj);
            return obj;
        }

        public JsonArray addArray() {
            JsonArray arr = new JsonArray();
            add(arr);
            return arr;
        }

        public Boolean remove(Integer index) {
            if (index < 0)
                return false;
            else if (index == 0) {
                first = null;
                last = first;
                return true;
            }

            Node current = first;
            int count = 0;
            while (count != index) {
                if (current == null)
                    return false;

                count++;
                current = current.getNext();
            }

            if (current.getNext() != null)
                current.next = current.next.getNext();

            return true;
        }

        public JsonArray set(Object value, Integer index) {
            if (index < 0)
                return null;

            if (index == 0) {
                first = new Node(value);
                return this;
            }

            Node current = first;
            int count = 0;
            while (count != index) {
                if (current == null)
                    return null;

                current = first.getNext();
                count++;
            }

            current.append(new Node(value));

            return this;
        }

        public JsonObject setObject(Integer index) {
            JsonObject obj = new JsonObject();
            set(obj, index);            
            return obj;
        }

        public JsonArray setArray(Integer index) {
            JsonArray arr = new JsonArray();
            set(arr, index);
            return arr;
        }

        public Object get(Integer index) {
            if (first == null || index < 0)
                return null;

            Node current = first;
            int count = 0;
            while (count != index) {
                if (current == null)
                    return null;
                current = current.getNext();
                count++;
            }

            return current.get();
        }

        public JsonObject getObject(Integer index) {
            Object value = get(index);
            return value instanceof JsonObject ? JsonObject.class.cast(get(index)) : null;
        }

        public JsonArray getArray(Integer index) {
            Object value = get(index);
            return value instanceof JsonArray ? JsonArray.class.cast(get(index)) : null;
        }

        public String toString() {
            if (first == null)
                return "[ ]";

            List<String> list = new ArrayList<String>();

            Node current = first;
            while (current != null) {
                list.add(current.get().toString());
                current = current.getNext();
            }

            return "[ " + String.join(", ", list) + " ]";
        }
    }

    public class JsonObject {
        public JsonObject() {}

        HashMap<String, Object> map = new HashMap<>();

        public JsonObject set(String key, Object value) {
            map.put(key, value);
            return this;
        }

        public JsonObject addObject(String key) {
            JsonObject obj = new JsonObject();
            map.put(key, obj);
            return obj;
        }

        public JsonArray addArray(String key) {
            JsonArray arr = new JsonArray();
            map.put(key, arr);
            return arr;
        }

        public Object get(String key) {
            return map.get(key);
        }

        public JsonObject getObject(String key) {
            Object value = map.get(key);
            return value instanceof JsonObject ? JsonObject.class.cast(value) : null;
        }

        public JsonArray getArray(String key) {
            Object value = map.get(key);
            return value instanceof JsonArray ? JsonArray.class.cast(value) : null;
        }

        public String toString() {
            List<String> list = new ArrayList<String>();

            map.forEach((String key, Object value) -> {
                if (value instanceof String)
                    list.add("\"" + key + "\": \"" + value + "\"");
                else if (value instanceof JsonObject || value instanceof JsonArray)
                    list.add("\"" + key + "\": " + value.toString());
                else
                    list.add("\"" + key + "\": " + value);
            });

            return "{ " + String.join(", ", list) + " }";
        }
    }
}
