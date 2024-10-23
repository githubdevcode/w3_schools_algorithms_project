package com.dsa.algorithms.runtime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.dsa.algorithms.AlgorithmsApplication;
import com.dsa.algorithms.tree.dto.AdjacencyMatrix;
import com.dsa.algorithms.tree.service.GraphService;

/**
 * Un grafo es una estructura de datos no lineal (puede ir en ambos sentidos desde un nodo hasta otro nodo) el cual se compone de vertices y nodos.
 *  Los grafos son utilizados para descubrir el camino mas corto entre dos vertices.
 * 
 * Las partes que componen un grafo son las siguientes: 
 * 	1. vertices
 * 	2. bordes o limites (conexiones)
 * 
 * Los grafos se utilizan para representar problemas como 
 * 	1. redes sociales: Las personas son los vertices y las amistades son las conexiones o fronteraws. 
 * 	2. paradas de buses y caminos: Normalmente se decide el camino mas corto entre ambos.
 * 	3. internet: Las paginas son los vertices y los enlaces son las fronteras o conexiones 
 * 
 * Los tipos de grafos que pueden existir son los siguientes:
 * 
 * 	1. Grafos con pesos: Son grafos que tienen un valor asignado que puede representar por ejemplo: distancia, probabilidad, etc..
 *  2. Grafos directos: Son grafos en donde sus flechas apuntan a una direccion.
 *  	2.1 Subtipos
 *  		2.1.1 Grafos directos ciclicos
 *  		2.1.2 Grafos no directos ciclicos
 *  3. Grafos conectados: Son grafos en donde no hay algun vertice que no este conectado a otro vertice por medio de una orilla o borde.
 *  
 *  NOTA: Un grafo puede contener ciclos o loops.
 *  
 *  Un grafo puede estar representado de varias formas:
 *   - Ventajas
 *   	1. Puede consumir menos o mas espacio.
 *   	2. Ser mas rapido para buscar o para manipular.
 *   	3. Ser mas facil de entender y implementar que otros.	
 *  
 *   - Ejemplos
 *   
 *   	1. Matrix de adyacencia: En una matriz de adyacencia los indices verticales y horizontales son los vertices y las casillas contienen
 *   		un dato que describe las orilla o frontera (conexion) entre dos vertices cualquiera, el dato puede ser el peso por ejemplo.
 *   	2. Lista de adyacencia: Una matriz de adyacencia contiene una lista en donde los indices representan vertices y en donde a su vez cada
 *   		vertice contiene una lista con uno o mas indices en donde cada indice contiene un valor que representa el indice hacia el cual tiene
 *   		una conexion o frontera. 
 *   		- Ventajas
 *   			1. Consume menos memoria que la matriz de adyacencia ya que no almacena casillas vacias.
 *   		- Escenarios de uso
 *   			1. Utilizar cuando el grafo tiene los elementos muy alejados entre si.
 *   
 *   @fuente https://www.w3schools.com/dsa/dsa_theory_graphs.php
 **/

@SpringBootTest(classes = { AlgorithmsApplication.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class GraphTest {
	private AdjacencyMatrix undirectedAdjacencyMatrixForFirstExample;
	
	@BeforeEach
	public void before() {
		undirectedAdjacencyMatrixForFirstExample = createAdjacencyMatrixForFirstExample();
	}

	private AdjacencyMatrix createAdjacencyMatrixForFirstExample() {
		String[] vertexData = {"A", "B", "C", "D"};

        int[][] adjacencyMatrix = {
            {0, 1, 1, 1}, // Edges for A
            {1, 0, 1, 0}, // Edges for B
            {1, 1, 0, 0}, // Edges for C
            {1, 0, 0, 0}  // Edges for D
        };
        return new AdjacencyMatrix(vertexData, adjacencyMatrix);
	}
	
	@Autowired
	private GraphService graphService;
	
	/**
	 * @fuente https://www.w3schools.com/dsa/dsa_data_graphs_implementation.php (A basic graph implementation)
	 * */
	@Test
	public void whenThereIsAnUndirectedAdjacencyMatrixGraph_thenShowTheEdgesAndVertexesFromIt() {
		System.out.println("An Undirected AdjacencyMatrixGraph ShowTheEdgesAndVertexes");
		graphService.printAdjacencyMatrix(undirectedAdjacencyMatrixForFirstExample);
		System.out.print("\n");
		graphService.printConnections(undirectedAdjacencyMatrixForFirstExample);
		System.out.print("\n");
	}
	
}
