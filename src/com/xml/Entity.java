package com.xml;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xml.model.Car;
import com.xml.model.Parking;
//Ctrl + shift + F dans xml pour organiser l'écriture
public class Entity {

	public static void main(String[] args) 
	{
		test4();
	}
	public static void test2() {
		
		List<String> strs = new ArrayList<>();
		strs.add("ytehyutj");
		strs.add("ytehyutj");
		strs.add("ytehyutj");
		strs.add("ytehyutj");
		strs.add("ytehyutj");
		strs.add("ytehyutj");
		strs.add("ytehyutj");
		strs.add("ytehyutj");
		strs.add("ytehyutj");
		strs.add("ytehyutj");

		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(new File("string.json"), strs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void test3() {
	
	//serializer creation d'un json
		
	Parking parking1 = new Parking(1, "Jean Jaures");
	Parking parking2 = new Parking(2, "Capitole");
	
	parking1.addCar(new Car(11,"VD334JK", "Peugeot", "Rouge"));
	parking1.addCar(new Car(23,"VFERSJK", "Renault", "Bleu"));
	parking1.addCar(new Car(465,"VH342JG", "Ford", "Rouge"));
	parking1.addCar(new Car(52,"DG4T2JK", "Ford", "Bleu"));
	parking1.addCar(new Car(85,"VD332JR", "Peugeot", "Rouge"));
	
	parking2.addCar(new Car(34,"VD334EK", "Peugeot", "Vert"));
	parking2.addCar(new Car(22,"VFERSAK", "Fiat", "Rouge"));
	parking2.addCar(new Car(624,"VH34HJG", "Ford", "Vert"));
	parking2.addCar(new Car(888,"VDADJR", "Renault", "Rouge"));
	
	
	List<Parking> parkings  = new ArrayList();
	parkings.add(parking1);
	parkings.add(parking2);

		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(new File("string.json"), parkings);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void test4() {
	///Deserializer lecture d'un json
	
	Parking parking1 = new Parking(1, "Jean Jaures");
	Parking parking2 = new Parking(2, "Capitole");
	
	parking1.addCar(new Car(11,"VD334JK", "Peugeot", "Rouge"));
	parking1.addCar(new Car(23,"VFERSJK", "Renault", "Bleu"));
	parking1.addCar(new Car(465,"VH342JG", "Ford", "Rouge"));
	parking1.addCar(new Car(52,"DG4T2JK", "Ford", "Bleu"));
	parking1.addCar(new Car(85,"VD332JR", "Peugeot", "Rouge"));
	
	parking2.addCar(new Car(34,"VD334EK", "Peugeot", "Vert"));
	parking2.addCar(new Car(22,"VFERSAK", "Fiat", "Rouge"));
	parking2.addCar(new Car(624,"VH34HJG", "Ford", "Vert"));
	parking2.addCar(new Car(888,"VDADJR", "Renault", "Rouge"));
	
	
	List<Parking> parkings  = new ArrayList();
	parkings.add(parking1);
	parkings.add(parking2);

		
		ObjectMapper mapper = new ObjectMapper();
		List<Parking> p ;
		try {p=mapper.readValue(new File("string.json"), 
					new TypeReference<List<Parking>>() {});
			System.out.println(p);
		} catch (IOException e) {e.printStackTrace();}
	}











	public static void test1() {
		Parking parking1 = new Parking(1, "Jean Jaures");
		Parking parking2 = new Parking(2, "Capitole");
		
		parking1.addCar(new Car(11,"VD334JK", "Peugeot", "Rouge"));
		parking1.addCar(new Car(23,"VFERSJK", "Renault", "Bleu"));
		parking1.addCar(new Car(465,"VH342JG", "Ford", "Rouge"));
		parking1.addCar(new Car(52,"DG4T2JK", "Ford", "Bleu"));
		parking1.addCar(new Car(85,"VD332JR", "Peugeot", "Rouge"));
		
		parking2.addCar(new Car(34,"VD334EK", "Peugeot", "Vert"));
		parking2.addCar(new Car(22,"VFERSAK", "Fiat", "Rouge"));
		parking2.addCar(new Car(624,"VH34HJG", "Ford", "Vert"));
		parking2.addCar(new Car(888,"VDADJR", "Renault", "Rouge"));
		
		
		List<Parking> parkings  = new ArrayList();
		parkings.add(parking1);
		parkings.add(parking2);
		
	try {	
		//docBuilder pour construire le documpent  necessaire. docFactory pour le docbilder
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		
		Document docu = docBuilder.newDocument();
		Element parkingsElem = docu.createElement("parkings");
		for (Parking parking : parkings) 
		{
			Element parkingElem = docu.createElement("parking");
			parkingElem.setAttribute("id", parking.getId()+"" );
			Element nameElem = docu.createElement("name");
			Text nameTextElement = docu.createTextNode(parking.getName());
			Element carsElem = docu.createElement("cars");
			
			for (Car car : parking.getCars()) 
			{
				Element carElem = docu.createElement("car");
				carElem.setAttribute("id", car.getId()+"" );
				carElem.setAttribute("immat", car.getImmat()+"" );
				Element modelElem = docu.createElement("model");
				Text modelTextElem = docu.createTextNode(car.getModel());
				Element colorElem = docu.createElement("color");
				Text colorTextElem = docu.createTextNode(car.getImmat());
				
				carsElem.appendChild(carElem);
				carElem.appendChild(colorElem);
				carElem.appendChild(modelElem);
				modelElem.appendChild(modelTextElem);
				colorElem.appendChild(colorTextElem);
			}
			parkingElem.appendChild(carsElem);
			parkingsElem.appendChild(parkingElem);
		}
		docu.appendChild(parkingsElem);
		
		
		
//		//creation du document 
//		Document doc = docBuilder.newDocument();
//		//Creation de la class listebalise sailors
//		Element rootElement = doc.createElement("sailors");
//		//ajouter le sailors au doc
//		doc.appendChild(rootElement);
//		//creation de sous class sailor
//		Element sailor = doc.createElement("sailor");
//		//et set id=12
//		sailor.setAttribute("id", "12");
//		//placer sailor dans la balise sailors comme sous class
//		rootElement.appendChild(sailor);
//					//creation de la balise color
//					Element colorElement = doc.createElement("color");
//						//creer du text
//						Text colorTextElement = doc.createTextNode("Rouge");
//						//ajouter le text dans la balise color
//						colorElement.appendChild(colorTextElement);
//						
//						//creation de la balise color
//				Element firstnameElement = doc.createElement("first_name");
//				//creer du text
//				Text firstnameTextElement = doc.createTextNode("Robert");
//				//ajouter le text dans la balise color
//				firstnameElement.appendChild(firstnameTextElement);
//				
//				//creation de la balise color
//				Element lastnameElement = doc.createElement("last_name");
//				//creer du text
//				Text lastnameTextElement = doc.createTextNode("Sourcouf");	
//				//ajouter le text dans la balise color
//				lastnameElement.appendChild(lastnameTextElement);
//				
//				//creation de la balise color
//				Element infoElement = doc.createElement("info");
//				infoElement.setAttribute("lang", "FR");
//				//creer du text
//				Text infoTextElement = doc.createTextNode("Capitaine Corsaire");	
//				//ajouter le text dans la balise color
//				infoElement.appendChild(infoTextElement);
//				
//		
//		//ajouter la bailise color dans la balise sailor
//		sailor.appendChild(colorElement);
//		sailor.appendChild(firstnameElement);
//		sailor.appendChild(lastnameElement);
//		sailor.appendChild(infoElement);
//	
		//creation d'un factory pour transformer le doc en un domsource utile pour le transformer
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(docu);
		StreamResult result = new StreamResult(new File("file.xml"));
		//le transformer mes le doc dans le xml en xml.
		transformer.transform(source, result);
		
		
		
	
	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
