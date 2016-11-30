package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MotorcycleService {
	private static MotorcycleService instance;

	public static MotorcycleService getInstance() {
		if (instance == null) {
			instance = new MotorcycleService();
		}
		return instance;
	}

	private List<Motorcycle> motorcycleList = new ArrayList<>();

	public MotorcycleService() {
		for (int i = 0; i < 50; i++) {
			motorcycleList.add(new Motorcycle("Kawazaki", "Ninja", 340, 120, 2017));
			motorcycleList.add(new Motorcycle("Yamaha", "Ziruk", 1000, 200, 1990));
			motorcycleList.add(new Motorcycle("Ducati", "Smith", 400, 40, 2003));
			motorcycleList.add(new Motorcycle("Harley-Davidson", "NotChopper", 100, 10, 2015));
			motorcycleList.add(new Motorcycle("Honda", "Civic", 30, 2, 2010));
		}
	}

	public List<Motorcycle> getMotorcycles() {
		return Collections.unmodifiableList(motorcycleList);
	}

	public void addMotorcycle(Motorcycle motorcycle) {
		motorcycleList.add(motorcycle);
	}

	public PagedResponse getMotorcyclesInPagesFiltered(int page, int perPage, String withBrand) {
		long previousEntries = page * perPage;
		List<Motorcycle> pageOfMotorcycles = motorcycleList.stream()
				.filter((u) -> u.getBrand().equals(withBrand) || withBrand == null || "".equals(withBrand))
				.skip(previousEntries).limit(perPage).collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) motorcycleList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfMotorcycles, page, totalPages);

		return response;
	}

	public List<String> getAllDistinctMotorcycleBrands() {
		return motorcycleList.stream()
				.map((u) -> u.getBrand())
				.distinct()
				.collect(Collectors.toList());
	}
}