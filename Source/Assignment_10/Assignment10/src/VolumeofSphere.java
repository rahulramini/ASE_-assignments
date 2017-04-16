

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/volumeofsphere")
public class VolumeofSphere {
	@GET
	@Produces("application/xml")
	public String volume_of_sphere() {
 
		Double volume;
		Double radius = 7.0;
		volume = (4 * 22 * radius * radius * radius)/(7*3);
 
		String result = "@Produces(\"application/xml\") Output: \n\nVolume of the sphere Output: \n\n" + volume;
		return "<VolumeOfSphere>" + "<radius>" + radius + "</radius>" + "<volumeoutput>" + result + "</volumeoutput>" + "</VolumeOfSphere>";
	}
 
	@Path("{r}")
	@GET
	@Produces("application/xml")
	public String volume_of_sphere(@PathParam("r") Double r) {
 
		Double volume;
		Double radius = r;
		volume = (4 * 22 * radius * radius * radius)/(7*3);
 
		String result = "@Produces(\"application/xml\") Output: \n\nVolume of the sphere Output: \n\n" + volume;
		return "<VolumeOfSphere>" + "<radius>" + radius + "</radius>" + "<volumeoutput>" + result + "</volumeoutput>" + "</VolumeOfSphere>";
	}}

