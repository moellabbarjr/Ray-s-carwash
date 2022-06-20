import java.io.StringReader;

@Path("../src/main/webapp/files/afspraak.html")
public class customersResource{

    @POST
    @Produces("../json/afspraken.json")
    public String createCustomer(String jsonbody){
        JsonObjectBuilder responseObject = Json.createObjectBuilder();
        Company company = company.getCompany();

        try{
            StringReader strReader = new StringReader(jsonbody);
            JsonReader jsonReader = Json.createReader(strReader);
            JsonObject jsonObject = jsonReader.readObject();

            String voornaam = jsonObject.getString("voornaam");
            String achternaam  = jsonObject.getString("achternaam");
            String kenteken = jsonObject.getString("kenteken");
            String type = jsonObject.getString("type");
            String email = jsonObject.getString("email");
            String nummer = jsonObject.getString("nummer");
            company.createCustomer(voornaam,achternaam,kenteken,type,email,nummer);

            responseObject.add("Message:", "afspraak aangemaakt");
        }catch(Exception e){
            responseObject.add("message", "error: " + e.getMessage());
        }

        return responseObject.build.toString();
    }
}