package com.autobots.automanager.models;

import java.util.List;

public interface LinkAdder<T> {
	public void addLink(List<T> baseList);
	public void addLink(T object);
}
