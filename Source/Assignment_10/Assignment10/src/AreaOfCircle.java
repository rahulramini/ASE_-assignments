import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/areaofcircle")
public class AreaOfCircle {
	@GET
	@Produces("application/xml")
	public String area_of_circle() {
 
		Double area;
		Double radius = 7.0;
		area = (22 * radius * radius)/7;
 
		String result = "@Produces(\"application/xml\") Output: \n\nArea of the circle Output: \n\n" + area;
		return "<areaofcircle>" + "<radius>" + radius + "</radius>" + "<areaoutput>" + result + "</areaoutput>" 
				+ "</areaofcircle>";
	}
 
	@Path("{r}")
	@GET
	@Produces("application/xml")
	public String area_of_circle(@PathParam("r") Double r) {
 
		Double area;
		Double radius = r;
		area = (22 * radius * radius)/7;
 
		String result = "@Produces(\"application/xml\") Output: \n\nArea of the circle Output: \n\n" + area;
		return "<areaofcircle>" + "<radius>" + radius + "</radius>" + "<areaoutput>" + result + "</areaoutput>" 
				+ "</areaofcircle>";	}}

