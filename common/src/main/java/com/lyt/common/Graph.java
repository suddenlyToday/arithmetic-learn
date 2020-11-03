package com.lyt.common;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private final boolean isDirected;
    private final Map<GraphNode, HashMap<GraphNode, Integer>> nodeEdges;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.nodeEdges = new LinkedHashMap<>();
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Map<GraphNode, HashMap<GraphNode, Integer>> getNodeEdges() {
        return nodeEdges;
    }

    public void printGraph() {
        for (Map.Entry<GraphNode, HashMap<GraphNode, Integer>> node : nodeEdges.entrySet()) {
            String str = String.format("node %s:", node.getKey()) + node.getValue().entrySet().stream()
                    .map(kv -> String.format("[%s,%s]", kv.getKey(), kv.getValue()))
                    .collect(Collectors.joining(","));
            System.out.println(str);
        }
    }

    public void addEdge(GraphNode start, GraphNode end, int weight) {
        this.nodeEdges.compute(start, (k,v)-> {
            if (Objects.isNull(v)) {
                v = new HashMap<>();
            }
            v.put(end ,weight);
            return v;
        });

        if (!isDirected) {
            this.nodeEdges.compute(end, (k,v)-> {
                if (Objects.isNull(v)) {
                    v = new HashMap<>();
                }
                v.put(start ,weight);
                return v;
            });
        }
    }
}
