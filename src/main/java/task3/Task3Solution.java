package task3;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class Task3Solution {
    public static int getNumberOfComponents(List<Integer> input) {
        Graph<Integer, DefaultEdge> graph = prepareGraph(input);
        var vertices = graph.vertexSet();
        var seen = new HashSet<>();
        int count = 0;

        for (var vertex : vertices) {
            if (!seen.contains(vertex)) {
                count++;
                Iterator<Integer> iterator = new DepthFirstIterator<>(graph, vertex);

                while (iterator.hasNext()) {
                    seen.add(iterator.next());
                }
            }
        }

        return count;
    }

    private static Graph<Integer, DefaultEdge> prepareGraph(List<Integer> input) {
        Graph<Integer, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex(input.get(0));

        if (input.size() == 1) {
            return graph;
        }

        for (int i = 1; i < input.size(); i+=2) {
            graph.addVertex(input.get(i));
            graph.addVertex(input.get(i+1));
            graph.addEdge(input.get(i), input.get(i+1));
        }

        return graph;
    }
}
