package client;

public interface zerliClientListeners {
	default void ipConfirmedForClient() {
		return;
	}

	default void ipNotConfirmedForClient() {
		return;
	}

}
