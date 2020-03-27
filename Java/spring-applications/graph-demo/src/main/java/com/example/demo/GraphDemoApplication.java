package com.example.demo;

import com.amazonaws.services.textract.model.Block;
import com.amazonaws.services.textract.model.GetDocumentAnalysisResult;
import lombok.extern.slf4j.Slf4j;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class GraphDemoApplication implements CommandLineRunner {

	@Autowired
	ResourceLoader resourceLoader;

	public static void main(String[] args) {

		SpringApplicationBuilder  builder = new SpringApplicationBuilder(GraphDemoApplication.class);

		builder.headless(false);
		builder.run(args);
//		SpringApplication
//				.run(GraphDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		Graph graph = new SingleGraph("Tutorial 1");
		GetDocumentAnalysisResult monash_health = getGetDocumentAnalysisResult("monash_health");
		List<Block> page = monash_health.getBlocks().stream().filter(block -> block.getBlockType().equals("PAGE")).collect(Collectors.toList());
		List queue = new LinkedList();

		page.forEach(block ->{
			String id = block.getId();
			graph.addNode(id);
			block.getRelationships().forEach(relationship -> relationship.getIds().forEach(s -> {
				graph.addNode(s);
				graph.addEdge(id + " : " +s, id, s);
			}));
		});

		graph.getNodeIterator().forEachRemaining(node -> System.out.println(node.getId()));


		log.info("Creating graph");

		graph.setAttribute(
				"ui.stylesheet",
				"node { shape: freeplane; fill-color: red; stroke-mode: plain; size-mode: fit; } " +
						"edge { shape: freeplane; }");

		graph.display();
//		Viewer viewer = graph.display();
//		HierarchicalLayout hl = new HierarchicalLayout();
//		viewer.enableAutoLayout(hl);

		//http://graphstream-project.org/doc/Advanced-Concepts/GraphStream-CSS-Reference/
//		test_g();
	}

	void test_g(){
		Graph graph = new SingleGraph("Test");

		Viewer viewer = graph.display();
		HierarchicalLayout hl = new HierarchicalLayout();
		viewer.enableAutoLayout(hl);

		graph.addNode("A" );
		graph.addNode("B" );
		graph.addNode("C" );
		graph.addNode("D" );
		graph.addEdge("AB", "A", "B");
		graph.addEdge("AC", "A", "C");
		graph.addEdge("CD", "C", "D");
	}

	GetDocumentAnalysisResult getGetDocumentAnalysisResult(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(resourceLoader.getResource("classpath:" + fileName + ".tmp").getFile());

		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

		GetDocumentAnalysisResult result = (GetDocumentAnalysisResult) objectInputStream.readObject();
		objectInputStream.close();

		return result;
	}

}
