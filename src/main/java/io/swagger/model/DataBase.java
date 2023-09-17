package io.swagger.model;

public interface DataBase <Entity, Value> {
    public int size();
    public void edit(int index, Entity entity);
    public void insert(Entity entity);
    public void remove(int index);
    public int find(Value value);
}
