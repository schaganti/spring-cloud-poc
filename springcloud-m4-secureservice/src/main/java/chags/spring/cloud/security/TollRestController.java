package chags.spring.cloud.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TollRestController {

	@RequestMapping("/tolldata")
	public List<TollUsage> getTollData() {

		return Arrays.asList(new TollUsage("1", "station1", "license1", "ts1"),
				new TollUsage("2", "station2", "license2", "ts2"), new TollUsage("3", "station3", "license3", "ts3"),
				new TollUsage("4", "station4", "license4", "ts4"));
	}

	public static class TollUsage {

		String id;
		String stationId;
		String licensePlate;
		String timestamp;

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
