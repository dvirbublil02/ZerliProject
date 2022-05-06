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

}
