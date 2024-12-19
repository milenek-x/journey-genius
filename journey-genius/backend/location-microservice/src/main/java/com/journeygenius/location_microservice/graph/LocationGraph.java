package com.journeygenius.location_microservice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationGraph {
    private Map<Long, List<Long>> adjacencyList = new HashMap<>();

    public void addLocation(Long id) {
        adjacencyList.putIfAbsent(id, new ArrayList<>());
    }

    public void addEdge(Long fromId, Long toId) {
        adjacencyList.get(fromId).add(toId);
        adjacencyList.putIfAbsent(toId, new ArrayList<>()); // Ensure destination node exists
    }

    public List<Long> getNeighbors(Long id) {
        return adjacencyList.getOrDefault(id, new ArrayList<>());
    }
}