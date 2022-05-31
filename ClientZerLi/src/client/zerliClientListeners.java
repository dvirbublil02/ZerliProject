package client;

public interface zerliClientListeners {
	default void ipConfirmedForClient() {
		return;
	}

	default void ipNotConfirmedForClient() {
		return;
	}

	default void userIsCustomer() {
		return;
	}
	default void userIsBranchManager() {
		return;
	}

	default void userIsCustomerService() {
		return;
	}

	default void userIsDeliveryAgent(){
		return;
	}

	default void userIsMarketingWorker(){
		return;
	}

	default void userIsNetworkManager(){
		return;
	}

	default void userIsServiceExpert(){
		return;
	}

	default void userIsShopWorker(){
		return;
	}

	default void notifyCustomerService() {
		return;
	}

}
