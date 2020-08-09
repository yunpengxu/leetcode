import java.util.*;

public class P0133CloneGraph {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		UndirectedGraphNode clonedRoot = null;
		if (node != null) {
			Map<Integer, UndirectedGraphNode> knownNodes = new HashMap<Integer, UndirectedGraphNode>();
			knownNodes.put(node.label, node);
			Set<UndirectedGraphNode> nodesToTraverse = new HashSet<UndirectedGraphNode>();
			nodesToTraverse.addAll(node.neighbors);
			while (nodesToTraverse.size() > 0) {
				Set<UndirectedGraphNode> nextTraverse = new HashSet<UndirectedGraphNode>();
				for (UndirectedGraphNode n : nodesToTraverse) {
					if (!knownNodes.containsKey(n.label)) {
						knownNodes.put(n.label, n);
						nextTraverse.addAll(n.neighbors);
					}
				}
				nextTraverse.removeAll(knownNodes.keySet());
				nodesToTraverse = nextTraverse;
			}

			Map<Integer, UndirectedGraphNode> freshNodes = new HashMap<Integer, UndirectedGraphNode>();
			for (Integer label : knownNodes.keySet()) {
				freshNodes.put(label, new UndirectedGraphNode(label));
			}
			for (Integer label : freshNodes.keySet()) {
				UndirectedGraphNode newNode = freshNodes.get(label);
				UndirectedGraphNode orgNode = knownNodes.get(label);
				List<UndirectedGraphNode> orgNeighbors = orgNode.neighbors;
				List<UndirectedGraphNode> newNeighbors = newNode.neighbors;
				for (UndirectedGraphNode oNeighbor : orgNeighbors) {
					UndirectedGraphNode nNeghbor = freshNodes
							.get(oNeighbor.label);
					newNeighbors.add(nNeghbor);
				}
			}

			clonedRoot = freshNodes.get(node.label);
		}

		return clonedRoot;
	}
}
