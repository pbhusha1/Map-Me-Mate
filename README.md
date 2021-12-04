Steps to run the Map-Me-Mate Application

1)	Install Fuseki and run on localhost :3030.
2)	Install all the three ontology owl files given i.e. Aparments.owl , ApartmentAmenities.owl and TemporaryLeasingPerson.owl.
3)	Add the following Prefixes in order to test the query,.
PREFIX apt: <http://www.semanticweb.org/Apartment#>
PREFIX Temp: <http://www.semanticweb.org/TemporaryLeasingPerson#>
PREFIX ApartAmen: <http://www.semanticweb.org/ApartmentAmenities#>
4)	Run the following Query and below is a snapshot of the expected output

PREFIX apt: <http://www.semanticweb.org/Apartment#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
PREFIX Temp: <http://www.semanticweb.org/TemporaryLeasingPerson#>
PREFIX ApartAmen: <http://www.semanticweb.org/ApartmentAmenities#>

SELECT Distinct ?Name ?IDA
WHERE {
  ?APT rdf:type apt:Apartment.
  ?APT apt:hasApartmentID ?IDA.
  ?APT apt:hasApartmentName ?Name.
  ?APT apt:isAroundUniversity ?UNIV.
  ?UNIV apt:hasUniversityID ?UNIID.
  ?UNIV apt:hasUniversityName ?UNAME
  
  filter(?UNAME="Purdue University")
}
5) Download the file and follow the  structure below
6)![image](https://user-images.githubusercontent.com/90433862/144720559-73a851c3-e075-4cb6-9fc3-0f9044bb9b20.png)

7)Right click on the file MapMeMateApplication.java and select Run As - Java Application and the application will run on Localhost:8080 and make sure you have localhost:3030 running aswell

