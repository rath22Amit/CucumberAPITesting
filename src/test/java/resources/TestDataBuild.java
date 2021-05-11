package resources;

import java.util.ArrayList;
import java.util.List;

import pojoClass.POJO_AddPlace;
import pojoClass.POJO_Location;

public class TestDataBuild {
	public POJO_AddPlace addPlacePayload() {
		POJO_AddPlace p =new POJO_AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline house");
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		POJO_Location l =new POJO_Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		p.setLocation(l);
		return p;
	}
}
