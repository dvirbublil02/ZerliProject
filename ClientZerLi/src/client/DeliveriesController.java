package client;

import entities_general.DeliveryPreview;

public class DeliveriesController {
	private static DeliveryPreview deliveryItems;

	public static DeliveryPreview getDelivery() {
		return deliveryItems;
	}

	public static void setDelivery(DeliveryPreview delivery) {
		DeliveriesController.deliveryItems = delivery;
	}
	
}
