package model;

import exception.NotFoundException;

import java.util.Map;

public interface Element {
    String getName();
    void execute(Map<String, Element> elements) throws NotFoundException;
}
