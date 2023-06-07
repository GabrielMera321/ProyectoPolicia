package co.edu.unbosque.ProyectoPolicia.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.unbosque.ProyectoPolicia.model.Agent;
import co.edu.unbosque.ProyectoPolicia.model.Narcotics;
import co.edu.unbosque.ProyectoPolicia.model.Raid;
import co.edu.unbosque.ProyectoPolicia.respository.AgentRepository;
import co.edu.unbosque.ProyectoPolicia.respository.NarcoticsRepository;
import co.edu.unbosque.ProyectoPolicia.respository.RaidRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class PdfGenerator {

	@Autowired
	private AgentRepository agentRepository;

	@Autowired
	private RaidRepository raidRepository;

	@Autowired
	private NarcoticsRepository narcoticsRepository;

	public void createPdf(String filename) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filename));

		document.open();

		document.add(new Paragraph("Agentes:"));
		List<Agent> agents = agentRepository.findAll();
		for (Agent agent : agents) {
			document.add(new Paragraph("Nombre: " + agent.getName()));

		}

		document.add(new Paragraph("Redadas:"));
		List<Raid> raids = raidRepository.findAll();
		for (Raid raid : raids) {
			document.add(new Paragraph("Fecha de ejecución: " + raid.getExecutionDate()));

		}

		document.add(new Paragraph("Narcóticos:"));
		List<Narcotics> narcotics = narcoticsRepository.findAll();
		for (Narcotics narcotic : narcotics) {
			document.add(new Paragraph("Tipo: " + narcotic.getType()));

		}

		document.close();
	}
}
