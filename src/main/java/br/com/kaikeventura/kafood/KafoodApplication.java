package br.com.kaikeventura.kafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafoodApplication {

//	@Autowired
//	private ClientRepository clientRepository;
//	@Autowired
//	private DeliveryManRepository deliveryManRepository;
//	@Autowired
//	private PaymentOrderRepository paymentOrderRepository;
//	@Autowired
//	private RestaurantRepository restaurantRepository;
//	@Autowired
//	private MenuItemRepository menuItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(KafoodApplication.class, args);
	}

//	@PostConstruct
//	public void run() {
//		var client = clientRepository.findById(1L).orElseThrow(() -> new RuntimeException("Not Found client"));
//		var deliveryMan = deliveryManRepository.findById(1L).orElseThrow(() -> new RuntimeException("Not Found delivery man"));
//		var restaurant = restaurantRepository.findById(1L).orElseThrow(() -> new RuntimeException("Not Found restaurant"));
//		var menuItems = new HashSet<>(menuItemRepository.findAll());
//
//		paymentOrderRepository.save(new PaymentOrder(sumTotalPrice(menuItems), client, deliveryMan, Form.CREDIT.paymentForm(), restaurant, menuItems));
//
//		System.out.println("oi");
//	}
//
//	private BigDecimal sumTotalPrice(final Set<MenuItem> menuItems) {
//		return BigDecimal.valueOf(menuItems.stream().mapToDouble(menuItem -> Double.parseDouble(menuItem.getPrice().toString())).sum());
//	}

}
