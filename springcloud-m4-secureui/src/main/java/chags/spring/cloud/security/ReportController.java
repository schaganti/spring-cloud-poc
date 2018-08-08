package chags.spring.cloud.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {

	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@Autowired
	OAuth2RestTemplate restTemplate;

	@RequestMapping("/")
	public String loadHome() {
		return "home";
	}

	@RequestMapping("/reports")
	public String reports(Model model) {
		System.out.println("Oauth token - " + oauth2ClientContext.getAccessToken().getValue());
		ResponseEntity<List<TollUsage>> reponseEntity = restTemplate.exchange(
				"http://localhost:9000/services/getTollData", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TollUsage>>() {
				});
		model.addAttribute("tolls", reponseEntity.getBody());
		return "reports";
	}

	public static class TollUsage {

		String id;
		String stationId;
		String licensePlate;
		String timestamp;

		public TollUsage() {

		}

		public TollUsage(String id, String stationId, String licensePlate, String timestamp) {
			super();
			this.id = id;
			this.stationId = stationId;
			this.licensePlate = licensePlate;
			this.timestamp = timestamp;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getStationId() {
			return stationId;
		}

		public void setStationId(String stationId) {
			this.stationId = stationId;
		}

		public String getLicensePlate() {
			return licensePlate;
		}

		public void setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

	}
}
