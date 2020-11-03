package com.lyt.learn;

import com.lyt.common.Graph;
import com.lyt.common.GraphNode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * every weight of edge is positive
 */
public class Dijkstra {
    private static final int MAX_VALUE = 999999; // all path weight sum will small than this value

    public int getSmallestWeight(Graph graph, GraphNode srcNode, GraphNode endNode) {
        if (graph == null) {
            return -1;
        }
        int size = graph.getNodeEdges().size();
        Set<GraphNode> s = new LinkedHashSet<>(size);
        Map<GraphNode, Integer> u = new HashMap<>(size);
        for (Map.Entry<GraphNode, HashMap<GraphNode, Integer>> entry : graph.getNodeEdges().entrySet()) {
            u.put(entry.getKey(), MAX_VALUE);
        }

        GraphNode currentNode = srcNode;
        s.add(currentNode);
        u.put(currentNode, 0);
        while (s.size() < size && currentNode != null) {
            s.add(currentNode);

            GraphNode preCurrentNode = null;
            int minWeightOfAdj = MAX_VALUE;

            for (Map.Entry<GraphNode, Integer> edge : graph.getNodeEdges().get(currentNode).entrySet()) {
                GraphNode adNode = edge.getKey();
                if (s.contains(adNode)) {
                    continue;
                }
                int weight = u.get(currentNode) + edge.getValue();
                if (weight < u.get(adNode)) {
                    u.put(adNode, weight);
                }
                if (edge.getValue() < minWeightOfAdj) {
                    minWeightOfAdj = weight;
                    preCurrentNode = adNode;
                }
            }

            currentNode = preCurrentNode;
        }

        return u.get(endNode);
    }
}
