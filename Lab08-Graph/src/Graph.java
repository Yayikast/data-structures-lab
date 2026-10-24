public class Graph<T> {
	AdjList<T> firstList;
	AdjList<T> lastList;
	int vertexCount;
	int edgeCount;

	private class AdjList<T> {
		AdjList<T> nextList;
		T data;
		int outdegree;
		Member<T> firstMember;

		AdjList() {
		}

		AdjList(T newVertex) {
			data = newVertex;
		}
	}

	private class Member<T> {
		T adjVertex;
		int weight;
		Member<T> nextMember;

		Member() {
		}

		Member(T toV, int weight) {
			adjVertex = toV;
			this.weight = weight;
		}
	}

	// Add a new vertex to the graph
	void insertVertex(T newVertex) {
		AdjList<T> temp = new AdjList<>(newVertex);

		if (vertexCount == 0) {
			firstList = temp;
			lastList = temp;
		} else {
			lastList.nextList = temp;
			lastList = temp;
		}
		vertexCount++;
	}

	// Find the adjacency list of a vertex
	AdjList<T> searchAdjList(T data) {
		AdjList<T> current = firstList;
		while (current != null) {
			if (current.data.equals(data))
				return current;
			current = current.nextList;
		}
		return null;
	}

	// Add an edge from one vertex to another
	void insertEdge(T fromData, T toData, int weight) {
		AdjList<T> fromAdjList = searchAdjList(fromData);
		Member<T> newMember = new Member<>(toData, weight);

		newMember.nextMember = fromAdjList.firstMember;
		fromAdjList.firstMember = newMember;
		fromAdjList.outdegree++;
		edgeCount++;
	}

	// Remove an edge from one vertex to another
	void deleteEdge(T fromData, T toData) {
		AdjList<T> fromAdjList = searchAdjList(fromData);
		if (fromAdjList == null)
			return;

		if (fromAdjList.firstMember != null && toData.equals(fromAdjList.firstMember.adjVertex)) {
			fromAdjList.firstMember = fromAdjList.firstMember.nextMember;
			fromAdjList.outdegree--;
			edgeCount--;
		} else if (fromAdjList.firstMember != null) {
			Member<T> temp = fromAdjList.firstMember;
			while (temp != null && temp.nextMember != null) {
				if (toData.equals(temp.nextMember.adjVertex)) {
					temp.nextMember = temp.nextMember.nextMember;
					fromAdjList.outdegree--;
					edgeCount--;
					return;
				}
				temp = temp.nextMember;
			}
		}
	}

	// Remove a vertex and all its edges
	void deleteVertex(T vertex) {
		AdjList<T> currentAdjList = firstList;
		AdjList<T> prevAdjList = null;

		// Delete all edges pointing to this vertex
		while (currentAdjList != null) {
			deleteEdge(currentAdjList.data, vertex);
			currentAdjList = currentAdjList.nextList;
		}

		// Find and remove the vertex itself
		currentAdjList = firstList;
		int outgoing = 0;

		while (currentAdjList != null) {
			if (currentAdjList.data.equals(vertex)) {
				outgoing = currentAdjList.outdegree;

				if (currentAdjList == firstList) {
					firstList = currentAdjList.nextList;
					if (firstList == null)
						lastList = null;
				} else if (currentAdjList == lastList) {
					lastList = prevAdjList;
					lastList.nextList = null;
				} else {
					prevAdjList.nextList = currentAdjList.nextList;
				}

				vertexCount--;
				edgeCount -= outgoing;
				return;
			}
			prevAdjList = currentAdjList;
			currentAdjList = currentAdjList.nextList;
		}
	}

	// Print the graph
	void print() {
		AdjList<T> currentList = firstList;
		while (currentList != null) {
			System.out.print(currentList.data);
			Member<T> cMem = currentList.firstMember;
			while (cMem != null) {
				System.out.print("-->" + cMem.adjVertex + "," + cMem.weight);
				cMem = cMem.nextMember;
			}
			System.out.println();
			currentList = currentList.nextList;
		}
		System.out.println("Vertices: " + vertexCount + ", Edges: " + edgeCount);
	}
}

